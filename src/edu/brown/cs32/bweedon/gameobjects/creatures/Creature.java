package edu.brown.cs32.bweedon.gameobjects.creatures;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Creature {

    private Point2D _pos;
    private List<Attribute> _attributes;
    private int _pxPerMove;
    private String _spritePath;
    private List<Item> _items;

    public Creature(Point2D pos, int health, List<Attribute> attributes, int pxPerMove, String spritePath) {
        _pos = pos;
        _attributes = attributes;
        _pxPerMove = pxPerMove;
        _spritePath = spritePath;
        _items = new ArrayList<>();
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

    public int getPxPerMove() {
        return _pxPerMove;
    }
    
    public void addItem(Item item) {
        _items.add(item);
    }

    @Override
    protected Creature clone() throws CloneNotSupportedException {
        return (Creature) super.clone(); // TODO is call to super OK?
    }

    public abstract void incurDamage(int damage);

    public abstract int getHealth();
    
    public abstract boolean isItem();
}