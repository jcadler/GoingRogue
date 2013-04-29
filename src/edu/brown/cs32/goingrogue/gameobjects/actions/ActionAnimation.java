package edu.brown.cs32.goingrogue.gameobjects.actions;

import java.awt.geom.Point2D;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ActionAnimation {

    private String _spritePath;
    private Point2D.Double _pos;
    private double _angle;

    public ActionAnimation(String spritePath, Point2D.Double pos, double angle) {
        _spritePath = spritePath;
        _pos = pos;
        _angle = angle;
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

    public void setPos(Point2D.Double pos) {
        _pos = pos;
    }

    public double getAngle() {
        return _angle;
    }

    public void setAngle(double angle) {
        _angle = angle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this._spritePath);
        hash = 73 * hash + Objects.hashCode(this._pos);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this._angle) ^ (Double.doubleToLongBits(this._angle) >>> 32));
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
