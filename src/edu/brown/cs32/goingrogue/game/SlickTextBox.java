package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class SlickTextBox extends SlickLabel {
	private int width;
	private int height;
	
	public SlickTextBox(GUIContext gc, Font f, String msg, int x, int y, int width, int height) {
		super(gc, f, msg, x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public int getHeight(){
		return height;
	}

	@Override
	public int getWidth(){
		return width;
	}

	@Override
	public void render(GUIContext gc, Graphics g) throws SlickException {
		g.drawRoundRect(x, y, width, height, 15);
		g.drawString(msg, x + 20, y + 20);
	}
}
