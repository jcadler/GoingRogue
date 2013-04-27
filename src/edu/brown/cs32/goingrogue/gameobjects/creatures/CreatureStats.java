package edu.brown.cs32.goingrogue.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class CreatureStats extends Stats {

    private double _speed; // in pixels-per-movement
    
    public CreatureStats(double attack, double defense, int health, double accuracy, double speed) {
        super(attack, defense, health, accuracy);
        _speed = speed;
    }
    
    public CreatureStats(Stats sourceStats, double speed) {
        super(sourceStats.getAttack(), sourceStats.getDefense(), sourceStats.getHealth(), sourceStats.getAccuracy());
        _speed = speed;
    }
    
    public double getSpeed() {
        return _speed;
    }
    
    public void setSpeed(double speed) {
        _speed = speed;
    }
}
