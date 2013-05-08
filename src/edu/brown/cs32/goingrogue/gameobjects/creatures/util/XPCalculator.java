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
	
	public static int getXP(Creature c) {
		
		if(c.containsAttribute(Attribute.PLAYER)) {
			Player p=(Player)c;
			return p.getXP();
		}
		
		else {
			Stats stats=c.getStats();
			return (int)(stats.getHealth() + 
					stats.getAttack() + 
					stats.getDefense());
		}
	}
}
