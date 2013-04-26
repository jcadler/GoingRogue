package edu.brown.cs32.goingrogue.gameobjects.items.factories;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.GridWeapon;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class GridSwordFactory implements GridItemFactory {

    @Override
    public Creature create(Point2D pos, String name, ItemStats stats) {
        List<Attribute> attributes = new ArrayList<>();
        String sprite = Constants.SWORD_SPRITE;
        GridItem returnItem = new GridWeapon(pos, name, attributes, stats, sprite);
        return returnItem;
    }
}
