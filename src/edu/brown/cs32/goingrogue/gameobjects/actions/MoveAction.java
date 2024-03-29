package edu.brown.cs32.goingrogue.gameobjects.actions;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class MoveAction extends Action {

    private double _direction; // angle of motion in radians, with East being 0 rad
    private Creature _sourceCreature;
    private int _delta;

    public MoveAction(){}
    public MoveAction(double direction, Creature creature, int delta) {
        super(0, new MoveRange(creature));
        
        _type = ActionType.MOVE;
        _direction = direction;
        _sourceCreature = creature;
        _delta = delta;
    }

    @Override
    public void act(Creature creature) {
        double xTranslation = _delta * (creature.getSpeed() * cos(_direction));
        double yTranslation = _delta * (creature.getSpeed() * sin(_direction));
        Point2D origPos = creature.getPosition();
        creature.setPosition(new Point2D.Double(origPos.getX() + xTranslation,
                origPos.getY() + yTranslation));
        	
    }

    @Override
    public List<ActionAnimation> getActionAnimations() {
        String spritePath= _sourceCreature.getSpritePath();
        Point2D.Double pos = _sourceCreature.getPosition();
        double angle = _sourceCreature.getDirection();
        List<ActionAnimation> list=new ArrayList<>();
        list.add(new ActionAnimation(spritePath, pos, angle, _sourceCreature.getSize()));
        return list;
    }
    
    public void setDelta(int delta) {
        _delta = delta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this._direction) ^ (Double.doubleToLongBits(this._direction) >>> 32));
        hash = 73 * hash + Objects.hashCode(this._sourceCreature);
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
        final MoveAction other = (MoveAction) obj;
        if (Double.doubleToLongBits(this._direction) != Double.doubleToLongBits(other._direction)) {
            return false;
        }
        if (!Objects.equals(this._sourceCreature, other._sourceCreature)) {
            return false;
        }
        return true;
    }
}