package geometry;
/**
 * The class defines the object Velocity , the object fields are dx and dy which are doubles .
 * @author Erez Gilat
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * constructor.
     * The function gets dx and dy values (double) and creates new velocity.
     * @param dx .
     * @param dy .
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The function gets a dx value and change this.dx to dx.
     * @param dX .
     */
    public void setDx(double dX) {
        this.dx = dX;
    }

    /**
     * The function gets a dy value and change this.dy to dy.
     * @param dY .
     */
    public void setDy(double dY) {
        this.dy = dY;
    }
    /**
     * The function returns the dx value of a velocity.
     * @return dx (double).
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * The function returns the dy value of a velocity.
     * @return dy (double).
     */
    public double getDy() {
        return dy;
    }
    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p current point.
     * @return Point new location.
     */
    public Point applyToPoint(Point p) {
       return new Point(p.getX() + dx, p.getY() + dy);
    }
    /**
     * @param angle .
     * @param speed .
     * @return new velocity which its dx and dy are deriving from the speed and angle (vector).
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle);
        return new Velocity(dx, dy);
    }
    /**
     * @return the speed of an object.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }
}
