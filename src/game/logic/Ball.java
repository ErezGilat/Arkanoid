package game.logic;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;

import java.awt.Color;

/**
 * The class defines the object Ball , the object fields are centre (Point) ,r which is the radius ,color of the ball
 *  and v which is the Velocity of the ball.
 * @author Erez Gilat
 */

public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnv;
    private Sprite s;
    /**
     * constructor.
     * The function creates a new ball with a new velocity of (0,0) , the color parameter and a point of the center
     * which is the center .
     * @param gameEnv .
     * @param center .
     * @param r radius.
     * @param color .
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnv) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnv = gameEnv;
        v = new Velocity(0, 0);
    }
    /**
     * @return x value of the center
     */
    public double getX() {
        return this.center.getX();
    }
    /**
     * @return y value of the center
     */
    public double getY() {
        return this.center.getY();
    }
    /**
     * the function gets x value and set the current ball's center x value to x.
     * @param x .
     */
    public void setX(int x) {
        this.center.setX(x);
    }
    /**
     * the function gets y value and set the current ball's center y value to y.
     * @param y .
     */
    public void setY(int y) {
        this.center.setY(y);
    }

    /**
     * @return the size of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * The function draw the ball on the given DrawSurface.
     * @param surface .
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), this.r);
    }
    @Override
    public void timePassed() {
        moveOneStep();
    }
    /**
     * the function gets a Velocity (v) and changes the ball velocity to the parameter .
     * @param vi .
     */
    public void setVelocity(Velocity vi) {
        this.v.setDx(vi.getDx());
        this.v.setDy(vi.getDy());
    }

    /**
     * the function gets a Velocity but its dx and dy values and changes the ball velocity to the parameter .
     * @param dx .
     * @param dy .
     */
    public void setVelocity(double dx, double dy) {
        v.setDx(dx);
        v.setDy(dy);
    }
    /**
     * removing this ball from the game.
     * @param gameLevel .
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
    /**
     * @return the ball velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }
    /**
     * the function move the ball by calling to the app.
     */
    public void moveOneStep() {
        Point endPoint = this.v.applyToPoint(this.center);
        Line trajectory = new Line(this.center, endPoint);
        CollisionInfo info = gameEnv.getClosestCollision(trajectory);
        if (info != null) {
            this.v = info.collisionObject().hit(this, info.collisionPoint(), this.v);
        }
        this.center = this.v.applyToPoint(this.center);
    }
    /**
     * The function adds a ball to the game onto the spirit collection.
     * @param gameLevel .
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
