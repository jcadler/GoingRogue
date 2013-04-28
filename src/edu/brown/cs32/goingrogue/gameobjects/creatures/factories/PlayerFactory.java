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

    public Creature create(Point2D pos, String name, CreatureStats stats) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(PLAYER);
        String sprite = GraphicsPaths.PLAYER_SPRITE;
        Creature returnCreature = new Player(new Point2D.Double(0.0, 0.0), name, attributes, stats, sprite);
        return returnCreature;
    }
}
