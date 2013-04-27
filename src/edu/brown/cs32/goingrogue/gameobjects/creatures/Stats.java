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
    
    public Stats(double attack, double defense, int health, double accuracy) {
        _attack = attack;
        _defense = defense;
        _health = health;
        _accuracy = accuracy;
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

    public double getAccuracy() {
        return _accuracy;
    }

    public void setAccuracy(double accuracy) {
        _accuracy = accuracy;
    }
}
