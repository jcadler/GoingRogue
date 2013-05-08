package edu.brown.cs32.jcadler.GameLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
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
    
    public NetworkedGameLogic(RoguePort port, LogicMap map, List<Creature> players, Player pl) throws IOException
    {
        super(map, players, pl);
        addCreatures(10, 4);
        this.port = port;
        port.addGame(this);
        isServer = (port instanceof RogueServer);	//	SHOULD be true
    }
    public NetworkedGameLogic(RoguePort port, NetworkedGameLogic base, Player pl) throws IOException{
    	super((LogicMap)base.getMap(), base.getCreatures(), pl);
        this.port = port;
        port.addGame(this);
        isServer = (port instanceof RogueServer);	//	SHOULD be false
    }

	public RoguePort getPort() {
		return port;
	}

	public void setPort(RoguePort port) {
		this.port = port;
	}
	public void update(int delta) throws CloneNotSupportedException,IOException
    {
		if(isServer){
			((RogueServer) port).updateClients(creatures);
			((RogueServer) port).updateClients(actions);
		}
		else{
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
                    Creature test = a.actOnClone(c);
                    if(crrntMap.isValid(test.getCenterPosition()) && !c.containsAttribute(Attribute.PLAYER))
                        a.act(c);
                    else if(c.containsAttribute(Attribute.PLAYER) && crrntMap.isValid(test.getPosition()))
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
    }
    
}
