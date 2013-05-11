package edu.brown.cs32.goingrogue.network;

import java.util.List;

import org.newdawn.slick.state.StateBasedGame;

import com.esotericsoftware.kryonet.EndPoint;

import edu.brown.cs32.jcadler.GameLogic.NetworkedGameLogic;

public interface RoguePort{
	public void start(String host, int port) throws Exception;
	public void close();
	public boolean isOpen();
	public void addGame(NetworkedGameLogic g);
	public String getName();
	public void setName(String name);
	public EndPoint getEndPoint();
	public List<String> getPlayerNames();
	public void setGame(StateBasedGame game);
}
