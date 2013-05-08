package edu.brown.cs32.goingrogue.gameobjects.creatures.util;

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
			typePriorities.add(Type.MATERIAL);
			typePriorities.add(Type.ELEMENT);
			typePriorities.add(Type.ITEM);
			typePriorities.add(Type.POTION);
			typePriorities.add(Type.CREATURE);
		}
		
		return typePriorities.indexOf(type);
	}
	
	public static Text getText(Item i) {
		
		if(i==null) return new Text("", Color.white);
		
		return getText(i.getGridItem());
	}
	
	public static Text getText(Creature c) {
		
		if(c==null) return new Text("", Color.white);
		
		return getText(c.getAttributes());
	}
	
	public static Text getText(List<Attribute> attsToDisplay) {
		for(int i=0; i<attsToDisplay.size(); i++) {
			Attribute a=attsToDisplay.get(i);
			int priority=getPriority(a.type);
			if(!(priority==-1)) {
				while(attsToDisplay.size()<=priority) attsToDisplay.add(null);
				attsToDisplay.set(priority, a);
			}
		}
		
		String text="";
		Color color=Color.white;
		for(Attribute a: attsToDisplay) if(a!=null) {
			if(!a.text.isEmpty()) {
				text+=a.text+" ";
			}
			if(a.color!=null) {
				color=a.color;
			}
		}
		
		//Takes off the trailing space at the end
		if(!text.isEmpty()) text=text.substring(0, text.length()-1);
		
		return new Text(text, color);
	}
}
