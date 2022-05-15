package game.logic;
/**
 * Printing when a block on the screen is being hit.
 * @author Erez Gilat.
 */
public class PrintingHitListener implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}
