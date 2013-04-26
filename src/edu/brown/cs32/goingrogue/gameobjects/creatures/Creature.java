package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Creature {

    private Point2D _pos;
    private String _name;
    private List<Attribute> _attributes;
    private CreatureStats _stats;
    private String _spritePath;
    private Inventory _inventory;

    public Creature(Point2D pos, String name, List<Attribute> attributes, CreatureStats stats, String spritePath) {
        _pos = pos;
        _name = name;
        _attributes = attributes;
        _stats = stats;
        _spritePath = spritePath;
        _inventory = new Inventory();
    }

    public List<Attribute> getAttributes() {
        return _attributes;
    }

    public Point2D getPosition() {
        return _pos;
    }

    public void setPosition(Point2D pos) {
        _pos = pos;
    }
    
    public String getName() {
        return _name;
    }
    
    public void setName(String name) {
        _name = name;
    }
    
    CreatureStats getStats() {
        return _stats;
    }
    
    public int getPxPerMove() {
        return (int) _stats.getSpeed();
    }

    public void addItem(Item item) {
        _inventory.add(item);
    }

    public Creature createNewInstance() throws CloneNotSupportedException {
        return (Creature) super.clone(); // TODO is call to super.clone() OK?
    }

    public int getHealth() {
        return (int) _stats.getHealth();
    }
    
    public void incurDamage(int damage) {
        CombatUtil.incurDamage(_stats, damage);
    }

    public abstract boolean isItem();
}