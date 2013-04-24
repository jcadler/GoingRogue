package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class MoveRange implements Range {

    private Creature _sourceCreature;

    public MoveRange(Creature creature) {
        _sourceCreature = creature;
    }

    @Override
    public boolean inRange(Creature creature) {
        return creature.equals(_sourceCreature);
    }

    @Override
    public void decrementTimer() {
        // do nothing
    }
}