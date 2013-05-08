package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.actions.QuaffAction;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import java.util.List;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import java.util.ArrayList;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Inventory {

    private Item _weapon;
    private Item _armour;
    private Item _shield;
    private List<Item> _potions;
    private Creature _creature;
    private final int MAX_NUM_POTIONS = 5;

    public Inventory(Creature creature) {
        _weapon = null;
        _armour = null;
        _shield = null;
        _potions = new ArrayList<>();
        _creature = creature;
    }

    public void add(Item item) {
        if (item.containsAttribute(WEAPON)) {
            _weapon = item;
        } else if (item.containsAttribute(ARMOUR)) {
            _armour = item;
        } else if (item.containsAttribute(SHIELD)) {
            _shield = item;
        } else if (item.containsAttribute(POTION)) {
            if (_potions.size() < MAX_NUM_POTIONS) {
                _potions.add(item);
            } else {
                _creature.addAction(new QuaffAction(item, _creature));
            }
        }
    }

    public Item getWeapon() {
        return _weapon;
    }

    public Item getArmour() {
        return _armour;
    }

    public Item getShield() {
        return _shield;
    }

    public Item getPotion(int index) {
        return _potions.get(index);
    }

    public void dropPotion(int index) {
        _potions.remove(index);
    }

    public int getNumPotions() {
        return _potions.size();
    }

    public double getAttackSum() {
        List<Item> thingsToAdd = getThingsToAdd(_weapon, _armour, _shield);
        double sum = 0.0;
        for (Item currItem : thingsToAdd) {
            sum += currItem.getStats().getAttack();
        }
        return sum;
    }

    public double getDefenseSum() {
        List<Item> thingsToAdd = getThingsToAdd(_weapon, _armour, _shield);
        double sum = 0.0;
        for (Item currItem : thingsToAdd) {
            sum += currItem.getStats().getDefense();
        }
        return sum;
    }

    public double getAccuracySum() {
        List<Item> thingsToAdd = getThingsToAdd(_weapon, _armour, _shield);
        double sum = 0.0;
        for (Item currItem : thingsToAdd) {
            sum += currItem.getStats().getAccuracy();
        }
        return sum;
    }

    public double getSpeedSum() {
        List<Item> thingsToAdd = getThingsToAdd(_weapon, _armour, _shield);
        double sum = 0.0;
        for (Item currItem : thingsToAdd) {
            sum += currItem.getStats().getSpeed();
        }
        return sum;
    }

    private List<Item> getThingsToAdd(Item weapon, Item armour, Item shield) {
        List<Item> thingsToAdd = new ArrayList<>();
        if (weapon != null) {
            thingsToAdd.add(weapon);
        }
        if (armour != null) {
            thingsToAdd.add(armour);
        }
        if (shield != null) {
            thingsToAdd.add(shield);
        }
        return thingsToAdd;
    }
}
