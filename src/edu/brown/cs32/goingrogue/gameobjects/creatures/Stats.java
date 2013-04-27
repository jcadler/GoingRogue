package edu.brown.cs32.goingrogue.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public abstract class Stats {

    private double _attack;
    private double _defense;
    private int _health;
    private double _accuracy;
    private double _speed; // in pixels-per-movement
    
    public Stats(double attack, double defense, int health, double accuracy, double speed) {
        _attack = attack;
        _defense = defense;
        _health = health;
        _accuracy = accuracy;
        _speed = speed;
    }

    public double getAttack() {
        return _attack;
    }

    public void setAttack(double attack) {
        _attack = attack;
    }

    public double getDefense() {
        return _defense;
    }

    public void setDefense(double defense) {
        _defense = defense;
    }

    public int getHealth() {
        return _health;
    }

    public void setHealth(int health) {
        _health = health;
    }
    
    public void reduceHealth(int reduction) {
        _health -= reduction;
    }

    public double getAccuracy() {
        return _accuracy;
    }

    public void setAccuracy(double accuracy) {
        _accuracy = accuracy;
    }
    
    public double getSpeed() {
        return _speed;
    }
    
    public void setSpeed(double speed) {
        _speed = speed;
    }
}
