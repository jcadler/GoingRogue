package edu.brown.cs32.jcadler.GameLogic;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.AICreatureFactory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.PlayerFactory;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
import edu.brown.cs32.goingrogue.map.RogueMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

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
        actions = new ArrayList<>();
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
        
        creatures.add(player);
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public RogueMap getMap()
    {
    	
        return crrntMap;
    }
    
    /** Gets all creatures
     */
    public List<Creature> getCreatures()
    {
        return creatures;
    }
    
    /** Gets all creatures within the given (x1, y1, x2, y2) bounds
     */
    public List<Creature> getCreatures(double minX, double minY, double maxX, double maxY)
    {
    	Rectangle bounds=new Rectangle();
    	
    	List<Creature> boundedCreatures=new ArrayList<>();
    	//TODO Incorporate creature size
        for(Creature c: creatures) {
        	if(bounds.contains(c.getPosition())) {
        		boundedCreatures.add(c);
        	}
        }
    	
    	return boundedCreatures;
    }
    
    public void update(int delta) throws CloneNotSupportedException
    {
        List<Action> zero = new ArrayList<>();
        for(Action a : actions)
        {
            a.decrementTimer(delta);
            if(a.getTimer()<=0)
                zero.add(a);
        }        
        actions.removeAll(zero);
        for(Creature c : creatures)
        {
            c.removeTimedOutActions();
            actions.addAll(c.getActions());
        }
        for(Action a : actions)
        {
            for(Creature c : creatures)
            {
                if(a.withinRange(c))
                {
                    Creature test = a.actOnClone(c);
                    if(crrntMap.isValid(test.getPosition()))
                        a.act(c);
                }
            }
        }
        List<Creature> dead = new ArrayList<>();
        for(Creature c : creatures)
        {
            if(c.isDead())
                dead.add(c);
        }
        creatures.removeAll(dead);
    }
}
