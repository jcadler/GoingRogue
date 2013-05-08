package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Potion extends Item {
	public Potion(){}
    public Potion(GridItem gridItem) {
        super(gridItem);
    }
    
    public abstract void act(Creature creature);
}
