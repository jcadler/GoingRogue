package edu.brown.cs32.jcadler.GameLogic;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
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
    private int level;
    private Room last;
    
    public GameLogic() throws IOException
    {
        crrntMap = LogicMap.getRandomMap();
        Random r = new Random();
        int numCreatures = 10; //r.nextInt(10)+1;
        creatures = new ArrayList<>();
        actions = new ArrayList<>();
        setRandomExit();
        addCreatures(numCreatures);
        player = PlayerFactory.create(creatures,crrntMap.getRooms());
        player.setName("debug");
        setPlayer();
        creatures.add(player);
        level=0;
    }
    
    private void addCreatures(int numCreatures)
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();
        for(int i=0;i<numCreatures;i++)
        {
            Creature put = AICreatureFactory.create(creatures,crrntMap.getRooms());
            Room rm = rooms.get(r.nextInt(rooms.size()));
            put.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
            creatures.add(put);
            put = GridItemFactory.create(creatures,crrntMap.getRooms());
            put.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
            creatures.add(put);
        }
    }
    
    private void setPlayer()
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();
        Room rm = rooms.get(r.nextInt(rooms.size()));
        while(rm.exitRoom())
        {
            rm=rooms.get(r.nextInt(rooms.size()));
        }
        player.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
        creatures.add(player);
    }
    
    private void setRandomExit()
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();
        rooms.get(r.nextInt(rooms.size())).setExit();
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
    	Rectangle2D bounds=new Rectangle2D.Double(minX,minY,maxX-minX,maxY-minY);
    	List<Creature> boundedCreatures=new ArrayList<>();
        for(Creature c: creatures) 
        {
        	if(bounds.contains(c.getPosition())) 
        		boundedCreatures.add(c);
        }
    	
    	return boundedCreatures;
    }
    
    public void update(int delta) throws CloneNotSupportedException,IOException
    {
        for(Action a : actions)
            a.decrementTimer(delta);
        actions.clear();
        for(Creature c : creatures)
        {
            c.removeTimedOutActions();
            List<Action> as = c.getActionsWithUpdate(delta);
            actions.addAll(as);  
        }
        for(Action a : actions)
        {
            for(Creature c : creatures)
            {
                if(a.withinRange(c))
                {
                    Creature test = a.actOnClone(c);
                    if(crrntMap.isValid(test.getPosition()))
                    {
                        a.act(c);
                    }
                }
            }
        }
        List<Creature> dead = new ArrayList<>();
        boolean exit = false;
        for(Creature c : creatures)
        {
            if(c.isDead())
                dead.add(c);
            if(c.containsAttribute(Attribute.PLAYER))
            {
                boolean already=false;
                for(Room r : crrntMap.getRooms())
                {
                    if((r.isValid(c.getPosition()) && (last==null || !r.getID().equals(last.getID())))
                       && !already)
                    {
                        System.out.println(r.getID());
                        last=r;
                        already=true;
                    }
                    if(r.atExit(c.getPosition()))
                        exit=true;
                }
            }
        }
        creatures.removeAll(dead);
        if(exit)
        {
            crrntMap.newLevel();
            Random r = new Random();
            creatures.clear();
            actions.clear();
            addCreatures(r.nextInt(3)+1);
            setPlayer();
            setRandomExit();
            level++;
        }
    }
}
