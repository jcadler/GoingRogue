package edu.brown.cs32.goingrogue.util;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class CreatureSize {

    private double _width;
    private double _height;

    public CreatureSize(){}
    public CreatureSize(double width, double height) {
        _width = width;
        _height = height;
    }

    public double getWidth() {
        return _width;
    }

    public void setWidth(double width) {
        _width = width;
    }

    public double getHeight() {
        return _height;
    }

    public void setHeight(double height) {
        _height = height;
    }
}
