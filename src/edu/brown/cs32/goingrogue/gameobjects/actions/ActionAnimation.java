package edu.brown.cs32.goingrogue.gameobjects.actions;

import java.awt.geom.Point2D;

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
}
