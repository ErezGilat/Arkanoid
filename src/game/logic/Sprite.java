package game.logic; //ID:212434377
import biuoop.DrawSurface;

/**
 * Interface of Sprite objecgt.
 */
public interface Sprite {
    /**
     * the function draws a Sprite on the board.
     * @param d .
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
    /**
     * Adding a Sprite to the Game Level.
     * @param gameLevel .
     */
    void addToGame(GameLevel gameLevel);
}