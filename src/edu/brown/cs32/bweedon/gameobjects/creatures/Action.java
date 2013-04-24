package edu.brown.cs32.bweedon.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Action {

    private int _timer;
    private Range _range;

    public Action(int timer, Range range) {
        _timer = timer;
        _range = range;
    }

    public Creature actOnClone(Creature creature) throws CloneNotSupportedException {
        Creature clone = creature.clone();
        act(clone);
        return clone;
    }

    public void decrementTimer() {
        --_timer;
        _range.decrementTimer();
    }

    public abstract void act(Creature creature);
}