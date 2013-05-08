package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class HealthPotion extends Potion {

	public HealthPotion(){}
    public HealthPotion(GridItem gridItem) {
        super(gridItem);
    }

    @Override
    public void act(Creature creature) {
        creature.getStats().setHealth(creature.getHealth() + 10);
    }
}
