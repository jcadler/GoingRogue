package edu.brown.cs32.goingrogue.gameobjects.creatures;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import static edu.brown.cs32.bweedon.geometry.Point2DUtil.getAngleFromTo;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Corridor;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class AICreature extends Creature {

    private List<Creature> _creatures;
    private List<Room> _rooms;
    private final double DIST_TO_ATTACK;

    public AICreature(Point2D.Double pos, double direction, String name, List<Attribute> attributes,
            CreatureStats stats, String spritePath, CreatureSize size, List<Creature> creatures,
            List<Room> rooms) {
        super(pos, direction, name, attributes, stats, spritePath, size);
        _creatures = creatures;
        _rooms = rooms;
        DIST_TO_ATTACK = getWeaponRange();

        _shouldRotate = false;
        _shouldFlip = true;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public List<Action> getActionsWithUpdate(int delta) {
        Creature closestCreature = getClosestCreature();

        List<Action> returnActions = new ArrayList<>();
        if (getCreatureRoom(closestCreature) != null) {
            if (closestCreature != null) {
                setDirection(getAngleFromTo(getPosition(), closestCreature.getPosition()));
                if (getPosition().distance(closestCreature.getPosition()) < DIST_TO_ATTACK) {
                    returnActions.add(
                            new ArcAttackAction(getDirection(), getWeaponRange(), getWeaponArcLength(),
                            getWeaponAttackTimer(), this));
                    return returnActions;
                } else {
                    returnActions.add(new MoveAction(getDirection(), this, delta));
                    return returnActions;
                }
            }
        } else {
            Room creatureRoom = getCreatureRoom(this);
            Corridor playerCorridor = getCreatureCorridor(closestCreature);
        }

        setActions(returnActions);
        return returnActions;
    }

    private Creature getClosestCreature() {
        Creature closestCreature = null;
        for (int i = 0; i < _creatures.size(); ++i) {
            Creature currCreature = _creatures.get(i);
            Point2D currCreaturePos = currCreature.getPosition();
            if ((closestCreature == null) && (!currCreature.equals(this))
                    && (currCreature.getAttributes().contains(Attribute.PLAYER))) {
                closestCreature = currCreature;
            } else if ((closestCreature != null)
                    && (getPosition().distance(currCreaturePos)
                    < getPosition().distance(closestCreature.getPosition()))
                    && (!currCreature.equals(this))
                    && (currCreature.getAttributes().contains(Attribute.PLAYER))) {
                closestCreature = currCreature;
            }
        }
        return closestCreature;
    }

    private Room getCreatureRoom(Creature creature) {
        for (Room room : _rooms) {
            Rectangle2D roomRec = new Rectangle2D.Double(room.getX(), room.getY(), room.getWidth(), room.getHeight());
            if (roomRec.contains(creature.getPosition())) {
                return room;
            }
        }
        return null;
    }
    
    private Corridor getCreatureCorridor(Creature creature) {
        for (Room room : _rooms) {
            for (Corridor corridor : room.getCorridors()) {
                if (corridor.getRectangle().contains(creature.getPosition())) {
                    return corridor;
                }
            }
        }
        return null;
    }
}
