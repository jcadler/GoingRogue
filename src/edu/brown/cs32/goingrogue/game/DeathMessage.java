package edu.brown.cs32.goingrogue.game;

import java.util.ArrayList;
import java.util.List;

/** A class for storing and randomly selecting a death message
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class DeathMessage {
	
	static List<String> messages=null;
	
	public static String getRandomMessage() {
		
		if(messages==null) {
			messages=new ArrayList<>();
			messages.add("You are dead");
			messages.add("You have died");
			messages.add("You are death");
			messages.add("All is death");
			messages.add("...And that\'s the way the cookie crumbles");
			messages.add("Dead is you");
			messages.add("Death death death");
			messages.add("Quoth the raven, \"Nevermore\"");
			messages.add("NoR4U");
			messages.add("All your base are belong to us");
			messages.add("Why so death");
			messages.add("ERROR player has died, revert to start");
			messages.add("TODO insert brief life description");
			messages.add("Y so emu");
			messages.add("Ashes to ashes and dust to dust");
		}
		
		return messages.get((int)(Math.random()*messages.size()));
	}
}
