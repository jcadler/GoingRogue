package edu.brown.cs32.bweedon.gameobjects.creatures;

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