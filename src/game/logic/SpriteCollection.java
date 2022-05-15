package game.logic;
import biuoop.DrawSurface;
import java.util.ArrayList;
/**
 * The class is an object of Sprites list.
 * @author Erez Gilat.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprList;
    /**
     * Constructor function for the object.
     */
    public SpriteCollection() {
        this.sprList = new ArrayList<>();
    }
    /**
     * the function adds a new sprite to the list.
     * @param s (Sprite).
     */
    public void addSprite(Sprite s) {
        this.sprList.add(s);
    }
    /**
     * The function removes the Sprite from the current collection.
     * @param s - sprite.
     */
    public void removeSpr(Sprite s) {
        this.sprList.remove(s);
    }
    // call timePassed() on all sprites.
    /**
     * the function notify all the Spirte(s) that a time period as passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprList.size(); i++) {
            sprList.get(i).timePassed();
        }
    }
    /**
     * @return the function returns a Sprite list.
     */
    public ArrayList<Sprite> getSprList() {
        return this.sprList;
    }
    // call drawOn(d) on all sprites.
    /**
     * The function draws all the sprite on the surface.
     * @param d (DrawSurface).
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprList.size(); i++) {
            this.sprList.get(i).drawOn(d);
        }
    }
}
