package edu.brown.cs32.goingrogue.graphics;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.constants.Constants;

/** Loads an animation from file given a pathname
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */

public class AnimationLoader {
	
	//The filter to use on an image
	static int filter=Image.FILTER_NEAREST;
	
	public static Animation load(String path) {
		
		List<Image> images=new ArrayList<>();
		
		//Loads images until one cannot be found
		try {
			
			int i=1;
			while(true) {
				
			//TEST
				System.out.println("Trying to load "+path+i+".png");
				
				images.add(new Image(path+i+".png", false, filter));
				i++;
			}
		
		} catch(RuntimeException e) {
			
		} catch(SlickException e) {
			
		}
		
		//Creates an auto-updating image from the found files
		Animation a=new Animation(images.toArray(new Image[]{}), //Images
									(int)(1000./Constants.FRAMERATE), //Time per image
									true); 
		return a;
	}
	
	public static Animation loadMove(String path) {
		return load(path+"move/");
	}
	
	public static Animation loadAttack(String path) {
		return load(path+"attack/");
	}
	
	/** Sets the filter type to use on all subsequent animations until it is set again
	 */
	public static void setFilterType(int filterType) {
		filter=filterType;
	}
}