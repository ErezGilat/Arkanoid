package game.graphic;

import biuoop.DrawSurface;
import game.logic.GameLevel;
import game.logic.Sprite;

import java.awt.Color;

/**
 * @author Erez Gilat.
 * The class is in charge of showing the name in the top of the screen.
 */
public class NameIndictaor implements Sprite {
    private String name;
    /**
     * Constructor.
     * @param name - String.
     */
    public NameIndictaor(String name) {
        this.name = name;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(600, 18, "Level Name:" + this.name, 12);
    }
    @Override
    public void timePassed() {
    }
    @Override
    public final void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
