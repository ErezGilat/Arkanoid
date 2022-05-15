package game.graphic;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Erez Gilat.
 * The class runs the animation of the game.
 */
public class AnimationRunner {
    static final int KILO = 1000;
    private GUI gui;
    private int framesPerSecond = 60;
    private Sleeper sleeper = new Sleeper();
    /**
     * Constructor.
     * @param gui - GUI.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }
    /**
     * Running the game.
     * @param animation - Animation of the current stage of the game.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = KILO / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * @return the gui.
     */
    public GUI getGui() {
        return this.gui;
    }
}
