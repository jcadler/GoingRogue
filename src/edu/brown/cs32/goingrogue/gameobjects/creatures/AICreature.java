package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import static edu.brown.cs32.bweedon.geometry.Point2DUtil.getAngleFromTo;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreature extends Creature {
    
    private final double DIST_TO_ATTACK = 0.5;

    public AICreature(Point2D.Double pos, double direction, String name, List<Attribute> attributes,
            CreatureStats stats, String spritePath, CreatureSize size) {
        super(pos, direction, name, attributes, stats, spritePath, size);
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public List<Action> getActions() {
        List<Creature> creaturesInRoom = new ArrayList<>();
        Creature closestCreature = null;
        for (Creature currCreature : creaturesInRoom) {
            
        	Point2D currCreaturePos = currCreature.getPosition();
            if (closestCreature == null) {
                closestCreature = currCreature;
            } else if (getPosition().distance(currCreaturePos)
                    < getPosition().distance(closestCreature.getPosition())) {
                closestCreature = currCreature;
            }
        }
        
        if(closestCreature!=null) {
            setDirection(getAngleFromTo(getPosition(), closestCreature.getPosition()));
            List<Action> returnActions = new ArrayList<>();
            if (getPosition().distance(closestCreature.getPosition()) < DIST_TO_ATTACK) {
                returnActions.add(
                        new ArcAttackAction(getDirection(), getWeaponRange(), getWeaponArcLength(),
                        getWeaponAttackTimer(), this));
                return returnActions;
            } else {
                returnActions.add(new MoveAction(getDirection(), this));
                return returnActions;
            }
        }
        
        return new ArrayList<>();
    }
}
