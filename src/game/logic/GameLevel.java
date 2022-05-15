package game.logic;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import game.graphic.Animation;
import game.graphic.AnimationRunner;
import game.graphic.PauseScreen;
import game.graphic.KeyPressStoppableAnimation;
import game.graphic.ScoreIndicator;
import game.graphic.NameIndictaor;
import game.graphic.LivesIndicator;
import game.graphic.CountdownAnimation;
import game.logic.levels.LevelInformation;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import java.awt.Color;
import java.util.List;


/**
 * The class defines a Game object.
 * @author Erez Gilat.
 */
public class GameLevel implements Animation {

    private static final Point BALL_START_POS = new Point(400, 540);
    private Counter numOfLives;
    private Counter score;
    private GUI gui;
    private KeyboardSensor ks;
    private AnimationRunner runner;
    private LevelInformation levelInfo;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private boolean running;
    private Counter ballCounter;
    private Paddle paddle;
    private Counter blockCounter;
    /**
     * Constructor.
     * @param levelInfo - Level information.
     * @param ks - keyboard Sensor.
     * @param ar - Animation runner.
     * @param gui - GUI.
     * @param score - Counter.
     * @param numberOfLives - Counter.
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor ks, AnimationRunner ar, GUI gui, Counter score,
                     Counter numberOfLives) {
        this.levelInfo = levelInfo;
        this.ks = ks;
        this.runner = ar;
        this.gui = gui;
        this.score = score;
        this.numOfLives = numberOfLives;
    }
    /**
     * Adding Sollidable object to the game environment.
     * @param c .
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * Adding a Sprite to the sprite collection.
     * @param s .
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * The function removes the collidable object from the sprite collection.
     * @param c - collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeColi(c);
    }
    /**
     * The function removes the sprite object from the sprite collection.
     * @param s - sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSpr(s);
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.ballCounter = new Counter();
        ballCounter.increase(this.levelInfo.numberOfBalls());
        this.blockCounter = new Counter();
        blockCounter.increase(levelInfo.numberOfBlocksToRemove());
        environment = new GameEnvironment();
        sprites = new SpriteCollection();
        levelInfo.getBackground().addToGame(this);
        HitListener blockRemover = new BlockRemover(this, blockCounter);
        List<Block> blocks = levelInfo.blocks();
        HitListener scoreTracker = new ScoreTrackingListener(score);
        for (Block block : blocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTracker);
            block.addToGame(this);
        }
        fillBorders();
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        scoreIndicator.addToGame(this);
        LivesIndicator livesIndicator = new LivesIndicator(numOfLives);
        livesIndicator.addToGame(this);
        new NameIndictaor(levelInfo.levelName()).addToGame(this);
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        paddle = new Paddle(new Rectangle(new Point(400 - this.levelInfo.paddleWidth() / 2, 550),
                this.levelInfo.paddleWidth(), 20, Color.yellow),
                new Velocity(levelInfo.paddleSpeed(), 0), gui);
        paddle.addToGame(this);
        while (numOfLives.getValue() > 0 && blockCounter.getValue() > 0) {
            playOneTurn();
        }
    }
    /**
     * Fill the borders of the screen with blocks.
     */
    public final void fillBorders() {
        HitListener ballRemover = new BallRemover(this, ballCounter);
        //TOP BLOCK
        new Block(new Rectangle(new Point(0, 0), 800, 20, Color.gray)).addToGame(this);
        //LEFT BLOCK
        new Block(new Rectangle(new Point(0, 20), 20, 580, Color.gray)).addToGame(this);
        //RIGHT BLOCK
        new Block(new Rectangle(new Point(780, 20), 20, 580, Color.gray)).addToGame(this);
        //BALL "KILLER" BLOCK
        Block killerBlock = new Block(new Rectangle(new Point(20, 595), 760, 5, Color.gray));
        killerBlock.addToGame(this);
        killerBlock.addHitListener(ballRemover);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
        if (this.blockCounter.getValue() == 0) {
            score.increase(100);
            this.running = false;
        }
        if (this.ballCounter.getValue() == 0) {
            this.numOfLives.decrease(1);
            if (numOfLives.getValue() == 0) {
                this.running = false;
            } else {
                playOneTurn();
            }
        }
        if (this.ks.isPressed("p")) {
            this.runner.run(
                    new KeyPressStoppableAnimation(this.ks,
                            KeyboardSensor.SPACE_KEY,
                            new PauseScreen()));
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * Runs a single turn of the game (spawns the balls and plays until they
     * all get removed).
     */
    private void playOneTurn() {
        paddle.setX(400 - this.levelInfo.paddleWidth() / 2);
        List<Velocity> velocities = levelInfo.initialBallVelocities();
        int i = 0;
        for (Velocity velocity : velocities) {
            Ball ball = new Ball(new Point(BALL_START_POS.getX() + i * 7, BALL_START_POS.getY()),
                    5, Color.red, environment);
            ball.setVelocity(velocity);
            ball.addToGame(this);
            i++;
        }
        if (ballCounter.getValue() == 0) {
            ballCounter.increase(this.levelInfo.numberOfBalls());
        }
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(4, 3, sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
}
