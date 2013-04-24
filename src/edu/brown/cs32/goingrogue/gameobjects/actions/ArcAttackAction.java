package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ArcAttackAction extends Action {

    private int _damage;

    public ArcAttackAction(double direction, double distance, double arcLength, int damage, int timer) {
        super(timer, new ArcAttackRange(direction, distance, arcLength, timer));
        _damage = damage;
    }

    public void act(Creature creature) {
        creature.incurDamage(_damage);
    }
}