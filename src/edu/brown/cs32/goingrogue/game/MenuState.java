package edu.brown.cs32.goingrogue.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState{
	private String background = "graphics/menu/mmbg.png";	//	Default is Main Menu!
	private String menuData = "data/menus/mm.txt";
	private Image bg;
	private List<TransitionButton> buttons;
	//private GameContainer gc;	//	Needed?

	private int id; //Used for StateBasedGame
	
	public void setID(int id){
		this.id = id;
	}
	
	public MenuState(){
	}
	
	public MenuState(String background, String menuData, int id){
		this.background = background;
		this.menuData = menuData;
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		try{
			bg = new Image(background).getScaledCopy(gc.getWidth(), gc.getHeight());
		}
		catch(Exception e){
			System.err.println("No background image!");
			System.exit(1);
		}
		//this.gc = gc;
		buttons = new ArrayList<TransitionButton>();
		Class from = FadeOutTransition.class;
		Class to = FadeInTransition.class;
		try{
			File f = new File(menuData);
			FileReader fr = new FileReader(f);
			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(fr);
			String line = r.readLine();
			while(line != null){
				String[] next = line.split("\t");
				if(next.length != 4)
					throw new Exception("Bad formatting on button!");
				Image i = new Image(next[0]).getScaledCopy(200, 100);
				int ns = Integer.parseInt(next[1]);
				int x = Integer.parseInt(next[2]);
				int y = Integer.parseInt(next[3]);
				TransitionButton b = new TransitionButton(gc, i, x, y, from, to, ns, game);
				buttons.add(b);
				line = r.readLine();
			}
			r.close();
			fr.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			throw new SlickException("Failed to read in menu data!");
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		//	Draw background
		//	Color c = Color.RED;
		g.drawImage(bg, 0f, 0f);
		for(TransitionButton t : buttons){
			t.render(gc, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return id;
	}

}
