package edu.brown.cs32.goingrogue.graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** Loads an animation from file given a pathname
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class GraphicsLoader {
	
	static GraphicsCache cache=new GraphicsCache();
	
	//The filter to use on an image
	static int filter=Image.FILTER_NEAREST;
	
	/** Loads the image for a creature whose directory is rooted at the specified path
	 * (Same as loadImageAt, but it automatically appends "1.png" to the end of the path for ease)
	 */
	public static Image loadImage(String path) throws SlickException {
		path+="1.png";
		
		return loadImageAt(path);
	}
	
	/** Loads the image for a creature whose image is located at the specified path
	 */
	public static Image loadImageAt(String path) throws SlickException {
		if(cache.getImage(path)==null) cache.add(path, new Image(path, false, filter));
		
		return cache.getImage(path);
	}
	
	/** Sets the filter type to use on all subsequent animations until it is set again
	 */
	public static void setFilterType(int filterType) {
		filter=filterType;
	}
	
	/** Loads an animation rooted at the specified path
	 */
	public static Animation load(String path) {
		
		//Loads all images in the given directory
		//Loads in order "1.png, 2.png..." etc
		//Throws an exception if a file not matching this format is in the directory
		if(cache.getAnimation(path)==null) try {
			
			List<Image> images=new ArrayList<>();
			
			File f=new File(path);
			List<String> fileNames=new ArrayList<String>(Arrays.asList(f.list()));
			
			int i=1;
			while(i<=fileNames.size()) {
				
				//Breaks if a file cannot be found
				if(!fileNames.contains(""+i+".png"))
					throw new SlickException("Animation directory "+path+" contained a file that was not properly formatted. Failed on file number "+i);
				
				images.add(new Image(path+i+".png", false, filter));
				i++;
			}
			
			//Creates an auto-updating image from the found files
			Animation a=new Animation(images.toArray(new Image[]{}), //Images
										(int)(1000./* /Constants.FRAMERATE */), //Time per image
										true);
			cache.add(path, a);
			
		} catch(SlickException e) {
			//Could not load the animation
			e.printStackTrace();
		}
		
		return cache.getAnimation(path);
	}
	
	/** Loads the movement animation for a creature whose directory is rooted at the specified path
	 */
	public static Animation loadMove(String path) {
		return load(path+"move/");
	}
	
	/** Loads the movement animation for a creature whose directory is rooted at the specified path
	 */
	public static Animation loadAttack(String path) {
		return load(path+"attack/");
	}
}