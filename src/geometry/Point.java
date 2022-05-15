package geometry;
/**
 * The class defines the object Point , the object fields are x and y which are doubles .
 * @author Erez Gilat
 */

public class Point {
    private double x;
    private double y;
    /**
     * constructor.
     * the function gets a point and create a new point with the x and y value.
     * @param x (double).
     * @param y (double).
     */
    public Point(double x, double y) {
        this.x =  x;
        this.y =  y;
    }
    /**
     * @param other (Point)
     * @return the distance between this.point to other (double).
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }

    /**
     * @param other (Point).
     * @return boolean , if the points are equal , the function will return true , otherwise it will return false.
     */
    public boolean equals(Point other) {
        if (other.getY() == this.y && other.getX() == this.x) {
            return true;
        }
        return false;
    }
    /**
     * @return the x value of a point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return the y value of a point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * the function gets a X value of a point and sets the current point X value (this.x) to X).
     * @param x1 .
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * the function gets a Y value of a point and sets the current point Y value (this.y) to Y).
     * @param y1 .
     */
    public void setY(double y1) {
        this.y = y1;
    }
    /**
     * @return String "(x_value,y_value)"
     */
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
