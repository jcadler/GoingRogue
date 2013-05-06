package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class CloneTest {

    @Test
    public void testClone() {
        Point2D.Double pos = new Point2D.Double(-1657.84, 8.9905);
        double direction = Math.PI / 2.0;
        String name = "booba";
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.AXE);
        attributes.add(Attribute.MITHRIL);
        CreatureStats stats = new CreatureStats(0.88, 748.8, 44, 927.89, 948.0);
        String spritePath = "footouht";
        CreatureSize size = new CreatureSize(9, 4);
        List<Creature> creatures = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        Creature creature = new AICreature(pos, direction, name, attributes, stats,
                spritePath, size, creatures, rooms);
        try {
            Creature clonedCreature = creature.createNewInstance();
            assertTrue(creature.equals(clonedCreature));
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
    }
}
