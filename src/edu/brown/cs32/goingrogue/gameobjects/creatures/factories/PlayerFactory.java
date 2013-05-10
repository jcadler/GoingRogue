package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.PLAYER;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridWeaponFactory;
import edu.brown.cs32.goingrogue.graphics.GraphicsPaths;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

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
        CreatureStats cs = Constants.STARTING_PLAYER_STATS;
        CreatureStats rs = new CreatureStats(cs.getAttack(), cs.getDefense(), cs.getHealth(),
        		cs.getAccuracy(), cs.getSpeed());
        Player returnCreature = new Player(new Point2D.Double(0.0, 0.0), Math.PI / 2.0, "Bob",
                attributes, rs, sprite, size);
        returnCreature.addItem(new Item(GridWeaponFactory.create(creatures, rooms)));
        returnCreature.setShouldRotate(true);
        return returnCreature;
    }
}
