package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class GridItem extends Creature {

    private boolean _pickedUp = false;
    private ItemStats _stats;

    public GridItem(Point2D pos, String name, List<Attribute> attributes, ItemStats stats, String spritePath) {
        super(pos, name, attributes, new CreatureStats(stats, 0), spritePath);
        _stats = stats;
    }

    @Override
    public void incurDamage(int damage) {
        // do nothing
    }

    @Override
    public int getHealth() {
        if (_pickedUp) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isItem() {
        return true;
    }

    public void pickUp() {
        _pickedUp = true;
    }
}
