package edu.brown.cs32.jcadler.GameLogic;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.ActionType;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.AICreatureFactory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.PlayerFactory;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.util.XPCalculator;
import edu.brown.cs32.goingrogue.map.RogueMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

/**
 *
 * @author john
 */
public class GameLogic 
{
    protected LogicMap crrntMap;
    protected List<Creature> creatures;
    protected List<Action> actions;
    public void setCreatures(List<Creature> creatures) {
		this.creatures = creatures;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	protected Player player;
    protected int level;
    protected Room last;
    
    public void selectPlayer(Player p){
    	if(creatures.contains(p))
    		player = p;
    	else
    		System.err.println("Trying to select non-present player!");
    }
    
    public GameLogic() throws IOException
    {
        crrntMap = LogicMap.getRandomMap();
        creatures = new ArrayList<>();
        actions = new ArrayList<>();
        setRandomExit();
        player = PlayerFactory.create(null, null);//creatures,crrntMap.getRooms());
        player.setName("Player");
        setPlayer(player);
        addCreatures(5,2);
        level=0;
    }
    
    public GameLogic(LogicMap map, List<Creature> creatures, Player player){
    	crrntMap = map;
    	this.creatures = creatures;
    	//selectPlayer(player);
        actions = new ArrayList<>();
    	level = 0;
    }
    
    protected void addCreatures(int maxCreatures, int maxItems)
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();

        for(Room rm : rooms)
        {
            int numC;
            if(maxCreatures!=0)
                numC = r.nextInt(maxCreatures);
            else
                numC=0;
            int numI = r.nextInt(maxItems);
            if(rm.isValid(player.getCenterPosition()))
                continue;
            for(int i=0;i<numC;i++)
            {
            	List<Creature> tgt = new ArrayList<>();
            	for(Creature c : creatures){
            		if(c instanceof Player){
            			tgt.add(c);
            		}
            	}
                Creature addC = AICreatureFactory.create(tgt,crrntMap.getRooms(),level);
                addC.setCenterPosition(new Point2D.Double(r.nextInt(rm.getWidth())+rm.getX(),
                                                         r.nextInt(rm.getHeight())+rm.getY()));
                creatures.add(addC);
            }
            for(int i=0;i<numI;i++)
            {
                Creature addI = GridItemFactory.create(creatures,crrntMap.getRooms(),level);
                Point2D p = new Point2D.Double(r.nextInt(rm.getWidth())+rm.getX(),
                                                         r.nextInt(rm.getHeight())+rm.getY());
                addI.setCenterPosition(p);
                creatures.add(addI);
            }
        }
        
    }
    
    protected void setPlayer(Player p)
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();
        Room rm = rooms.get(r.nextInt(rooms.size()));
        while(rm.exitRoom())
        {
            rm=rooms.get(r.nextInt(rooms.size()));
        }
        p.setPosition(new Point2D.Double(rm.getX()+r.nextInt(rm.getWidth()),rm.getY()+r.nextInt(rm.getHeight())));
        creatures.add(p);
    }
    
    private void setRandomExit()
    {
        Random r = new Random();
        List<Room> rooms = crrntMap.getRooms();
        rooms.get(r.nextInt(rooms.size())).setExit();
    }
    
    public void end(){
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public RogueMap getMap()
    {
        return crrntMap;
    }
    public void setMap(LogicMap m){
    	crrntMap = m;
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
    
    public int getFloor()
    {
        return level;
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
                    Creature test;
                    if(!a.type().equals(ActionType.PICKUP))
                        test = a.actOnClone(c);
                    else
                    {
                        a.act(c);
                        continue;
                    }
                    if(crrntMap.isValid(test.getCenterPosition()) && !c.containsAttribute(Attribute.PLAYER))
                        a.act(c);
                    else if(c.containsAttribute(Attribute.PLAYER) && crrntMap.isValid(test.getPosition()))
                        a.act(c);
                }
            }
        }
        List<Creature> dead = new ArrayList<>();
        boolean exit = false;
        List<Creature> items = new ArrayList<>();
        for(Creature c : creatures)
        {
            if(c.isDead())
            {
                dead.add(c);
                player.incXP(XPCalculator.getXP(c));
                if(c.containsAttribute(Attribute.ITEM))
                    System.out.println(c.getName());
                if(!c.containsAttribute(Attribute.ITEM))
                {
                    Creature item = GridItemFactory.create(creatures,crrntMap.getRooms(),level);
                    item.setCenterPosition(c.getCenterPosition());
                    items.add(item);
                }
            }
            if(c.containsAttribute(Attribute.PLAYER))
            {
                for(Room r : crrntMap.getRooms())
                {
                    if(r.atExit(c.getPosition()))
                        exit=true;
                }
            }
        }
        creatures.addAll(items);
        creatures.removeAll(dead);
        if(exit)
        {
            crrntMap.newLevel();
            creatures.clear();
            actions.clear();
            setPlayer(player);
            addCreatures(5,2);
            setRandomExit();
            level++;
        }
    }
}
