package edu.brown.cs32.bweedon.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Player extends Creature {

    private int _health;

    public Player(Point2D pos, int health, List<Attribute> attributes, int pxPerMove, String sprite) {
        super(pos, health, attributes, pxPerMove, sprite);
        _health = health;
    }

    @Override
    public void incurDamage(int damage) {
    }

    @Override
    public int getHealth() {
        return _health;
    }

    @Override
    public boolean isItem() {
        return false;
    }
}