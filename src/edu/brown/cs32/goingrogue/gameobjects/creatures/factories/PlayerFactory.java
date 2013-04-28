package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.PLAYER;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.graphics.GraphicsPaths;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PlayerFactory {

    public static Player create() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(PLAYER);
        String sprite = ""; // TODO fill this in later
        Player returnCreature = new Player(new Point2D.Double(0.0, 0.0), Math.PI / 2.0, "Bob",
                attributes, null, sprite);
        return returnCreature;
    }
}
