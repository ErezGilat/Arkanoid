package game.graphic;

import biuoop.DrawSurface;
/**
 * @author Erez Gilat.
 * The animation interface that help us with the animation on the screen.
 */
public interface Animation {
    /**
     * The function draws one frame of the animation.
     * @param d - draw surface.
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return if the animation should stop.
     */
    boolean shouldStop();
}