package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class SlickLabel extends AbstractComponent{
	protected Font f;
	protected String msg;
	protected int x, y;
	public SlickLabel(GUIContext gc, Font f, String msg, int x, int y){
		super(gc);
		this.f = f;
		this.msg = msg;
		this.x = x;
		this.y = y;
	}

	public String getMsg(){
		return msg;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	@Override
	public int getHeight(){
		return f.getLineHeight();
	}

	@Override
	public int getWidth(){
		return f.getWidth(msg);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void render(GUIContext gc, Graphics g) throws SlickException {
		g.drawString(msg, x, y);
	}

	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
