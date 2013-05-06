package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public interface CreatureFactory {
    public Creature create(List<Creature> creatures, List<Room> rooms);
}
