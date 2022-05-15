package game.graphic;

import biuoop.DrawSurface;
import game.logic.Counter;
import game.logic.GameLevel;
import game.logic.Sprite;

import java.awt.Color;

/**
 * @author Erez Gilat.
 * he class is in charge of showing how many "lives" left.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;
    /**
     * Constructor.
     * @param lives - Counter.
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(80, 18, "Lives:" + this.lives.getValue(), 12);
    }
    @Override
    public void timePassed() {
        //Does nothing.
    }
    @Override
    public final void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
