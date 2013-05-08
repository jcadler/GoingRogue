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
        Point2D targetPoint;
        if (getCreatureRoom(closestCreature) != null) {
            if (closestCreature != null) {
                targetPoint = closestCreature.getPosition();
            } else {
                return new ArrayList<>();
            }
        } else {
            Room creatureRoom = getCreatureRoom(this);
            Corridor playerCorridor = getCreatureCorridor(closestCreature);
            Point2D corridorEntrance = getEntrance(playerCorridor, creatureRoom);
            targetPoint = corridorEntrance;
        }
        
        setDirection(getAngleFromTo(getPosition(), targetPoint));
        if (getPosition().distance(targetPoint) < DIST_TO_ATTACK) {
            returnActions.add(
                    new ArcAttackAction(getDirection(), getWeaponRange(), getWeaponArcLength(),
                    getWeaponAttackTimer(), this));
        } else {
            returnActions.add(new MoveAction(getDirection(), this, delta));
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

    private Point2D getEntrance(Corridor corridor, Room room) {
        
    	int posInRoom;
    	
        Room r=corridor.getStart();
        String id=r.getID();
        String rid=room.getID();
        if (id.equals(rid)) {
            posInRoom = corridor.getPos1();
        } else if (corridor.getEnd().getID().equals(room.getID())) {
            posInRoom = corridor.getPos2();
        } else {
            posInRoom = -1000; // extreme value will make it easy to tell in debugging
            // without having to throw an error
        }

        double xVal;
        double yVal;
        final double OFFSET_INTO_ROOM = 1.0;
        switch (corridor.getDirection()) {
            case 0:
                xVal = room.getX() + posInRoom + (corridor.getWidth() / 2.0);
                yVal = room.getY() + OFFSET_INTO_ROOM;
                break;
            case 1:
                xVal = room.getX() + room.getWidth() - OFFSET_INTO_ROOM;
                yVal = room.getY() + posInRoom + (corridor.getWidth() / 2.0);
                break;
            case 2:
                xVal = room.getX() + posInRoom + (corridor.getWidth() / 2.0);
                yVal = room.getY() + room.getHeight() - OFFSET_INTO_ROOM;
                break;
            case 3:
                xVal = room.getX() + OFFSET_INTO_ROOM;
                yVal = room.getY() + posInRoom + (corridor.getWidth() / 2.0);
                break;
            default:
                xVal = -1000;
                yVal = -1000; // for debugging, as seen above
                break;
        }
        return new Point2D.Double(xVal, yVal);
    }
}
