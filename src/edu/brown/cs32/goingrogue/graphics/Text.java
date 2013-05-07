package edu.brown.cs32.goingrogue.graphics;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.Type;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;

/** A class that handles the printing of attributes for a creature or item
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class Text {
	
	String text;
	Color color;
	
	public Text(String t, Color c) {
		text=t;
		color=c;
	}
	
	public String getText() {
		return text;
	}
	
	public Color getColor() {
		return color;
	}
	
	
	//Static methods for creating Text objects from items and creatures
	
	//Stores the reverse of the order in which attributes should be printed out
	static List<Type> typePriorities=null;
	
	static int getPriority(Type type) {
		
		//Initializes the priorities list
		if(typePriorities==null) {
			typePriorities=new ArrayList<>();
			typePriorities.add(type.MATERIAL);
			typePriorities.add(type.ELEMENT);
			typePriorities.add(type.ITEM);
			typePriorities.add(type.CREATURE);
		}
		
		return typePriorities.indexOf(type);
	}
	
	public static Text getText(Item i) {
		return getText(i.getGridItem());
	}
	
	public static Text getText(Creature c) {
		
		if(c==null) return new Text("", Color.white);
		
		List<Attribute> attsToDisplay=new ArrayList<>();
		for(Attribute a: c.getAttributes()) {
			int priority=getPriority(a.type);
			if(!(priority==-1)) {
				while(attsToDisplay.size()<=priority) attsToDisplay.add(null);
				attsToDisplay.set(priority, a);
			}
		}
		
		String text="";
		Color color=Color.white;
		for(Attribute a: attsToDisplay) if(a!=null) {
			text+=a.text+" ";
			if(a.color!=null) {
				color=a.color;
			}
		}
		
		//Takes off the trailing space at the end
		if(!text.isEmpty()) text=text.substring(0, text.length()-1);
		
		return new Text(text, color);
	}
}
