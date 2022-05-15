package game.graphic; //ID: 212434377

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Erez Gilat.
 * An instancte of this class is in charge of waiting to a press on the key board space bar.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private boolean stop;
    private Animation animation;
    private boolean isAlreadyPressed = true;
    /**
     * Constructor.
     * @param sensor - Sensor.
     * @param key - String.
     * @param animation - Animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
