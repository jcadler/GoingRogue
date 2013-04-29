package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ArcAttackAction extends Action {

    private Creature _sourceCreature;

    public ArcAttackAction(double direction, double distance, double arcLength, int timer, Creature sourceCreature) {
        super(timer, new ArcAttackRange(direction, distance, arcLength, timer));
        _sourceCreature = sourceCreature;
    }

    @Override
    public void act(Creature creature) {
        creature.incurDamage(_sourceCreature);
    }

    @Override
    public ActionAnimation getActionAnimation() {
        List<String> spritePaths = new ArrayList<>();
        spritePaths.add(_sourceCreature.getInventory().getWeapon().getSpritePath());
        Point2D.Double pos = _sourceCreature.getPosition();
        double angle = ((ArcAttackRange) getRange()).getAngle();
        return new ActionAnimation(spritePaths, pos, angle);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this._sourceCreature);
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
        final ArcAttackAction other = (ArcAttackAction) obj;
        if (!Objects.equals(this._sourceCreature, other._sourceCreature)) {
            return false;
        }
        return true;
    }
}