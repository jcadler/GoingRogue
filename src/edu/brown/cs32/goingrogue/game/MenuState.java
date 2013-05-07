package edu.brown.cs32.goingrogue.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState{
	protected String background = "graphics/menu/mmbg.png";	//	Default is Main Menu!
	protected String menuData = "data/menus/mm.txt";
	private Image bg;
	private List<AbstractComponent> components;
	protected List<TextField> inputFields;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		components = new ArrayList<>();
		inputFields = new ArrayList<>();
		Class from = FadeOutTransition.class;
		Class to = FadeInTransition.class;
		Font font = gc.getDefaultFont();
		try{
			File f = new File(menuData);
			FileReader fr = new FileReader(f);
			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(fr);
			String line = r.readLine();
			while(line != null){
				String[] next = line.split("\t");
				if(next.length != 5)
					throw new Exception("Bad formatting in menu data: " + line + ", " + next.length);
				int x = Integer.parseInt(next[3]);
				int y = Integer.parseInt(next[4]);
				AbstractComponent nextItem = null;
				if(next[0].equals("button")){
					Image i = new Image(next[1]).getScaledCopy(200, 100);
					nextItem = new ActionButton(gc, i, x, y, game);
					//	Manually create the proper ActionButtons in their required areas!
				}
				else if(next[0].equals("tbutton")){
					int ns = Integer.parseInt(next[2]);
					Image i = new Image(next[1]).getScaledCopy(200, 100);
					nextItem = new TransitionButton(gc, i, x, y, from, to, ns, game);
				}
				else if(next[0].equals("textfield")){
					int width = Integer.parseInt(next[1]);
					int height = Integer.parseInt(next[2]);
					TextField t = new TextField(gc, font, x, y, width, height);
					inputFields.add(t);
					nextItem = t;
				}
				else if(next[0].equals("label")){
					nextItem = new SlickLabel(gc, font, next[1], x, y);
				}
				else{
					throw new Exception("Bad formatting in menu data: " + line + ", " + next.length);
				}
				components.add(nextItem);
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
		g.drawImage(bg, 0f, 0f);
		for(AbstractComponent c : components){
			c.render(gc, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		//	Doesn't really update. :/

	}

	@Override
	public int getID() {
		return id;
	}

}
