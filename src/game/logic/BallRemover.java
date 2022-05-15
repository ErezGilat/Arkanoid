package game.logic;
/**
 * this class defines the Ball Remover Hit listener.
 * @author Erez Gilat.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter currentBalls;
    /**
     * Constructor.
     * @param gameLevel .
     * @param balls -counter.
     */
    public BallRemover(GameLevel gameLevel, Counter balls) {
        this.gameLevel = gameLevel;
        this.currentBalls = balls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        currentBalls.decrease(1);
    }
}
