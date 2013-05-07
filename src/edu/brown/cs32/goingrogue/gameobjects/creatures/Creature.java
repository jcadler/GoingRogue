package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.util.CombatUtil;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Creature implements Cloneable {

    private Point2D.Double _pos;
    private double _direction; // in radians
    private boolean _left;
    private boolean _shouldFlip;
    private boolean _shouldRotate;
    private String _name;
    private UUID _id;
    private List<Attribute> _attributes;
    private CreatureStats _stats;
    private String _spritePath;
    private CreatureSize _size;
    private Inventory _inventory;
    private List<Action> _actions;
    private int _level;
    //Used to ensure existence of a single unique hash code
    private int _hashCode;

    public Creature(Point2D.Double pos, double direction, String name,
            List<Attribute> attributes, CreatureStats stats, String spritePath, CreatureSize size) {
        _pos = pos;
        _direction = direction;
        _left = false;
        _shouldFlip=false;
        _shouldRotate=false;
        _name = name;
        _id = UUID.randomUUID();
        _attributes = attributes;
        _stats = stats;
        _spritePath = spritePath;
        _size = size;
        _inventory = new Inventory();
        _actions = new ArrayList<>();
        _level = 1;

        _hashCode = -1;
    }

    public List<Attribute> getAttributes() {
        return _attributes;
    }

    public Point2D.Double getPosition() {
        return _pos;
    }

    public void setPosition(Point2D.Double pos) {
        _pos = pos;
    }

    public double getDirection() {
        return _direction;
    }

    public void setDirection(double direction) {
        _direction = direction;
    }
    
    public boolean isLeft() {
    	return _left;
    }
    
    public void setLeft(boolean left) {
    	_left=left;
    }
    
    public boolean shouldFlip() {
    	return _shouldFlip;
    }
    
    public void setShouldFlip(boolean shouldFlip) {
    	_shouldFlip=shouldFlip;
    }
    
    public boolean shouldRotate() {
    	return _shouldRotate;
    }
    
    public void setShouldRotate(boolean shouldRotate) {
    	_shouldRotate=shouldRotate;
    }
    
    public String getSpritePath() {
        return _spritePath;
    }

    public void setSpritePath(String spritePath) {
        _spritePath = spritePath;
    }

    public CreatureSize getSize() {
        return _size;
    }

    public void setSize(CreatureSize size) {
        _size = size;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Stats getStats() {
        return _stats;
    }

    public Inventory getInventory() {
        return _inventory;
    }

    public double getSpeed() {
        return _stats.getSpeed();
    }

    public void addItem(Item item) {
        _inventory.add(item);
    }

    public Creature createNewInstance() throws CloneNotSupportedException {
        return (Creature) super.clone(); // TODO is call to super.clone() OK?
    }

    public int getHealth() {
        return _stats.getHealth();
    }

    public boolean isDead() {
        return _stats.getHealth() <= 0;
    }

    public double getWeaponRange() {
        if (_inventory.getWeapon() != null) {
            return _inventory.getWeapon().getStats().getRange();
        } else {
            return 0.0;
        }
    }

    public double getWeaponArcLength() {
        if (_inventory.getWeapon() != null) {
            return _inventory.getWeapon().getStats().getArcLength();
        } else {
            return 0.0;
        }
    }

    public int getWeaponAttackTimer() {
        if (_inventory.getWeapon() != null) {
            return _inventory.getWeapon().getStats().getAttackTimer();
        } else {
            return 0;
        }
    }

    public Rectangle2D getRectangle() {
        return new Rectangle2D.Double(_pos.getX(), _pos.getY(), _size.getWidth(), _size.getHeight());
    }

    public Point2D getCenterPosition() {
        double xVal = _pos.getX() + (_size.getWidth() / 2.0);
        double yVal = _pos.getY() + (_size.getHeight() / 2.0);
        return new Point2D.Double(xVal, yVal);
    }

    public void incurDamage(Creature attacker) {
        CombatUtil.incurDamage(attacker, this);
    }

    public boolean containsAttribute(Attribute attribute) {
        return _attributes.contains(attribute);
    }

    public int getLevel() {
        return _level;
    }

    public void incrementLevel() {
        ++_level;
    }

    public void decrementLevel() {
        --_level;
    }
    
        
    public List<Action> getActionsWithUpdate(int delta) {
        return getActions();
    }

    public List<Action> getActions() {
        return _actions;
    }
    
    protected void setActions(List<Action> actions) {
        _actions = actions;
    }

    public void removeTimedOutActions() {
        List<Action> removeActions = new ArrayList<>();
        for (Action action : _actions) {
            if (action.getTimer() < 0) {
                removeActions.add(action);
            }
        }
        for (Action action : removeActions) {
            _actions.remove(action);
        }
    }

    public void addAction(Action action) {
        _actions.add(action);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this._id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Creature other = (Creature) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    public abstract boolean isItem();
}