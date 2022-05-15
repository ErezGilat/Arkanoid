package game.logic.levels;

import biuoop.DrawSurface;
import game.logic.GameLevel;
import game.logic.Sprite;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.util.Random;
/**
 * @author Erez Gilat.
 * The background of level 2.
 */
public class Level2Background implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Random rand = new Random();
        new Rectangle(new Point(0, 0), 800, 600, new Color(32, 92, 217)).drawOn(d);
        Color sunOuter = new Color(255, 250, 150), sunMiddle = new Color(255, 245, 50),
                sunInner = new Color(255, 239, 0);
        d.setColor(new Color(255, 250, 170));
        for (int i = 0; i < 30; i++) {
            d.drawLine(100, 140, rand.nextInt(780) + 20, 250);
        }
        d.setColor(sunOuter);
        d.fillCircle(100, 140, 60);
        d.setColor(sunMiddle);
        d.fillCircle(100, 140, 50);
        d.setColor(sunInner);
        d.fillCircle(100, 140, 40);
    }
    @Override
    public void timePassed() {
    }
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
