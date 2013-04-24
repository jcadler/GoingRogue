package edu.brown.cs32.bweedon.gameobjects.creatures;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface Range { // make abstract class, maybe?

    public boolean inRange(Creature creature);

    public void decrementTimer();
}