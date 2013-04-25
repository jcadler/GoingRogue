package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Point2D;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface CreatureFactory {
    public Creature create();
    public Creature create(Point2D pos);
}
