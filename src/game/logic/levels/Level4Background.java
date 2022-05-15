package game.logic.levels;

import biuoop.DrawSurface;
import game.logic.GameLevel;
import game.logic.Sprite;

/**
 * @author Erez Gilat.
 * The background of level 4.
 */
public class Level4Background implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
    }
    @Override
    public void timePassed() {
    }
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
