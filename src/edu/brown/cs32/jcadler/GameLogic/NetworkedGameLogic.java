package edu.brown.cs32.jcadler.GameLogic;

import java.io.IOException;

import edu.brown.cs32.goingrogue.network.RoguePort;
import edu.brown.cs32.goingrogue.network.RogueServer;

/**
 *
 * @author john
 */
public class NetworkedGameLogic extends GameLogic
{
    private RoguePort port;	//	Networking aspect!
    private boolean isServer;	//	Is this a host player?
    
    public NetworkedGameLogic(RoguePort port) throws IOException
    {
        super();
        this.port = port;
        port.addGame(this);
        isServer = (port instanceof RogueServer);
    }
    
    
}
