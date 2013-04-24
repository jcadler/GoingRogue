package edu.brown.cs32.bweedon.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PickupRange implements Range {
    
    private Creature _sourceCreature;
    private final double PICKUP_RANGE = 10.0;
    
    public PickupRange(Creature sourceCreature) {
        _sourceCreature = sourceCreature;
    }

    @Override
    public boolean inRange(Creature creature) {
        if (!creature.isItem()) {
            return false;
        }
        return (_sourceCreature.getPosition().distance(creature.getPosition()) <= PICKUP_RANGE);
    }

    @Override
    public void decrementTimer() {
        // do nothing
    }
}
