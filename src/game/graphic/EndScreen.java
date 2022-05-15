package game.graphic;

import biuoop.DrawSurface;
import game.logic.Counter;
/**
 * @author Erez Gilat.
 * The class is in charge of showing the end screen methode of the game.
 */
public class EndScreen implements Animation {
    private Counter score;
    private String message;
    /**
     * Constructor.
     * @param score - Counter
     * @param message -String.
     */
    public EndScreen(Counter score, String message) {
        this.score = score;
        this.message = message + " Your score is " + this.score.getValue();
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, message, 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
