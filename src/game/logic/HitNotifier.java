//212434377
package game.logic;
/**
 * Hit Notifier interface.
 * @author Erez Gilat.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl .
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl .
     */
    void removeHitListener(HitListener hl);
}