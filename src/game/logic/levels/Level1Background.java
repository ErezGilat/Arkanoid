package game.logic.levels;

import biuoop.DrawSurface;
import game.logic.GameLevel;
import game.logic.Sprite;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;
/**
 * @author Erez Gilat.
 * The background of level 1.
 */
public class Level1Background implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        new Rectangle(new Point(0, 0), 800, 600, Color.black).drawOn(d);
        d.setColor(Color.blue);
        d.drawLine(280, 125, 380, 125);
        d.drawLine(520, 125, 420, 125);
        d.drawLine(400, 15, 400, 110);
        d.drawLine(400, 145, 400, 250);
        d.drawCircle(400, 130, 100);
        d.drawCircle(400, 130, 70);
        d.drawCircle(400, 130, 40);
    }
    @Override
    public void timePassed() {
    }
    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
