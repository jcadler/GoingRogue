package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Inventory {
    private List<Item> _items;
    
    public void add(Item item) {
        _items.add(item);
    }
    
    public boolean contains(Item item) {
        return _items.contains(item);
    }
}
