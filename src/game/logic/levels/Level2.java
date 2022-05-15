package game.logic.levels;

import game.logic.Block;
import game.logic.Sprite;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author Erez Gilat.
 * A instance of the object contains all the information of level 2.
 */
public class Level2 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(250 - i * 10, 4));
        }
        for (int i = 0; i < 5; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(160 - i * 10, 4));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Level2Background();
    }

    @Override
    public List<Block> blocks() {
        int red, green, blue;
        Random rand = new Random();
        Color randomColor = Color.BLACK;
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                red = rand.nextInt(255) + 0;
                green = rand.nextInt(255) + 0;
                blue = rand.nextInt(255 + 0);
                randomColor = new Color(red, green, blue);
            }
            blocks.add(new Block(new Rectangle(new Point(20 + 51 * i, 250), 51, 25, randomColor)));
        }
        return blocks;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
