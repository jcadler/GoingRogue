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
	
	/** Changes the time an animation takes to run
	 * 
	 * @param a The animation to be handled
	 * @param time The time that the animation should take (in milliseconds)
	 */
	public static void setTime(Animation animation, int time) {
		//Calculates the length
		int[] lengths=animation.getDurations();
		float currTime=0;
		for(int i: lengths) currTime+=i;
		
		animation.setSpeed(currTime/time);
	}
	
	/** Sets the duration of each frame of the animation
	 * 
	 * @param durations An array of the msec durations for each frame in the animation
	 * @return The time in msecs that it will take to run the new animation
	 * @exception IllegalArgumentException Thrown if the array input does not match the length of the animation
	 */
	public static void setDurations(Animation a, int[] durations) throws IllegalArgumentException {
		if(durations.length!=a.getFrameCount())
			throw new IllegalArgumentException("Animation had a different number of frames than the array specified");
		
		for(int i=0; i<durations.length; i++) {
			a.setDuration(i, durations[i]);
		}
	}
}