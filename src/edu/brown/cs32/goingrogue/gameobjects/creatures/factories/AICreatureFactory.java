package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import java.awt.geom.Point2D;
import java.util.List;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.*;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreatureFactory implements CreatureFactory {

    @Override
    public Creature create() {
        List<Attribute> attributes = randomCreatureAttributes();
        String name = getCreatureName(attributes);
        String sprite = getSprite(attributes);
        CreatureStats stats = randomCreatureStats(attributes);
        Creature returnCreature = new Player(new Point2D.Double(0.0, 0.0), name, attributes, stats, sprite);
        return returnCreature;
    }
}
