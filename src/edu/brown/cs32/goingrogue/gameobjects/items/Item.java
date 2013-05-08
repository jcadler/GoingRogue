package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Item {
    private GridItem _gridItem;
    
    public Item(GridItem gridItem) {
        _gridItem = gridItem;
    }
    
    public GridItem getGridItem() {
    	return _gridItem;
    }
    
    public void setGridItem(GridItem gridItem) {
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
    
    public CreatureSize getSize() {
    	return _gridItem.getSize();
    }
    
    public Rectangle2D getRectangle() {
        return _gridItem.getRectangle();
    }
}
