package edu.brown.cs32.goingrogue.graphics;

import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.BRONZE;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.IRON;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.MITHRIL;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.STEEL;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.WOOD;

import java.util.List;

import org.newdawn.slick.Color;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;

/** Takes in an item or creature and returns various properties it should have when displayed as text
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class TextHandler {
	
	public static String getText(Creature c) {
		
		List<String> text=new ArrayList<>();
		
		//Materials
		if(c.containsAttribute(STEEL)) {
			text.add("Steel");
		} else if(c.containsAttribute(IRON)) {
			text.add("Iron");
		} else if(c.containsAttribute(BRONZE)) {
			text.add("Bronze");
		} else if(c.containsAttribute(WOOD)) {
			text.add("Wood");
		} else if(c.containsAttribute(MITHRIL)) {
			text.add("Mithril");
		}
		
		//Elements
		if(c.containsAttribute(FIRE_TYPE)) {
			text+=""
		}
	}
	
	public static String getText(Item i) {
		return getText(i.getGridItem());
	}
	
	public static Color getColor() {
		
	}
}
