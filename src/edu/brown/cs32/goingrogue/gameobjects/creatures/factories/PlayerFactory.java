package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridWeaponFactory;
import edu.brown.cs32.goingrogue.graphics.GraphicsPaths;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PlayerFactory {

    public static Player create(List<Creature> creatures, List<Room> rooms) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(PLAYER);
        String sprite = GraphicsPaths.CHAR_1.path; // TODO fill this in later
        CreatureSize size = new CreatureSize(1.0, 1.0);
        Player returnCreature = new Player(new Point2D.Double(0.0, 0.0), Math.PI / 2.0, "Bob",
                attributes, Constants.STARTING_PLAYER_STATS, sprite, size);
        returnCreature.addItem(new Item(GridWeaponFactory.create(creatures, rooms)));
        returnCreature.setShouldRotate(true);
        return returnCreature;
    }
}
