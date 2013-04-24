package edu.brown.cs32.bweedon.gameobjects.creatures;

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
