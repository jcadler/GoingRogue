package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ItemStats extends Stats {

    private double _reloadRate;
    
    public ItemStats(double attack, double defense, double health, double accuracy, double reloadRate) {
        super(attack, defense, health, accuracy);
        _reloadRate = reloadRate;
    }

    public double getReloadRate() {
        return _reloadRate;
    }

    public void setReloadRate(double reloadRate) {
        _reloadRate = reloadRate;
    }
}
