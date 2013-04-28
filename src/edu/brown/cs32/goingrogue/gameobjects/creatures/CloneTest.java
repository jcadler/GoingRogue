package edu.brown.cs32.goingrogue.gameobjects.creatures;

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
        Point2D pos = new Point2D.Double(-1657.84, 8.9905);
        String name = "booba";
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.AXE);
        attributes.add(Attribute.MITHRIL);
        CreatureStats stats = new CreatureStats(0.88, 748.8, 44, 927.89, 948.0);
        String spritePath = "footouht";
        Creature creature = new AICreature(pos, name, attributes, stats, spritePath);
        try {
            Creature clonedCreature = creature.createNewInstance();
            assertTrue(creature.equals(clonedCreature));
        } catch (CloneNotSupportedException e) {
            assertTrue(false);
        }
    }
}
