package edu.brown.cs32.bweedon.gameobjects.creatures;

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