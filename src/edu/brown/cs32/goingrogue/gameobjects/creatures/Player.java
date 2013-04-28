package edu.brown.cs32.goingrogue.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Player extends Creature {

    public Player(Point2D pos, String name, List<Attribute> attributes, CreatureStats stats, String sprite) {
        super(pos, name, attributes, stats, sprite);
    }

    @Override
    public void incurDamage(CreatureStats attackerStats, Inventory attackerInventory) {
        
    }

    @Override
    public boolean isItem() {
        return false;
    }
    
    
}