package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import java.awt.geom.Point2D;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface CreatureFactory {
    public Creature create(Point2D pos, String name, CreatureStats stats);
}
