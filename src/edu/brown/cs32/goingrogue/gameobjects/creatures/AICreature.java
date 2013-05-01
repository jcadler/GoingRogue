package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreature extends Creature {
    
    public AICreature(Point2D.Double pos, double direction, String name, List<Attribute> attributes,
            CreatureStats stats, String spritePath, CreatureSize size) {
        super(pos, direction, name, attributes, stats, spritePath, size);
    }

    @Override
    public boolean isItem() {
        return false;
    }
}
