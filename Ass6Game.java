//ID: 212434377
import biuoop.GUI;
import game.graphic.AnimationRunner;
import game.logic.GameFlow;
import game.logic.levels.Level1;
import game.logic.levels.Level2;
import game.logic.levels.Level3;
import game.logic.levels.Level4;
import game.logic.levels.LevelInformation;


import java.util.ArrayList;
import java.util.List;

/**
 * The class runs the game "Arknoid" as for ASS3.
 * @author Erez Gilat
 */
public class Ass6Game {
    /**
     * The function starts a new game.
     * @param args .
     */
    public static void main(String[] args) {
        int level;
        GUI g = new GUI("arkanoid", 800, 600);
        GameFlow flow = new GameFlow(new AnimationRunner(g), g.getKeyboardSensor());
        List<LevelInformation> l = new ArrayList<>();
        for (int i = 0; i <= args.length; i++) {
            try {
                level = Integer.parseInt(args[i]);
            } catch (Exception e) {
                level = 0;
            }
            if (level == 1) {
                l.add(new Level1());
            } else if (level == 2) {
                l.add(new Level2());
            } else if (level == 3) {
                l.add(new Level3());
            } else if (level == 4) {
                l.add(new Level4());
            }
        }
        if (l.size() == 0) {
            l.add(new Level1());
            l.add(new Level2());
            l.add(new Level3());
            l.add(new Level4());
        }
        flow.runLevels(l);
        g.close();
    }
}
