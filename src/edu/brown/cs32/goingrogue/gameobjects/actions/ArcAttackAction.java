package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import java.awt.geom.Point2D;

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
        String spritePath = _sourceCreature.getInventory().getWeapon().getSpritePath();
        Point2D.Double pos = _sourceCreature.getPosition();
        double angle = ((ArcAttackRange) getRange()).getAngle();
        return new ActionAnimation(spritePath, pos, angle);
    }
}