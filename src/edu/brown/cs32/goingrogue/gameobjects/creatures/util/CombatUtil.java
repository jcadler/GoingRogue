package edu.brown.cs32.goingrogue.gameobjects.creatures.util;

import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Inventory;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class CombatUtil {

    public static void incurDamage(CreatureStats attackerStats, CreatureStats targetStats,
            Inventory attackerInventory, Inventory targetInventory) {
        double attack = attackerStats.getAttack() + attackerInventory.getAttackSum();
        double defense = targetStats.getDefense() + targetInventory.getDefenseSum();
        double accuracy = attackerStats.getAccuracy() + attackerInventory.getAccuracySum();
        double speed = targetStats.getSpeed() + targetInventory.getSpeedSum();
        
        double damage = (attack / defense) + (accuracy / speed); // TODO come up with a better formula
        
        if (damage > 0) {
            targetStats.reduceHealth((int) damage);
        }
    }
}
