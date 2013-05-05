package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.AICreature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.awt.geom.Point2D;
import org.junit.Test;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ArcAttackRangeTest {

    @Test
    public void testInRange() {
        Point2D.Double c1Pos = new Point2D.Double(0.0, 0.0);
        CreatureSize c1Size = new CreatureSize(1.0, 1.0);
        Creature c1 = new AICreature(c1Pos, Math.PI / 2.0, "Bob", null, null, null, c1Size);
        Point2D.Double c2Pos = new Point2D.Double(0.0, 1.0);
        CreatureSize c2Size = new CreatureSize(1.0, 1.0);
        Creature c2 = new AICreature(c2Pos, (3.0 * Math.PI) / 2.0, "John", null, null, null, c2Size);

        Action a1 = new ArcAttackAction(Math.PI / 2.0, 2.0, Math.PI / 2.0, 20, c2);
        while (a1.getTimer() >= 0) {
            if (a1.getRange().inRange(c1)) {
                assertTrue(true);
                return;
            }
            a1.decrementTimer(1);
        }
        assertTrue(false);

        Action a2 = new ArcAttackAction(Math.PI / 2.0, 2.0, Math.PI / 2.0, 20, c1);
        while (a2.getTimer() >= 0) {
            if (a2.getRange().inRange(c2)) {
                assertTrue(true);
                return;
            }
            a2.decrementTimer(1);
        }
        assertTrue(false);

        Action a3 = new ArcAttackAction((3.0 * Math.PI) / 2.0, 2.0, Math.PI / 2.0, 20, c1);
        while (a3.getTimer() >= 0) {
            if (a3.getRange().inRange(c2)) {
                assertTrue(true);
                return;
            }
            a3.decrementTimer(1);
        }
        assertTrue(false);

        Action a4 = new ArcAttackAction(Math.PI / 2.0, 0.5, Math.PI / 2.0, 20, c2);
        while (a4.getTimer() >= 0) {
            if (a4.getRange().inRange(c1)) {
                assertTrue(true);
                return;
            }
            a4.decrementTimer(1);
        }
        assertTrue(false);

        Action a5 = new ArcAttackAction(Math.PI / 2.0, 0.5001, Math.PI / 2.0, 999999, c2);
        while (a5.getTimer() >= 0) {
            if (a5.getRange().inRange(c1)) {
                assertTrue(true);
                return;
            }
            a5.decrementTimer(1);
        }
        assertTrue(false);
        
        Action a6 = new ArcAttackAction(Math.PI / 2.0, 2.0, Math.PI / 20.0, 20, c2);
        while (a6.getTimer() >= 0) {
            if (a6.getRange().inRange(c1)) {
                assertTrue(true);
                return;
            }
            a6.decrementTimer(1);
        }
        assertTrue(false);
        
        Action a7 = new ArcAttackAction(Math.PI / 2.0, 2.0, Math.PI / 999999.0, 20, c2);
        while (a7.getTimer() >= 0) {
            if (a7.getRange().inRange(c1)) {
                assertTrue(true);
                return;
            }
            a7.decrementTimer(1);
        }
        assertTrue(false);
    }
    
    @Test
    public void testAngleOnUpdate() {
    	
    	Point2D.Double c1Pos = new Point2D.Double(0.0, 0.0);
        CreatureSize c1Size = new CreatureSize(1.0, 1.0);
        Creature c1 = new AICreature(c1Pos, Math.PI / 2.0, "Bob", null, null, null, c1Size);
        Point2D.Double c2Pos = new Point2D.Double(0.0, 1.0);
        CreatureSize c2Size = new CreatureSize(1.0, 1.0);
        Creature c2 = new AICreature(c2Pos, (3.0 * Math.PI) / 2.0, "John", null, null, null, c2Size);
    	
    	ArcAttackAction a1 = new ArcAttackAction(Math.PI / 2.0, 2.0, Math.PI / 20.0, 20, c1);
    }
}
