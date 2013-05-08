package edu.brown.cs32.goingrogue.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.ChangeDirectionAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.ActionType;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.util.ArrayList;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Player extends Creature {

    private InputHandler handle;
    
    private int _xp;
    private int _nextLevelXP;
    private int _level;
    private int _maxHealth;
    
    private int _initMaxHealth;
    
    public Player(Point2D.Double pos, double direction, String name,
            List<Attribute> attributes, CreatureStats stats, String sprite, CreatureSize size) {
        super(pos, direction, name, attributes, stats, sprite, size);
        handle = new InputHandler(this);
        
        _xp=0;
        _nextLevelXP=100;
        _level=1;
        _maxHealth=this.getStats().getHealth();
        
        //Temp
        _initMaxHealth=_maxHealth;
    }
    
    @Override
    public List<Action> getActionsWithUpdate(int delta) {
        for (Action currAction : getActions()) {
            if (currAction.type().equals(ActionType.MOVE)) {
                ((MoveAction) currAction).setDelta(delta);
            }
        }
        return getActions();
    }

    @Override
    public boolean isItem() {
        return false;
    }
    
    public int getXP() {
    	return _xp;
    }
    
    public void incXP(int amt) {
    	_xp+=amt;
    	while(_xp>=getNextLevelXP()) {
    		_xp-=getNextLevelXP();
    		_level++;
    	}
    }
    
    public int getNextLevelXP() {
    	return 100*(_level*_level + _level - 1);
    }
    
    public int getLevel() {
    	return _level;
    }
    
    public int getMaxHealth() {
    	return _initMaxHealth+20*(_level-1);
    }

    public InputHandler getHandler() {
        return handle;
    }

    public class InputHandler {

        Player player;
        Action attack;

        InputHandler(Player p) {
            player = p;
            attack = null;
        }

        public void moveUp() {
        	double angle= - Math.PI / 2.0;
            addAction(new MoveAction(- Math.PI/2.0, player, 1));
            addAction(new ChangeDirectionAction(player, 0));
        }

        public void moveRight() {
        	double angle=0;
            addAction(new MoveAction(0, player, 1));
            addAction(new ChangeDirectionAction(player, Math.PI / 2.0));
        }

        public void moveDown() {
        	double angle=Math.PI / 2.0;
            addAction(new MoveAction(Math.PI / 2.0, player, 1));
            addAction(new ChangeDirectionAction(player, Math.PI));
        }

        public void moveLeft() {
        	double angle=Math.PI;
            addAction(new MoveAction(Math.PI, player, 1));
            addAction(new ChangeDirectionAction(player, - Math.PI / 2.0));
        }

        public void attack() {
            if (attack == null || attack.getTimer() <= 0) {
                Action a = new ArcAttackAction(getDirection(), getWeaponRange(), getWeaponArcLength(),
                        getWeaponAttackTimer(), Player.this);
                attack = a;
                addAction(a);
            }
        }

        public void pickUp() {
            addAction(new PickupAction(new PickupRange(player), player));
        }
        
        public void usePotion() {
        	if(player.getInventory().getNumPotions()>0) {
        		player.getInventory().dropPotion(0);
        		
        		player.incurDamage(player);
        	}
        }
    }
}