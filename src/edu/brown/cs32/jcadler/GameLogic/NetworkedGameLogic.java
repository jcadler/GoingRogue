package edu.brown.cs32.jcadler.GameLogic;

import java.io.IOException;

/**
 *
 * @author john
 */
public class NetworkedGameLogic extends GameLogic
{
    private int roguePort;
    private boolean server;
    
    public NetworkedGameLogic(int port, boolean s) throws IOException
    {
        super();
        roguePort=port;
        server=s;
    }
    
    
}
