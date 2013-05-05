package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class MenuGame extends StateBasedGame
{
	GamePlayState game;
	int timeCount;
	
	public MenuGame()
	{
		super("Going Rogue");
	}
	
	/*@Override
	public void init(GameContainer gc) throws SlickException {
		g=new GamePlay(gc);
	}*/

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		MainMenu mm = new MainMenu();
		mm.setID(0);
		addState(mm);
		GamePlayState gp = new GamePlayState(gc);
		gp.setID(1);
		addState(gp);
		
		
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new MenuGame());
		app.setDisplayMode(800, 600, false);
		app.setSmoothDeltas(false);
		app.start();
	}
}