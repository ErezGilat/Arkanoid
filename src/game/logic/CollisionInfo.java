package game.logic;

import geometry.Point;

/**
 * The class defines a new object called Collision Info.
 * @author Erez Gilat.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable c;

    /** the point at which the collision occurs.
     * @param collisionPoint .
     * @param c .
     */
    public CollisionInfo(Point collisionPoint, Collidable c) {
        this.collisionPoint = collisionPoint;
        this.c = c;
    }
    /**
     * @return the collision Point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.c;
    }
}
