package game.graphic; //212434377

import biuoop.DrawSurface;
import biuoop.Sleeper;
import game.logic.SpriteCollection;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private int current;

    /**
     * Constructor.
     * @param numOfSeconds - double.
     * @param countFrom - integer.
     * @param gameScreen - Sprite collection.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.current = countFrom;
        sleeper = new Sleeper();
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        d.drawText(380, 300, Integer.toString(current), 50);
        if (current != 3) {
            this.sleeper.sleepFor((long) ((numOfSeconds / countFrom) * 1000));
        }
        current -= 1;
    }
    @Override
    public boolean shouldStop() {
        if (current < 0) {
            return true;
        }
        return false;
    }
}