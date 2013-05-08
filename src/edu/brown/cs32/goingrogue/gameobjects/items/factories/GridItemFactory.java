package edu.brown.cs32.goingrogue.gameobjects.items.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.*;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class GridItemFactory {

    public static GridItem create(List<Creature> creatures, List<Room> rooms, int playerLevel) {
        List<Attribute> attributes = randomItemAttributes();
        String name = getItemName(attributes);
        String sprite = getSprite(attributes);
        ItemStats stats = randomItemStats(attributes);
        CreatureSize size = new CreatureSize(1.0, 1.0);
        GridItem returnCreature = new GridItem(new Point2D.Double(0.0, 0.0),
                name, attributes, stats, sprite, size);
        return returnCreature;
    }
}
