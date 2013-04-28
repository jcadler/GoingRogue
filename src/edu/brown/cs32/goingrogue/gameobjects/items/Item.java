package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Item {
    private GridItem _gridItem;
    
    public Item(GridItem gridItem) {
        _gridItem = gridItem;
    }
    
    public boolean containsAttribute(Attribute attribute) {
        return _gridItem.containsAttribute(attribute);
    }
    
    public ItemStats getStats() {
        return _gridItem.getItemStats();
    }
    
    public String getSpritePath() {
        return _gridItem.getSpritePath();
    }
}
