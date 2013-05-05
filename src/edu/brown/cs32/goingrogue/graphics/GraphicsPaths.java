package edu.brown.cs32.goingrogue.graphics;

/**
 * An enum for storing the paths to the images/animations needed in Rogue Stores
 * the paths to directories, not images themselves Some paths store superpaths
 * to help with layered organization (eg. creatures <- monsters <-
 * [monstername])
 *
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public enum GraphicsPaths {

	GRAPHICS("graphics/"),
	
	//A 20x20 empty image
	EMPTY("empty.png", GRAPHICS),
	
	SCENERY("scenery/", GRAPHICS),
		GROUND("ground.png", SCENERY),
		WATER("water.png", SCENERY),
		WALLS("walls/", SCENERY),
			WALL_N("N.png", WALLS),
			WALL_S("S.png", WALLS),
			WALL_E("E.png", WALLS),
			WALL_W("W.png", WALLS),
			WALL_NE("NE.png", WALLS),
			WALL_NW("NW.png", WALLS),
			WALL_SE("SE.png", WALLS),
			WALL_SW("SW.png", WALLS),
	
	CREATURES("creatures/", GRAPHICS),
		CHARACTERS("characters/", CREATURES),
			CHAR_1("", CHARACTERS),
			CHAR_2("", CHARACTERS),
			CHAR_3("", CHARACTERS),
			CHAR_4("", CHARACTERS),
		MONSTERS("monsters/", CREATURES),
			BAT_SPRITE("bat/", MONSTERS),
			SLIME_SPRITE("snake/", MONSTERS),
			EMU_SPRITE("slime/", MONSTERS),
			DRAGON_SPRITE("slime/", MONSTERS),
			HOB_GOBLIN_SPRITE("emu/", MONSTERS),
			GIANT_SPRITE("slime/", MONSTERS),
			SNAKE_SPRITE("snake/", MONSTERS),
			DOG_SPRITE("slime/", MONSTERS),

	ITEMS("items/", GRAPHICS),
		SWORD_SPRITE("warhammer/", ITEMS),
		AXE_SPRITE("warhammer/", ITEMS),
		WAR_HAMMER_SPRITE("warhammer/", ITEMS),
		SPEAR_SPRITE("warhammer/", ITEMS),
		ARMOUR_SPRITE("sword/", ITEMS),
		SHIELD_SPRITE("sword/", ITEMS),
		POTION_SPRITE("sword/", ITEMS);
	
	public final String path;
	final GraphicsPaths superpath;

	GraphicsPaths(String _path) {
		superpath = null;
		path = _path;
    }

    GraphicsPaths(String _path, GraphicsPaths _superpath) {
        superpath = _superpath;
        path = superpath.path + _path;
    }
}