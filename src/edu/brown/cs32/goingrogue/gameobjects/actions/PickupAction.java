package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import java.awt.geom.Point2D;

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

    @Override
    public ActionAnimation getActionAnimation() {
        String spritePath = null;
        Point2D.Double pos = new Point2D.Double(0.0, 0.0);
        double angle = 0.0;
        return new ActionAnimation(spritePath, pos, angle);
    }
}
