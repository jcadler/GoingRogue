package edu.brown.cs32.goingrogue.gameobjects.creatures;

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
    private final int MAX_NUM_POTIONS = 5;

    public Inventory() {
        _weapon = null;
        _armour = null;
        _shield = null;
        _potions = new ArrayList<>();
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
}
