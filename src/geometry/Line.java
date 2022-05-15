package geometry; //ID: 212434377
import java.util.List;

/**
 * The class defines the object Line , the object fields are x1,y1 and x2,and y2 which are doubles.
 * @author Erez Gilat
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     * the function gets two points ,one which is a starting point of a line and the other is the end of the line,
     * the function creates a new Line object.
     * @param start , the starting point of a line.
     * @param end , the ending point of a line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * @return the length of the line
     */
    public double length() {
        return Math.sqrt(Math.pow(this.start.getX() - this.end.getX(), 2)
                + Math.pow(this.start.getY() - this.end.getY(), 2));
    }
    /**
     * @return the middle point of the line
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }
    /**
     * @return the starting point of a line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return the ending point of a line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * @param other (Line).
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }
    /**
     * @param other (Line).
     * @return Returns the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double m1 = ((end.getY() - start.getY()) / (end.getX() - start.getX()));
        double m2 = ((other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX()));
        double b1 = start.getY() - m1 * start.getX();
        double b2 = other.start().getY() - m2 * other.start().getX();
        if (m1 == m2) {
            return null;
        }
        double x, y;
        if (Double.isInfinite(m1)) {
            x = start.getX();
            y =  m2 * x + b2;
        } else if (Double.isInfinite(m2)) {
            x = other.start.getX();
            y = m1 * x + b1;
        } else {
            x = (b2 - b1) / (m1 - m2);
            y = m1 * x + b1;
        }
        Point p = new Point(x, y);
        if (!isPointOnLIne(p) || !other.isPointOnLIne(p)) {
            return null;
        }
        return p;
    }

    /**
     * @param p (Point).
     * @return the function returns whether or not the point is on the line.
     */
    public boolean isPointOnLIne(Point p) {
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minY = Math.min(this.start.getY(), this.end.getY());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        double x = p.getX();
        double y = p.getY();
        if ((x >= minX || equals(x, minX)) && (x <= maxX || equals(x, maxX))
                && (y >= minY || equals(y, minY)) && (y <= maxY || equals(y, maxY))) {
            return true;
        }
        return false;
    }
    /**
     * The function returns whether or not the numbers are equal in the range of epsilon.
     * @param x (double).
     * @param y (double).
     * @return boolean.
     */
    private boolean equals(double x, double y) {
        double epsilon = 0.001;
        return Math.abs(x - y) < epsilon;
    }
    /**
     * @param other (Line).
     * @return equals -- return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start().equals(other.start()) && this.end().equals(other.end())
                || (this.end().equals(other.start()) && this.start().equals(other.end()))) {
            return true;
        }
        return false;
    }
    /**
     * @param rect (Rectangle).
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        Point closet = list.get(0);
        double minDistance = list.get(0).distance(this.start());
        for (Point p : list) {
            double currentD = p.distance(this.start());
            if (minDistance > currentD) {
                closet = p;
                minDistance = currentD;
            }
        }
        return closet;
    }
}
