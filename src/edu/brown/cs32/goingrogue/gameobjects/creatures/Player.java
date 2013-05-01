package edu.brown.cs32.goingrogue.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupRange;
import edu.brown.cs32.goingrogue.gameobjects.creatures.util.CombatUtil;

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
        return new InputHandler(this);
    }

    public class InputHandler {
    	
    	Player player;
    	
    	InputHandler(Player p) {
    		player=p;
    	}
    	
        public void moveUp() {
            setPosition(new Point2D.Double(getPosition().getX(), getPosition().getY() - getSpeed()));
            addAction(new MoveAction(Math.PI/2, player));
        }

        public void moveRight() {
            setPosition(new Point2D.Double(getPosition().getX() + getSpeed(), getPosition().getY()));
            addAction(new MoveAction(0, player));
        }

        public void moveDown() {
            setPosition(new Point2D.Double(getPosition().getX(), getPosition().getY() + getSpeed()));
            addAction(new MoveAction(-Math.PI/2, player));
        }

        public void moveLeft() {
            setPosition(new Point2D.Double(getPosition().getX() - getSpeed(), getPosition().getY()));
            addAction(new MoveAction(Math.PI, player));
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