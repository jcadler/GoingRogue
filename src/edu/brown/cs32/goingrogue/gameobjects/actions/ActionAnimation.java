package edu.brown.cs32.goingrogue.gameobjects.actions;

import java.awt.geom.Point2D;
import java.util.Objects;

import edu.brown.cs32.goingrogue.util.CreatureSize;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ActionAnimation {

    private String _spritePath;
    private Point2D.Double _pos;
    private double _angle;
    private CreatureSize _size;

    public ActionAnimation(){}
    public ActionAnimation(String spritePaths, Point2D.Double pos, double angle, CreatureSize size) {
        _spritePath = spritePaths;
        _pos = pos;
        _angle = angle;
        _size = size;
    }

    public String getSpritePath() {
        return _spritePath;
    }

    public void setSpritePath(String spritePath) {
        _spritePath = spritePath;
    }

    public Point2D.Double getPos() {
        return _pos;
    }
    
    public CreatureSize getSize() {
        return _size;
    }

    public void setPos(Point2D.Double pos) {
        _pos = pos;
    }

    public double getAngle() {
        return _angle;
    }

    public void setAngle(double angle) {
        _angle = angle;
    }
    
    public void setSize(CreatureSize size) {
        _size=size;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this._spritePath);
        hash = 37 * hash + Objects.hashCode(this._pos);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._angle) ^ (Double.doubleToLongBits(this._angle) >>> 32));
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
        final ActionAnimation other = (ActionAnimation) obj;
        if (!Objects.equals(this._spritePath, other._spritePath)) {
            return false;
        }
        if (!Objects.equals(this._pos, other._pos)) {
            return false;
        }
        if (Double.doubleToLongBits(this._angle) != Double.doubleToLongBits(other._angle)) {
            return false;
        }
        return true;
    }
}
