package edu.brown.cs32.goingrogue.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreature extends Creature {
    
    public AICreature(Point2D pos, String name, List<Attribute> attributes, CreatureStats stats, String spritePath) {
        super(pos, name, attributes, stats, spritePath);
    }

    @Override
    public boolean isItem() {
        return false;
    }
}