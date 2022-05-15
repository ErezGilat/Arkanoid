package game.logic;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is a block object.
 * @author .
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private List<HitListener> hitListeners;
    /**
     * The constructor method.
     * @param rect .
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        hitListeners = new ArrayList<>();
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double minX = this.rect.getUpperLeft().getX();
        double maxX = this.rect.getUpperLeft().getX() + this.rect.getWidth();
        double minY = this.rect.getUpperLeft().getY();
        double maxY = this.rect.getUpperLeft().getY() + this.rect.getHeight();
        if ((collisionPoint.getX() == minX  && collisionPoint.getY() == minY)
                || (collisionPoint.getX() == maxX && collisionPoint.getY() == minY)
                || (collisionPoint.getX() == minX && collisionPoint.getY() == maxY)
                || (collisionPoint.getX() == maxX && collisionPoint.getY() == maxY)) {
            this.notifyHit(hitter);
            return new Velocity(-1 * currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        if (collisionPoint.getX() >= maxX || collisionPoint.getX() <= minX || equals(collisionPoint.getX(), minX)
                || equals(collisionPoint.getX(), maxX)) {
            this.notifyHit(hitter);
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (collisionPoint.getY() >= maxY || collisionPoint.getY() <= minY || equals(collisionPoint.getY(), minY)
                || equals(collisionPoint.getY(), maxY)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(),  -1 * currentVelocity.getDy());
        }
        return currentVelocity;
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
    @Override
    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawOn(d);
    }
    @Override
    public void timePassed() {
    }
    /**
     * The function adds a block to the game to the Collidable list and to the Sprite list.
     * @param gameLevel .
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }
    /**
     * the function removes the block from the game.
     * @param gameLevel .
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * The function notify the hit listener (this.hitlisteners) that an hit event as occurred.
     * @param hitter .
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
