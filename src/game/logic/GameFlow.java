package game.logic;

import biuoop.KeyboardSensor;
import game.graphic.AnimationRunner;
import game.graphic.EndScreen;
import game.graphic.KeyPressStoppableAnimation;
import game.logic.levels.LevelInformation;

import java.util.List;

/**
 * @author Erez Gilat.
 */
public class GameFlow {
    private static final int INITIAL_LIVES = 7;
    private KeyboardSensor ks;
    private AnimationRunner ar;
    private Counter score;
    private Counter numberOfLives;
    /**
     * Constructor.
     * @param ar - Animation runner.
     * @param ks - Keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = new Counter();
        numberOfLives = new Counter();
        numberOfLives.increase(INITIAL_LIVES);
    }
    /**
     * The function runs the levels that are in the list.
     * @param levels 0 - List of levels info.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, this.ar.getGui(), score, numberOfLives);
            level.initialize();
            level.run();
            if (numberOfLives.getValue() < 0) {
                ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        new EndScreen(this.score, "Game over.")));
                System.exit(0);
            }
        }
        ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                new EndScreen(this.score, "You win!")));
        System.exit(0);
    }
}
