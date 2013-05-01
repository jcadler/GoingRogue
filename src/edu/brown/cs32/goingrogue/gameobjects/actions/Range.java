package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface Range { // make abstract class, maybe?

    public boolean inRange(Creature creature);

    public void decrementTimer(int delta);
}