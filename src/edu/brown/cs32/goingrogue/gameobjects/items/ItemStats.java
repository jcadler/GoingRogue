package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ItemStats extends Stats {

    private double _reloadRate;
    
    public ItemStats(double attack, double defense, int health, double accuracy, double speed, double reloadRate) {
        super(attack, defense, health, accuracy, speed);
        _reloadRate = reloadRate;
    }
    
    public ItemStats(CreatureStats stats, double reloadRate) {
        super(stats.getAttack(), stats.getDefense(), stats.getHealth(), stats.getAccuracy(), stats.getSpeed());
        _reloadRate = reloadRate;
    }

    public double getReloadRate() {
        return _reloadRate;
    }

    public void setReloadRate(double reloadRate) {
        _reloadRate = reloadRate;
    }
}
