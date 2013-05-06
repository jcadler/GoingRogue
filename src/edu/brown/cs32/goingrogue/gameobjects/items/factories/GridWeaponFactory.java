package edu.brown.cs32.goingrogue.gameobjects.items.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.getItemName;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.getSprite;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.randomItemStats;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class GridWeaponFactory {

    public static GridItem create(List<Creature> creatures, List<Room> rooms) {
        List<Attribute> attributes = getWeaponAttributes();
        String name = getItemName(attributes);
        String sprite = getSprite(attributes);
        ItemStats stats = randomItemStats(attributes);
        CreatureSize size = new CreatureSize(1.0, 1.0);
        GridItem returnCreature = new GridItem(new Point2D.Double(0.0, 0.0),
                name, attributes, stats, sprite, size);
        return returnCreature;
    }

    private static List<Attribute> getWeaponAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(WEAPON);
        Random generator = new Random(System.currentTimeMillis());
        int choice = generator.nextInt(4);
        switch (choice) {
            case 0:
                attributes.add(SWORD);
                break;
            case 1:
                attributes.add(AXE);
                break;
            case 2:
                attributes.add(WAR_HAMMER);
                break;
            case 3:
                attributes.add(SPEAR);
                break;
        }
        return attributes;
    }
}
