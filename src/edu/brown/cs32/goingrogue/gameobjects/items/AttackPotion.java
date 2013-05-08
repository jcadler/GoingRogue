package edu.brown.cs32.goingrogue.gameobjects.items;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AttackPotion extends Potion {

	public AttackPotion(){}
    public AttackPotion(GridItem gridItem) {
        super(gridItem);
    }

    @Override
    public void act(Creature creature) {
        creature.getStats().setAttack(creature.getStats().getAttack() + 10.0);
    }
}
