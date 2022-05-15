package game.graphic;

import biuoop.DrawSurface;
import game.logic.Counter;
import game.logic.GameLevel;
import game.logic.Sprite;

import java.awt.Color;
/**
 * The class helps as with displaying a score on the screen.
 * @author Erez Gilat.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    /**
     * Constructor.
     * @param score - Counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    @Override
    public final void drawOn(final DrawSurface d) {
        d.setColor(Color.white);
        d.drawText(370, 18, "Score: " + score.getValue(), 12);
    }
    @Override
    public void timePassed() {
        //Doing nothing.
    }
    /**
     * The function adds a score indicator to the game as a sprite.
     * @param g - game.
     */
    public final void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
