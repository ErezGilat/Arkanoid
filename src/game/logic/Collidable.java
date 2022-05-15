package game.logic;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * A collidable object interface.
 * @author Erez Gilat.
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint .
     * @param currentVelocity .
     * @param hitter .
     * @return the velocity after the collision.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
