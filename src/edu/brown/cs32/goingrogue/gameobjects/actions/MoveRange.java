package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class MoveRange implements Range {

    private Creature _sourceCreature;

    public MoveRange(Creature creature) {
        _sourceCreature = creature;
    }

    @Override
    public boolean inRange(Creature creature) {
        return creature.equals(_sourceCreature);
    }

    @Override
    public void decrementTimer(int delta) {
        // do nothing
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this._sourceCreature);
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
        final MoveRange other = (MoveRange) obj;
        if (!Objects.equals(this._sourceCreature, other._sourceCreature)) {
            return false;
        }
        return true;
    }
}