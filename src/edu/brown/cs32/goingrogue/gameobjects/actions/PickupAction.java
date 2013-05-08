package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PickupAction extends Action {

    private Creature _sourceCreature;

    public PickupAction(Range range, Creature sourceCreature) {
        super(0, range);
        _type = ActionType.PICKUP;
        _sourceCreature = sourceCreature;
    }

    @Override
    public void act(Creature creature) {
        ((GridItem) creature).pickUp();
        _sourceCreature.addItem(new Item((GridItem) creature));
    }

    @Override
    public List<ActionAnimation> getActionAnimations() {
        return new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this._sourceCreature);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PickupAction other = (PickupAction) obj;
        if (!Objects.equals(this._sourceCreature, other._sourceCreature)) {
            return false;
        }
        return true;
    }
}
