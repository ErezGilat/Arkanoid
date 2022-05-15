package game.logic; //ID:212434377

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;


/**
 * The class defines a Paddle object.
 * @author Erez Gilat.
 */
public class Paddle implements Collidable, Sprite {
    private Rectangle rect;
    private Velocity v;
    private KeyboardSensor keyboard;
    static final int MIN_X_VALUE = 23;
    static final int MAX_X_VALUE = 775;
    /**
     * Constructor method.
     * @param rect .
     * @param v .
     * @param g .
     */
    public Paddle(Rectangle rect, Velocity v, GUI g) {
        this.rect = rect;
        this.v = v;
        keyboard = g.getKeyboardSensor();
    }
    /**
     * The function moves the paddle to left.
     */
    public void moveLeft() {
        if (rect.getUpperLeft().getX()  >= MIN_X_VALUE) {
            this.rect.setUpperLeft(
                    new Point(this.rect.getUpperLeft().getX() - v.getDx(), this.rect.getUpperLeft().getY()));
        }
    }
    /**
     * The function moves the paddle to right.
     */
    public void moveRight() {
        if (rect.getUpperLeft().getX() + rect.getWidth() <= MAX_X_VALUE) {
            this.rect.setUpperLeft(
                    new Point(this.rect.getUpperLeft().getX() + v.getDx(), this.rect.getUpperLeft().getY()));
        }
    }
    // Sprite
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double gap = rect.getWidth() / 5;
        double  minX1 = this.rect.getUpperLeft().getX(),
                maxX1 = minX1 + gap, minX2 = maxX1,
                maxX2 = minX2 + gap, minX3 = maxX2, maxX3 = minX3 + gap,
                minX4 = maxX3, maxX4 = minX4 + gap, minX5 = maxX4, maxX5 = minX5 + gap;
        if (collisionPoint.getX() <= maxX1) {
            return Velocity.fromAngleAndSpeed(230, currentVelocity.getSpeed());
        } else if (collisionPoint.getX() <= maxX2) {
            return Velocity.fromAngleAndSpeed(200, currentVelocity.getSpeed());
        } else if (collisionPoint.getX() <= maxX3) {
            return Velocity.fromAngleAndSpeed(180, currentVelocity.getSpeed());
        } else if (collisionPoint.getX() <= maxX4) {
            return Velocity.fromAngleAndSpeed(160, currentVelocity.getSpeed());
        } else if (collisionPoint.getX() <= maxX5) {
            return Velocity.fromAngleAndSpeed(140, currentVelocity.getSpeed());
        }
        return currentVelocity;
    }
    /**
     * The function adds a block to the game to the Collidable list and to the Sprite list.
     * @param gameLevel .
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }
    @Override
    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawOn(d);
    }
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * Setting the x value of the paddle top left point.
     * @param x - double.
     */
    public void setX(double x) {
        this.rect.setUpperLeft(new Point(x, this.rect.getUpperLeft().getY()));
    }
}