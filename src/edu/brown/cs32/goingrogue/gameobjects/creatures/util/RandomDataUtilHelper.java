package edu.brown.cs32.goingrogue.gameobjects.creatures.util;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import java.util.List;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import static edu.brown.cs32.bweedon.random.BweedonRandom.*;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class RandomDataUtilHelper {

    static CreatureStats getEmuStats(List<Attribute> attributes) {
        double attack = randomDouble(75, 100);
        double defense = randomDouble(100, 125);
        int health = randomInt(30, 40);
        double accuracy = randomDouble(75, 100);
        double speed = randomDouble(125, 150);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static CreatureStats getDragonStats(List<Attribute> attributes) {
        double attack = randomDouble(200, 260);
        double defense = randomDouble(250, 300);
        int health = randomInt(500, 550);
        double accuracy = randomDouble(30, 60);
        double speed = randomDouble(10, 30);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static CreatureStats getHobGoblinStats(List<Attribute> attributes) {
        double attack = randomDouble(80, 120);
        double defense = randomDouble(80, 100);
        int health = randomInt(50, 70);
        double accuracy = randomDouble(80, 110);
        double speed = randomDouble(50, 80);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static CreatureStats getGiantStats(List<Attribute> attributes) {
        double attack = randomDouble(150, 200);
        double defense = randomDouble(200, 250);
        int health = randomInt(200, 220);
        double accuracy = randomDouble(10, 15);
        double speed = randomDouble(20, 30);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static CreatureStats getSnakeStats(List<Attribute> attributes) {
        double attack = randomDouble(90, 100);
        double defense = randomDouble(30, 40);
        int health = randomInt(5, 10);
        double accuracy = randomDouble(100, 120);
        double speed = randomDouble(110, 125);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static CreatureStats getDogStats(List<Attribute> attributes) {
        double attack = randomDouble(70, 80);
        double defense = randomDouble(50, 65);
        int health = randomInt(20, 30);
        double accuracy = randomDouble(75, 90);
        double speed = randomDouble(90, 105);
        return new CreatureStats(attack, defense, health, accuracy, speed);
    }

    static ItemStats getSwordStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(20, 25), attributes, true);
        double defense = scaleToAttributes(randomDouble(10, 15), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(5, 10), attributes, true);
        double speed = scaleToAttributes(randomDouble(-10, -5), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(20, 25), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getAxeStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(30, 35), attributes, true);
        double defense = scaleToAttributes(randomDouble(5, 10), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(2, 6), attributes, true);
        double speed = scaleToAttributes(randomDouble(-15, -10), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(25, 30), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getWarHammerStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(25, 30), attributes, true);
        double defense = scaleToAttributes(randomDouble(10, 15), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(1, 5), attributes, true);
        double speed = scaleToAttributes(randomDouble(-20, -10), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(30, 35), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getSpearStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(30, 35), attributes, true);
        double defense = scaleToAttributes(randomDouble(5, 10), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(20, 25), attributes, true);
        double speed = scaleToAttributes(randomDouble(-5, -2), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(10, 5), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getArmourStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double defense = scaleToAttributes(randomDouble(40, 45), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double speed = scaleToAttributes(randomDouble(-25, -20), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(0, 0), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getShieldStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double defense = scaleToAttributes(randomDouble(30, 35), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double speed = scaleToAttributes(randomDouble(-15, -10), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(0, 0), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    static ItemStats getPotionStats(List<Attribute> attributes) {
        double attack = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double defense = scaleToAttributes(randomDouble(0, 0), attributes, true);
        int health = (int) scaleToAttributes(randomInt(0, 0), attributes, true);
        double accuracy = scaleToAttributes(randomDouble(0, 0), attributes, true);
        double speed = scaleToAttributes(randomDouble(0, 0), attributes, false);
        double reloadRate = scaleToAttributes(randomDouble(0, 0), attributes, false);
        return new ItemStats(attack, defense, health, accuracy, speed, reloadRate);
    }

    private static double scaleToAttributes(double origValue, List<Attribute> attributes, boolean multiply) {
        if (multiply) {
            if (attributes.contains(WOOD)) {
                return origValue * 1.0;
            } else if (attributes.contains(BRONZE)) {
                return origValue * 1.25;
            } else if (attributes.contains(IRON)) {
                return origValue * 1.5;
            } else if (attributes.contains(STEEL)) {
                return origValue * 1.75;
            } else if (attributes.contains(MITHRIL)) {
                return origValue * 2.0;
            } else {
                return origValue;
            }
        } else {
            if (attributes.contains(WOOD)) {
                return origValue / 1.0;
            } else if (attributes.contains(BRONZE)) {
                return origValue / 1.25;
            } else if (attributes.contains(IRON)) {
                return origValue / 1.5;
            } else if (attributes.contains(STEEL)) {
                return origValue / 1.75;
            } else if (attributes.contains(MITHRIL)) {
                return origValue / 2.0;
            } else {
                return origValue;
            }
        }
    }
}
