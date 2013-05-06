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
		EXIT("water.png", SCENERY),
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
			CHAR_1("char1/", CHARACTERS),
			CHAR_2("char2/", CHARACTERS),
			CHAR_3("char3/", CHARACTERS),
			CHAR_4("char4/", CHARACTERS),
		MONSTERS("monsters/", CREATURES),
			BAT_SPRITE("bat/", MONSTERS),
			SLIME_SPRITE("slime/", MONSTERS),
			EMU_SPRITE("emu/", MONSTERS),
			DRAGON_SPRITE("slime/", MONSTERS),
			HOB_GOBLIN_SPRITE("hobgoblin/", MONSTERS),
			GIANT_SPRITE("bat/", MONSTERS),
			SNAKE_SPRITE("snake/", MONSTERS),
			DOG_SPRITE("dog/", MONSTERS),

	ITEMS("items/", GRAPHICS),
		SWORD_SPRITE("sword/", ITEMS),
		AXE_SPRITE("axe/", ITEMS),
		WAR_HAMMER_SPRITE("warhammer/", ITEMS),
		SPEAR_SPRITE("spear/", ITEMS),
		ARMOUR_SPRITE("armor/", ITEMS),
		SHIELD_SPRITE("shield/", ITEMS),
		POTION_SPRITE("potion/", ITEMS);
	
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