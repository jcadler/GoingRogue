package edu.brown.cs32.bweedon.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PickupAction extends Action {
    
    private Creature _sourceCreature;
    
    public PickupAction(int timer, Range range, Creature sourceCreature) {
        super(timer, range);
        _sourceCreature = sourceCreature;
    }

    @Override
    public void act(Creature creature) {
        if (creature.isItem()) {
            ((GridItem) creature).pickUp();
            _sourceCreature.addItem(new Item((GridItem) creature));
        }
    }
}
