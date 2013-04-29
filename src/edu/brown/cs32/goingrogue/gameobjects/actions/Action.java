package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

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
        Creature clone = creature.createNewInstance();
        act(clone);
        return clone;
    }
    
    public int getTimer() {
        return _timer;
    }

    public void decrementTimer() {
        --_timer;
        _range.decrementTimer();
    }
    
    public boolean withinRange(Creature creature) {
        return _range.inRange(creature);
    }
    
    public Range getRange() {
        return _range;
    }

    public abstract void act(Creature creature);
    public abstract ActionAnimation getActionAnimation();
}