package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class GridWeapon extends GridItem {

    public GridWeapon(Point2D pos, String name, List<Attribute> attributes, ItemStats stats, String spritePath) {
        super(pos, name, attributes, stats, spritePath);
    }
}
