package game.logic.levels;

import game.logic.Block;
import game.logic.Sprite;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Erez Gilat.
 * A instance of the object contains all the information of level 1.
 */
public class Level1 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> list = new ArrayList<>();
        Velocity v = Velocity.fromAngleAndSpeed(180, 3);
        list.add(v);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Level1Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(387, 115), 25, 25, Color.red)));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
