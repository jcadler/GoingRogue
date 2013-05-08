package edu.brown.cs32.goingrogue.gameobjects.creatures.util;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;

/**
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class XPCalculator {
	
	/** Returns the XP required to pass to the next level from the specified level
	 */
	public static int getNextLevelXP(int level) {
		return 100*(level*level + level - 1);
	}
	
	/** Returns the XP to be gained from killing a creature
	 */
	public static int getXP(Creature c) {
		
		if(c.containsAttribute(Attribute.PLAYER)) {
			return getTotalPlayerXP((Player)c);
		}
		
		else {
			Stats stats=c.getStats();
			return (int)((stats.getHealth() + 
					stats.getAttack() + 
					stats.getDefense()) /
					10.);
		}
	}
	
	static int getTotalPlayerXP(Player p) {
		int level=p.getLevel();
		
		int xp=p.getXP();
		while(level>0) {
			level--;
			xp+=getNextLevelXP(level);
		}
		
		return xp;
	}
}
