package edu.brown.cs32.goingrogue.gameobjects.creatures.util;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import static edu.brown.cs32.goingrogue.graphics.GraphicsPaths.*;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtilHelper.*;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class RandomDataUtil {

    public static List<Attribute> randomCreatureAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        Random generator = new Random(System.currentTimeMillis());

        // elemental type of monster
        int choice = generator.nextInt(4);
        switch (choice) {
            case 0:
                attributes.add(FIRE_TYPE);
                break;
            case 1:
                attributes.add(WATER_TYPE);
                break;
            case 2:
                attributes.add(EARTH_TYPE);
                break;
            case 3:
                attributes.add(AIR_TYPE);
                break;
        }

        // type of monster
        choice = generator.nextInt(6);
        switch (choice) {
            case 0:
                attributes.add(EMU);
                break;
            case 1:
                attributes.add(DRAGON);
                break;
            case 2:
                attributes.add(HOB_GOBLIN);
                break;
            case 3:
                attributes.add(GIANT);
                break;
            case 4:
                attributes.add(SNAKE);
                break;
            case 5:
                attributes.add(DOG);
                break;
        }
        return attributes;
    }

    public static List<Attribute> randomItemAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(ITEM);
        Random generator = new Random(System.currentTimeMillis());

        // type of item
        int choice = generator.nextInt(4);
        switch (choice) {
            case 0:
                attributes.add(WEAPON);
                // type of weapon
                choice = generator.nextInt(4);
                switch (choice) {
                    case 0:
                        attributes.add(SWORD);
                        break;
                    case 1:
                        attributes.add(AXE);
                        break;
                    case 2:
                        attributes.add(WAR_HAMMER);
                        break;
                    case 3:
                        attributes.add(SPEAR);
                        break;
                }
                break;
            case 1:
                attributes.add(ARMOUR);
                break;
            case 2:
                attributes.add(SHIELD);
                break;
            case 3:
                attributes.add(POTION);
                break;
        }

        // type of material
        choice = generator.nextInt(5);
        switch (choice) {
            case 0:
                attributes.add(STEEL);
                break;
            case 1:
                attributes.add(IRON);
                break;
            case 2:
                attributes.add(BRONZE);
                break;
            case 3:
                attributes.add(WOOD);
                break;
            case 4:
                attributes.add(MITHRIL);
                break;
        }
        return attributes;
    }

    public static String getCreatureName(List<Attribute> attributes) {
        String name = "";
        if (attributes.contains(FIRE_TYPE)) {
            name += "Fire ";
        } else if (attributes.contains(WATER_TYPE)) {
            name += "Water ";
        } else if (attributes.contains(EARTH_TYPE)) {
            name += "Earth ";
        } else if (attributes.contains(AIR_TYPE)) {
            name += "Air ";
        }

        if (attributes.contains(EMU)) {
            name += "Emu";
        } else if (attributes.contains(DRAGON)) {
            name += "Dragon";
        } else if (attributes.contains(HOB_GOBLIN)) {
            name += "Hob Goblin";
        } else if (attributes.contains(GIANT)) {
            name += "Ice Giant";
        } else if (attributes.contains(SNAKE)) {
            name += "Snake";
        } else if (attributes.contains(DOG)) {
            name += "Dog";
        }

        return name;
    }

    public static String getItemName(List<Attribute> attributes) {
        String name = "";

        if (attributes.contains(STEEL)) {
            name += "Steel ";
        } else if (attributes.contains(IRON)) {
            name += "Iron ";
        } else if (attributes.contains(BRONZE)) {
            name += "Bronze ";
        } else if (attributes.contains(WOOD)) {
            name += "Wood ";
        } else if (attributes.contains(MITHRIL)) {
            name += "Mithril ";
        }

        if (attributes.contains(SWORD)) {
            name += " Sword";
        } else if (attributes.contains(AXE)) {
            name += " Axe";
        } else if (attributes.contains(WAR_HAMMER)) {
            name += " War Hammer";
        } else if (attributes.contains(SPEAR)) {
            name += " Spear";
        } else if (attributes.contains(ARMOUR)) {
            name += " Armour";
        } else if (attributes.contains(SHIELD)) {
            name += " Shield";
        } else if (attributes.contains(POTION)) {
            name += " Potion";
        }

        return name;
    }

    public static String getSprite(List<Attribute> attributes) {
        if (attributes.contains(EMU)) {
            return EMU_SPRITE;
        } else if (attributes.contains(DRAGON)) {
            return DRAGON_SPRITE;
        } else if (attributes.contains(HOB_GOBLIN)) {
            return HOB_GOBLIN_SPRITE;
        } else if (attributes.contains(GIANT)) {
            return GIANT_SPRITE;
        } else if (attributes.contains(SNAKE)) {
            return SNAKE_SPRITE;
        } else if (attributes.contains(DOG)) {
            return DOG_SPRITE;
        } else if (attributes.contains(SWORD)) {
            return SWORD_SPRITE;
        } else if (attributes.contains(AXE)) {
            return AXE_SPRITE;
        } else if (attributes.contains(WAR_HAMMER)) {
            return WAR_HAMMER_SPRITE;
        } else if (attributes.contains(SPEAR)) {
            return SPEAR_SPRITE;
        } else if (attributes.contains(ARMOUR)) {
            return ARMOUR_SPRITE;
        } else if (attributes.contains(SHIELD)) {
            return SHIELD_SPRITE;
        } else if (attributes.contains(POTION)) {
            return POTION_SPRITE;
        } else {
            return null; // TODO leave null here?
        }
    }

    public static CreatureStats randomCreatureStats(List<Attribute> attributes) {
        if (attributes.contains(EMU)) {
            return getEmuStats(attributes);
        } else if (attributes.contains(DRAGON)) {
            return getDragonStats(attributes);
        } else if (attributes.contains(HOB_GOBLIN)) {
            return getHobGoblinStats(attributes);
        } else if (attributes.contains(GIANT)) {
            return getGiantStats(attributes);
        } else if (attributes.contains(SNAKE)) {
            return getSnakeStats(attributes);
        } else if (attributes.contains(DOG)) {
            return getDogStats(attributes);
        } else {
            return null; // TODO OK to return null?
        }
    }

    public static ItemStats randomItemStats(List<Attribute> attributes) {
        if (attributes.contains(SWORD)) {
            return getSwordStats(attributes);
        } else if (attributes.contains(AXE)) {
            return getAxeStats(attributes);
        } else if (attributes.contains(WAR_HAMMER)) {
            return getWarHammerStats(attributes);
        } else if (attributes.contains(SPEAR)) {
            return getSpearStats(attributes);
        } else if (attributes.contains(ARMOUR)) {
            return getArmourStats(attributes);
        } else if (attributes.contains(SHIELD)) {
            return getShieldStats(attributes);
        } else if (attributes.contains(POTION)) {
            return getPotionStats(attributes);
        } else {
            return null; // TODO OK to return null?
        }
    }
}
