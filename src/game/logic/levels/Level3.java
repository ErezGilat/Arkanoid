package game.logic.levels;

import game.logic.Block;
import game.logic.Sprite;
import geometry.Point;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author Erez Gilat.
 * A instance of the object contains all the information of level 3.
 */
public class Level3 implements LevelInformation {
    static final int BLOCK_WIDTH = 45, BLOCK_HEIGHT = 25;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(150, 5));
        velocities.add(Velocity.fromAngleAndSpeed(230, 5));
        return velocities;
    }
    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green Screen";
    }

    @Override
    public Sprite getBackground() {
        return new Level3Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int red, green, blue;
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            red = rand.nextInt(225) + 1;
            green = rand.nextInt(225) + 1;
            blue = rand.nextInt(225 + 1);
            Color randomColor = new Color(red, green, blue);
            for (int j = 0; j < 12 - i; j++) {
                blocks.add(new Block(new geometry.Rectangle(new Point(240 + j * BLOCK_WIDTH + BLOCK_WIDTH * i,
                        150 + i * (BLOCK_HEIGHT + 1)), BLOCK_WIDTH, BLOCK_HEIGHT, randomColor)));
            }
        }
        return blocks;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return 63;
    }
}
