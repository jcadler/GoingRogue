package edu.brown.cs32.goingrogue.gameobjects.creatures;

import org.newdawn.slick.Color;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public enum Attribute {

    // to distinguish items from other creatures
    ITEM("Item", Color.white, Type.IDENTIFIER),
    // types of items
    WEAPON("Weapon", Color.white, Type.IDENTIFIER),
    ARMOUR("Armour", Color.white, Type.ITEM),
    SHIELD("Shield", Color.white, Type.ITEM),
    POTION("Potion", Color.white, Type.ITEM),
    SWORD("Sword", Color.white, Type.ITEM),
    AXE("Axe", Color.white, Type.ITEM),
    WAR_HAMMER("Warhammer", Color.white, Type.ITEM),
    SPEAR("Spear", Color.white, Type.ITEM),
    // materials of items
    STEEL("Steel", Color.lightGray, Type.MATERIAL),
    IRON("Iron", Color.darkGray, Type.MATERIAL),
    BRONZE("Bronze", new Color(255, 183, 50), Type.MATERIAL),
    WOOD("Wood", new Color(150, 104, 29), Type.MATERIAL),
    MITHRIL("Mithril", new Color(150, 255, 255), Type.MATERIAL),
    // elemental types
    FIRE_TYPE("Fire", Color.red, Type.ELEMENT), // beats earth, loses to water
    WATER_TYPE("Water", Color.blue, Type.ELEMENT), // beats fire, loses to earth
    EARTH_TYPE("Earth", new Color(140, 75, 20), Type.ELEMENT), // beats water, loses to fire
    AIR_TYPE("Air", Color.lightGray, Type.ELEMENT), // neutral
    // type of monster
    PLAYER("Player", Color.white, Type.CREATURE),
    EMU("Emu", Color.white, Type.CREATURE),
    DRAGON("Dragon", Color.white, Type.CREATURE),
    HOB_GOBLIN("Hobgoblin", Color.white, Type.CREATURE),
    GIANT("Giant", Color.white, Type.CREATURE),
    SNAKE("Snake", Color.white, Type.CREATURE),
    DOG("Dog", Color.white, Type.CREATURE);
    
    //Orders each of these attributes by type
    static enum Type {
    	IDENTIFIER, ITEM, MATERIAL, ELEMENT, CREATURE;
    }
    
    public final String text;
    public final Color color;
    public final Type type;
    
    Attribute(String tx, Color c, Type t) {
    	text=tx;
    	color=c;
    	type=t;
    }
    
    
}