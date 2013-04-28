package edu.brown.cs32.jcadler.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.awt.geom.Point2D;

import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.AICreatureFactory;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.PlayerFactory;
import edu.brown.cs32.goingrogue.gameobjects.actions.Action;

/**
 *
 * @author john
 */
public class GameLogic 
{
    private LogicMap crrntMap;
    private List<Creature> creatures;
    private List<Action> actions;
    private Player player;
    
    public GameLogic() throws IOException
    {
        crrntMap = LogicMap.getRandomMap();
        Random r = new Random();
        int numCreatures = r.nextInt(3)+1;
        creatures = new ArrayList<>();
        List<Room> rooms = crrntMap.getRooms();
        for(int i=0;i<numCreatures;i++)
        {
            Creature put = AICreatureFactory.create();
            Room rm = rooms.get(r.nextInt(rooms.size()));
            put.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
            creatures.add(put);
            put = GridItemFactory.create();
            put.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
            creatures.add(put);
        }
        player = PlayerFactory.create();
        player.setName("bob");
        Room rm = rooms.get(r.nextInt(rooms.size()));
        player.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void update()
    {
        for(Creature c : creatures)
        {
            action
        }
    }
}
