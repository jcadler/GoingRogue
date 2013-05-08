package edu.brown.cs32.goingrogue.gameobjects.creatures;

import org.newdawn.slick.Color;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public enum Attribute {

    // to distinguish items from other creatures
    ITEM("Item", null, Type.IDENTIFIER),
    // types of items
    WEAPON("Weapon", null, Type.IDENTIFIER),
    ARMOUR("Armour", null, Type.ITEM),
    SHIELD("Shield", null, Type.ITEM),
    HELMET("Helmet", null, Type.ITEM),
    BOOTS("Boots", null, Type.ITEM),
    POTION_TYPE("", null, Type.ITEM),
    SWORD("Sword", null, Type.ITEM),
    AXE("Axe", null, Type.ITEM),
    WAR_HAMMER("Warhammer", null, Type.ITEM),
    SPEAR("Spear", null, Type.ITEM),
    //types of potion
    ATTACK_POTION("Attack Potion", new Color(38, 212, 58), Type.POTION),
    DEFENSE_POTION("Defense Potion", new Color(255, 150, 0), Type.POTION),
    HEALTH_POTION("Health Potion", Color.red, Type.POTION),
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
    PLAYER("Player", null, Type.CREATURE),
    EMU("Emu", null, Type.CREATURE),
    DRAGON("Dragon", null, Type.CREATURE),
    HOB_GOBLIN("Hobgoblin", null, Type.CREATURE),
    GIANT("Giant", null, Type.CREATURE),
    SNAKE("Snake", null, Type.CREATURE),
    DOG("Dog", null, Type.CREATURE);
    
    //Orders each of these attributes by type
    public static enum Type {
    	IDENTIFIER, ITEM, MATERIAL, ELEMENT, CREATURE, POTION;
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