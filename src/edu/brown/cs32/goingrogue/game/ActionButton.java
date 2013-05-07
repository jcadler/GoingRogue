package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

public class ActionButton extends MouseOverArea implements ComponentListener{
	protected final StateBasedGame game;
	
	public ActionButton(GUIContext gc, Image img, int x, int y, StateBasedGame game) {
		super(gc, img, x, y);
		this.game = game;
		addListener(this);
		setMouseOverColor(new Color(225, 225, 225));
		setMouseDownColor(new Color(195, 195, 195));
	}
	
	@Override
	public void componentActivated(AbstractComponent c) {
		try{
			buttonAction();
		}
		catch(Throwable e){
			//	SHOULD NOT HAPPEN
			System.err.println("Cannot perform actions!");
		}
	}
	
	public void buttonAction(){}
}
