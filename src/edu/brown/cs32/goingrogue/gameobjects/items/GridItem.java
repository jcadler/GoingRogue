package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class GridItem extends Creature {

    private boolean _pickedUp = false;

    public GridItem(Point2D pos, int health, List<Attribute> attributes, int pxPerMove, String spritePath) {
        super(pos, health, attributes, pxPerMove, spritePath);
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

    public abstract void act(Creature creature);
}
