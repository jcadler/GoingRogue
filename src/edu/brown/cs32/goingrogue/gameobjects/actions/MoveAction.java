package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Point2D;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class MoveAction extends Action {

    private double _direction; // angle of motion in radians, with East being 0 rad
    private Creature _sourceCreature;

    public MoveAction(double direction, Creature creature) {
        super(0, new MoveRange(creature));
        _direction = direction;
        _sourceCreature = creature;
    }

    @Override
    public void act(Creature creature) {
        double xTranslation = creature.getSpeed() * cos(_direction);
        double yTranslation = creature.getSpeed() * sin(_direction);
        Point2D origPos = creature.getPosition();
        creature.setPosition(new Point2D.Double(origPos.getX() + xTranslation, origPos.getY() + yTranslation));
    }

    @Override
    public ActionAnimation getActionAnimation() {
        String spritePath = _sourceCreature.getSpritePath();
        Point2D.Double pos = _sourceCreature.getPosition();
        double angle = _sourceCreature.getDirection();
        return new ActionAnimation(spritePath, pos, angle);
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