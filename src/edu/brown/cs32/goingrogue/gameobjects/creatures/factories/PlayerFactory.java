package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
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
    public Creature create(Point2D pos) {
        int health = 100;
        List<Attribute> attributes = new ArrayList<>();
        int pxPerMove = 20;
        String sprite = Constants.PLAYER_SPRITE;
        Creature returnCreature = new Player(pos, health, attributes, pxPerMove, sprite);
        return returnCreature;
    }

    @Override
    public Creature create() {
        int health = 100;
        List<Attribute> attributes = new ArrayList<>();
        int pxPerMove = 20;
        String sprite = Constants.PLAYER_SPRITE;
        Creature returnCreature = new Player(null, health, attributes, pxPerMove, sprite);
        return returnCreature;
    }
}
