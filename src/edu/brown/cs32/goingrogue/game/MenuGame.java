package edu.brown.cs32.goingrogue.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class MenuGame extends StateBasedGame
{
	//	Default name and port number
	private String userName = "Bob";
	private String hostName = "localhost";
	private int portNumber = 54242;
	private String stateData = "data/gamestates.txt";
	//GamePlayState game;
	int timeCount;
	
	public MenuGame()
	{
		super("Going Rogue");
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String un){
		userName = un;
	}
	public int getPortNumber(){
		return portNumber;
	}
	public void setPortNumber(int pn){
		portNumber = pn;
	}
	public String getHostName(){
		return hostName;
	}
	public void setHostName(String hn){
		hostName = hn;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		//	Create a simple list of all available state-type commands here!
		List<String> stateTypes = new ArrayList<String>();
		stateTypes.add("ms");
		stateTypes.add("gp");
		stateTypes.add("l1");
		stateTypes.add("ls");
		stateTypes.add("lc");
		
		int curID = 0;
		try{
			File f = new File(stateData);
			FileReader fr = new FileReader(f);
			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(fr);

			String line = r.readLine();
			while(line != null){
				String[] next = line.split("\t");
				if(next.length != 3 || !stateTypes.contains(next[0]))
					throw new Exception("Bad formatting on button!");
				BasicGameState state = null;	//	Guaranteed: State initializes or Exception
				if(next[0].equals("ms"))
					state = new MenuState(next[1], next[2], curID);
				else if(next[0].equals("gp"))
					state = new GamePlayState(gc, curID);
				else if(next[0].equals("lc"))
					state = new GameLobbyClient(next[1], next[2], curID, this);
				else if(next[0].equals("ls"))
					state = new GameLobbyServer(next[1], next[2], curID, this);
				curID++;
				addState(state);
				line = r.readLine();
			}
			fr.close();
			r.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new SlickException("Failed to initialize game states!");
		}
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new MenuGame());
		app.setDisplayMode(800, 600, false);
		app.setSmoothDeltas(false);
		app.setMinimumLogicUpdateInterval(20);
//		app.setTargetFrameRate(60);
		app.start();
	}
}