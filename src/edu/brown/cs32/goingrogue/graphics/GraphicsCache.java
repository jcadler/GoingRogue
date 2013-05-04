package edu.brown.cs32.goingrogue.graphics;

import java.util.concurrent.ConcurrentHashMap;

import org.newdawn.slick.Image;

/** Caches Images and Animations by their file paths to avoid loading them again from file
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class GraphicsCache {
	
	ConcurrentHashMap<String, Animation> animationCache;
	ConcurrentHashMap<String, Image> imageCache;
	
	public GraphicsCache() {
		animationCache=new ConcurrentHashMap<>();
		imageCache=new ConcurrentHashMap<>();
	}
	
	/** Adds an animation to the cache with the specified path
	 * @return True if an animation already existed under that path name, else false
	 */
	public boolean add(String p, Animation a) {
		return animationCache.put(p, a)!=null;
	}
	
	/** Adds an image to the cache with the specified path
	 * @return True if an image already existed under that path name, else false
	 */
	public boolean add(String p, Image i) {
		return imageCache.put(p, i)!=null;
	}
	
	/** Returns the animation stored by the specified path, or null if none exists
	 */
	public Animation getAnimation(String p) {
		return animationCache.get(p);
	}
	
	/** Returns the image stored by the specified path, or null if none exists
	 */
	public Image getImage(String p) {
		return imageCache.get(p);
	}
}
