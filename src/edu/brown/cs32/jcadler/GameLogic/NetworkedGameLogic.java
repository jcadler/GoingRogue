package edu.brown.cs32.jcadler.GameLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.ChangeDirectionAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.network.RogueClient;
import edu.brown.cs32.goingrogue.network.RoguePort;
import edu.brown.cs32.goingrogue.network.RogueServer;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

/**
 *
 * @author john
 */
public class NetworkedGameLogic extends GameLogic
{
    private RoguePort port;	//	Networking aspect!
    private boolean isServer;	//	Is this a host player?
    private boolean initCreatures = false;
    
    public NetworkedGameLogic() throws IOException{
    	
    }
    
    public NetworkedGameLogic(RoguePort port, LogicMap map, HashMap<Integer, Player> players, Player pl, boolean serv) throws IOException
    {
        super(map, new ArrayList<Creature>(), pl);
        for(Player p : players.values()){
        	setPlayer(p);
        }
    	selectPlayer(pl);
        //addCreatures(10, 4);
        this.port = port;
        if(port != null)
        	port.addGame(this);
        isServer = serv;//(port instanceof RogueServer);	//	SHOULD be true
    }
    public NetworkedGameLogic(RoguePort port, NetworkedGameLogic base, Player pl) throws IOException{
    	super((LogicMap)base.getMap(), base.getCreatures(), pl);
    	selectPlayer(pl);
        this.port = port;
        if(port != null)
        	port.addGame(this);
        isServer = false;//(port instanceof RogueServer);	//	SHOULD be false
    }
    public void end(){
    	//System.err.println("YYYYYYY");
    	port.close();
    }

	public RoguePort getPort() {
		return port;
	}

	public void setPort(RoguePort port) {
		this.port = port;
	}
	public void update(int delta) throws CloneNotSupportedException,IOException
    {
		/*if(port != null){
			System.out.println("Port status: " + port.isOpen());
		}*/
		if(isServer && port != null){
			((RogueServer)port).checkWin();
			if(!initCreatures){
				addCreatures(4, 1);
				actions = new ArrayList<>();
				initCreatures = true;
			}
			//((RogueServer) port).updateClients(creatures);
			//((RogueServer) port).updateClients(actions);
		}
		else if(port != null){
			for(Action a : player.getActions()){
				((RogueClient) port).send(a);
			}
		}
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
                	if(c.equals(player)){
                		
                	}
                	boolean goodAction = true;
                	if(a instanceof MoveAction || a instanceof ChangeDirectionAction){
                		Creature test = a.actOnClone(c);
                		goodAction = crrntMap.isValid(test.getCenterPosition());
                	}
                    if(goodAction && !c.containsAttribute(Attribute.PLAYER))
                        a.act(c);
                    else if(c.containsAttribute(Attribute.PLAYER) && goodAction)
                    {
                        a.act(c);
                    }
                }
            }
        }
        List<Creature> dead = new ArrayList<>();
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
                }
            }
        }
        creatures.removeAll(dead);
    }
    
}
