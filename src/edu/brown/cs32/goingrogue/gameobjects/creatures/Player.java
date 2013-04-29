package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupRange;
import edu.brown.cs32.goingrogue.gameobjects.creatures.util.CombatUtil;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Player extends Creature {

    public Player(Point2D.Double pos, double direction, String name, List<Attribute> attributes, CreatureStats stats, String sprite) {
        super(pos, direction, name, attributes, stats, sprite);
    }

    @Override
    public void incurDamage(Creature attacker) {
        CombatUtil.incurDamage(attacker, this);
    }

    @Override
    public boolean isItem() {
        return false;
    }

    public InputHandler getHandler() {
        return new InputHandler();
    }

    private class InputHandler {

        public void moveUp() {
            setPosition(new Point2D.Double(getPosition().getX(), getPosition().getY() - getSpeed()));
        }

        public void moveRight() {
            setPosition(new Point2D.Double(getPosition().getX() + getSpeed(), getPosition().getY()));
        }

        public void moveDown() {
            setPosition(new Point2D.Double(getPosition().getX(), getPosition().getY() + getSpeed()));
        }

        public void moveLeft() {
            setPosition(new Point2D.Double(getPosition().getX() - getSpeed(), getPosition().getY()));
        }

        public void attack() {
            addAction(new ArcAttackAction(getDirection(), getWeaponRange(), getWeaponArcLength(),
                    getWeaponAttackTimer(), Player.this));
        }

        public void pickUp() {
            addAction(new PickupAction(0, new PickupRange(Player.this), Player.this));
        }
    }
}