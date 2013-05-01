package edu.brown.cs32.goingrogue.gameobjects.actions;

import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/** 
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Action {

	protected ActionType _type;
	
    private int _timer;
    private Range _range;

    public Action(int timer, Range range) {
    	_timer = timer;
        _range = range;
    }
    
    public ActionType type() {
    	return _type;
    }

    public Creature actOnClone(Creature creature) throws CloneNotSupportedException {
        Creature clone = creature.createNewInstance();
        act(clone);
        return clone;
    }
    
    public int getTimer() {
        return _timer;
    }

    public void decrementTimer(int delta) {
        _timer -= delta;
        _range.decrementTimer(delta);
    }
    
    public boolean withinRange(Creature creature) {
        return _range.inRange(creature);
    }
    
    public Range getRange() {
        return _range;
    }

    public abstract void act(Creature creature);
    public abstract List<ActionAnimation> getActionAnimations();
}