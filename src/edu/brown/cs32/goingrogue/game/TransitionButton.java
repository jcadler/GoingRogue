package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class TransitionButton extends ActionButton{
	private final Class<Transition> from;
	private final Class<Transition> to;
	private final int nextState;
	
	public TransitionButton(GUIContext gc, Image img, int x, int y, Class<Transition> from,
			Class<Transition> to, int nextState, StateBasedGame game) {
		super(gc, img, x, y, game);
		this.from = from;
		this.to = to;
		this.nextState = nextState;
	}
	
	@Override
	public void componentActivated(AbstractComponent c) {
		try{
			Transition f = from.newInstance();
			Transition t = to.newInstance();
			buttonAction();
			game.enterState(nextState, f, t);
			game.getCurrentState().leave(game.getContainer(), game);
		}
		catch(Throwable e){
			//	SHOULD NOT HAPPEN
			System.err.println("Cannot instantiate Transitions!");
		}
	}
}
