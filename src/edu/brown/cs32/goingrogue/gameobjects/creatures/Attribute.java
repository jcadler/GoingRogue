package edu.brown.cs32.goingrogue.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public enum Attribute {

    // to distinguish items from other creatures
    ITEM,
    // types of items
    WEAPON,
    ARMOUR,
    SHIELD,
    POTION,
    SWORD,
    AXE,
    WAR_HAMMER,
    SPEAR,
    // materials of items
    STEEL,
    IRON,
    BRONZE,
    WOOD,
    MITHRIL,
    // elemental types
    FIRE, // beats earth, loses to water
    WATER, // beats fire, loses to earth
    EARTH, // beats water, loses to fire
    AIR, // neutral
    // type of monster
    PLAYER,
    EMU,
    DRAGON,
    HOB_GOBLIN,
    GIANT,
    SNAKE,
    DOG
}