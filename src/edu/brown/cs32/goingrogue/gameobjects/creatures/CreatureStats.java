package edu.brown.cs32.goingrogue.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class CreatureStats extends Stats {
	
	int _maxHealth;
	
    public CreatureStats(double attack, double defense, int health, double accuracy, double speed) {
        super(attack, defense, health, accuracy, speed);
        
        _maxHealth=health;
    }

    public CreatureStats(Stats sourceStats) {
        super(sourceStats.getAttack(), sourceStats.getDefense(), sourceStats.getHealth(), sourceStats.getAccuracy(), sourceStats.getSpeed());
    }
    
    
}
