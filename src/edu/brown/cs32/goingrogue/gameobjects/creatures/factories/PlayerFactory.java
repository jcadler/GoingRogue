package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PlayerFactory implements CreatureFactory {

    @Override
    public Creature create(Point2D pos, String name, CreatureStats stats) {
        List<Attribute> attributes = new ArrayList<>();
        String sprite = Constants.PLAYER_SPRITE;
        Creature returnCreature = new Player(pos, name, attributes, stats, sprite);
        return returnCreature;
    }
}
