package game.logic.levels;

import biuoop.DrawSurface;
import game.logic.Block;
import game.logic.GameLevel;
import game.logic.Sprite;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
/**
 * @author Erez Gilat.
 * The background of level 3.
 */
public class Level3Background implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        new Block(new Rectangle(new Point(0, 0), 800, 600, new Color(53, 141, 74))).drawOn(d);
    }
    @Override
    public void timePassed() {
    }
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
