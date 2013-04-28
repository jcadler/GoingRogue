package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ItemStats extends Stats {

    private double _reloadRate;
    private double _range;
    // next two only really useful for weapons
    private double _arcLength;
    private int _attackTimer;
    
    public ItemStats(double attack, double defense, int health, double accuracy,
            double speed, double reloadRate, double range, double arcLength, int attackTimer) {
        super(attack, defense, health, accuracy, speed);
        _reloadRate = reloadRate;
        _range = range;
        _arcLength = arcLength;
        _attackTimer = attackTimer;
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
    
    public double getRange() {
        return _range;
    }
    
    public void setRange(double range) {
        _range = range;
    }
    
    public double getArcLength() {
        return _arcLength;
    }
    
    public void setArcLength(double arcLength) {
        _arcLength = arcLength;
    }
    
    public int getAttackTimer() {
        return _attackTimer;
    }
    
    public void setAttackTimer(int attackTimer) {
        _attackTimer = attackTimer;
    }
}
