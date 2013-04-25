package edu.brown.cs32.goingrogue.gameobjects.items.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Point2D;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface GridItemFactory {
    public Creature create(Point2D pos);
    public Creature create();
}
