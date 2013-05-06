package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.AICreature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import java.awt.geom.Point2D;
import java.util.List;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.*;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreatureFactory {

    public static AICreature create(List<Creature> creatures, List<Room> rooms) {
        double direction = Math.PI / 2.0;
        List<Attribute> attributes = randomCreatureAttributes();
        String name = getCreatureName(attributes);
        String sprite = getSprite(attributes);
        CreatureStats stats = randomCreatureStats(attributes);
        CreatureSize size = getCreatureSize(attributes);
        AICreature returnCreature = new AICreature(new Point2D.Double(0.0, 0.0), direction, name,
                attributes, stats, sprite, size);
        return returnCreature;
    }
}
