package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Item {
    private GridItem _gridItem;
    
    public Item(GridItem gridItem) {
        _gridItem = gridItem;
    }
    
    public void act(Creature creature) {
        _gridItem.act(creature);
    }
}
