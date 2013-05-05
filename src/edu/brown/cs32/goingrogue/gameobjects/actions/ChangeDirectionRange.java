package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ChangeDirectionRange implements Range {
    
    private Creature _sourceCreature;
    
    public ChangeDirectionRange(Creature sourceCreature) {
        _sourceCreature = sourceCreature;
    }

    @Override
    public boolean inRange(Creature creature) {
        return creature.equals(_sourceCreature);
    }

    @Override
    public void decrementTimer(int delta) {
        // do nothing
    }
}
