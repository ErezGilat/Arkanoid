package game.logic;
/**
 * this class defines the Block Remover Hit listener.
 * @author Erez Gilat.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * Constructor.
     * @param gameLevel .
     * @param removedBlocks - Counter.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are been hit are being remove from the game and the function deletes also its listener.
     * @param beingHit - block.
     * @param hitter - ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}