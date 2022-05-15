package game.graphic;

import biuoop.DrawSurface;
/**
 * @author Erez Gilat.
 * The class is in charge of showing the pause methode of the game.
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}