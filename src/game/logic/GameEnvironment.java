package game.logic; //ID:212434377

import geometry.Line;
import geometry.Point;

import java.util.ArrayList;

/**
 * The class defines a Game Environment object.
 */
public class GameEnvironment {
    private ArrayList<Collidable> coliList;
    /**
     * Constructor.
     */
    public GameEnvironment() {
        this.coliList = new ArrayList<>();
    }
    /**
     * add the given collidable to the environment.
     * @param c .
     */
    public void addCollidable(Collidable c) {
        if (this.coliList == null) {
            this.coliList = new ArrayList<Collidable>();
        }
        this.coliList.add(c);
    }
    /**
     * @return the list of the colidable object.
     */
    public ArrayList<Collidable> getColiList() {
        return this.coliList;
    }
    /**
     * removing a colidable object from the list.
     * @param c - Colidable.
     */
    public void removeColi(Collidable c) {
        this.coliList.remove(c);
    }
    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory .
     * @return Collision Info.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point coliPoint;
        int indexMin = -1;
        double minDistance = -1;
        for (int i = 0; i < coliList.size(); i++) {
            coliPoint = trajectory.closestIntersectionToStartOfLine(this.coliList.get(i).getCollisionRectangle());
            if (coliPoint == null) {
                continue;
            }
            double currentDistance = coliPoint.distance(trajectory.start());
            if (minDistance > currentDistance || indexMin == -1) {
                minDistance = currentDistance;
                indexMin = i;
            }
        }
        if (indexMin == -1) {
            return null;
        }
        return new CollisionInfo(trajectory.closestIntersectionToStartOfLine(
                this.coliList.get(indexMin).getCollisionRectangle()), this.coliList.get(indexMin));
    }
}
