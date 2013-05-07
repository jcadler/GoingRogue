package edu.brown.cs32.goingrogue.network;

import java.util.List;

import com.esotericsoftware.kryonet.EndPoint;

public interface RoguePort{
	public void start(String host, int port) throws Exception;
	public void close();
	public String getName();
	public void setName(String name);
	public EndPoint getEndPoint();
	public List<String> getPlayerNames();
}
