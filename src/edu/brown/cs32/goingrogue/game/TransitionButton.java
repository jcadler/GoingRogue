package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class TransitionButton extends MouseOverArea implements ComponentListener{
	private final Class<Transition> from;
	private final Class<Transition> to;
	private final int nextState;
	private final StateBasedGame game;
	
	public TransitionButton(GUIContext gc, Image img, int x, int y, Class<Transition> from,
			Class<Transition> to, int nextState, StateBasedGame game) {
		super(gc, img, x, y);
		this.from = from;
		this.to = to;
		this.nextState = nextState;
		this.game = game;
		addListener(this);
		setMouseOverColor(new Color(225, 225, 225));
		setMouseDownColor(new Color(195, 195, 195));
	}
	
	@Override
	public void componentActivated(AbstractComponent arg0) {
		try{
			Transition f = from.newInstance();
			Transition t = to.newInstance();
			game.enterState(nextState, f, t);
		}
		catch(Throwable e){
			//	SHOULD NOT HAPPEN
			System.err.println("Cannot instantiate Transitions!");
		}
	}
}
