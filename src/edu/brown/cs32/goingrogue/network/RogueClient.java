package edu.brown.cs32.goingrogue.network;

import java.util.List;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import edu.brown.cs32.jcadler.GameLogic.GameLogic;
/** Basic networking for a non-host player **/
public class RogueClient extends Listener implements RoguePort{
	private Client net;
	private String name;
	GameLogic g = null;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public EndPoint getEndPoint(){
		return net;
	}
	
	public RogueClient(String name)
	{
		this.name = name;
	}
	public RogueClient(String name, Client net)
	{
		this.name = name;
		this.net = net;
	}

	/** Send action objects to the server! **/
	public void send(Object o){
		net.sendTCP(o);
	}

	@Override
	public void start(String host, int port) throws Exception{
		//	TCP only, default buffer should be ok.
		net = new Client();
		net.start();
		net.connect(3000, host, port);
		net.addListener(this);
	}

	@Override
	public void close() {
		if(net != null)
			net.stop();
	}

	@Override
	public void connected(Connection c){
		
	}
	
	@Override
	public void disconnected(Connection c){
		
	}
	
	@Override
	public void received(Connection c, Object o){
		if(o instanceof List){
			//	g.setCreatures(o);	Need some way to set this in GameLogic
		}
		if(o instanceof String){
			try{
				String[] cmd = ((String) o).split("\t");
				if(cmd[0].equals("dc")){
					//	Print reason for disconnection
					System.out.println(cmd[1]);
				}
				else if(cmd[0].equals("map")){
					//	TODO: Not actually a thing yet - manage later...
					//	g.setMap(cmd[1]);
				}
			}
			catch(Exception e){
				
			}
		}
	}
}
