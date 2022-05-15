package game.logic.levels;

import game.logic.Block;
import game.logic.Sprite;
import geometry.Velocity;

import java.util.List;
/**
 * @author Erez Gialt.
 * The following interface helps us with making new levels.
 */
public interface LevelInformation {
    /**
     * @return the number of balls in the level.
     */
    int numberOfBalls();
    /**
     * @return he initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     */
    List<Velocity> initialBallVelocities();
    /**
     * @return the paddle speed in the level.
     */
    int paddleSpeed();
    /**
     * @return the width of the paddle in the level.
     */
    int paddleWidth();
    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();
    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    /**
     * @return The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    List<Block> blocks();
    /**
     * @return Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * his number should be <= blocks.size();
     */
    int numberOfBlocksToRemove();
}
