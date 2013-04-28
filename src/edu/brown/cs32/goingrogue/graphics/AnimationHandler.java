package edu.brown.cs32.goingrogue.graphics;

import org.newdawn.slick.Animation;

/** Supplies tools for handling an animation
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class AnimationHandler {
	
	Animation animation;
	
	/** Constructs a new AnimationHandler
	 * 
	 * @param a The animation to be handled
	 */
	public AnimationHandler(Animation a) {
		animation=a;
	}
	
	/** Constructs a new AnimationHandler whose animation must run in a given time constraint
	 * 
	 * @param a The animation to be handled
	 * @param time The time that the animation should take (in milliseconds)
	 */
	public AnimationHandler(Animation a, int time) {
		animation=a;
		
		//Calculates the length in 
		int[] lengths=animation.getDurations();
		float currTime=0;
		for(int i: lengths) currTime+=i;
		
		animation.setSpeed(currTime/time);
	}
	
	/** Returns the animation
	 */
	public Animation getAnimation() {
		return animation;
	}
	
	/** Updates the animation
	 * NOTE Nearly all animations should be autoupdating
	 * Only use this method in the rare case that one is not
	 * 
	 * @param time The amount of time required to pass since the last update before this one takes place
	 */
	public void update(int time) {
		animation.update(time);
	}
	
	/** Pauses the animation
	 */
	public void pause() {
		animation.stop();
	}
	
	/** Unpauses the animation
	 */
	public void unpause() {
		animation.start();
	}
	
	/** Reports whether the animation has finished displaying
	 * 
	 * @return True if the animation is finished displaying, else false
	 */
//	public boolean isFinished() {
		
//	}
}
