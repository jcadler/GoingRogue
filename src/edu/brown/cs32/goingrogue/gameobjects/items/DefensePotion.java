package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class DefensePotion extends Potion {
    
	public DefensePotion(){}
    public DefensePotion(GridItem gridItem) {
        super(gridItem);
    }

    @Override
    public void act(Creature creature) {
        creature.getStats().setDefense(creature.getStats().getDefense() + 10.0);
    }
}
