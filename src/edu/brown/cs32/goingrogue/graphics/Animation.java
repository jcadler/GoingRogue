package edu.brown.cs32.goingrogue.graphics;

import java.util.Arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** A class that stores an array of images and is able to update, display and pause like a Slick2D
 * animation. Offers more customizability and control than a Slick2D Animation -- needed because
 * Slick's Animation class does not support rotation/scaling easily and its update method
 * occasionally crashed the program.
 * 
 * All times are given in milliseconds
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class Animation {
	
	Image[] images;
	int[] durations;
	int currTime;
	
	String s;
	
	/** Constructs a new Animation
	 * 
	 * @param images The image array to use
	 * @param timePerImage The time to display each image
	 */
	public Animation(Image[] images, int timePerImage) {
		this.images=images;
		durations=new int[images.length];
		for(int i=0; i<images.length; i++) {
			durations[i]=timePerImage;
		}
		currTime=0;
	}
	
	/** Constructs a new Animation
	 * 
	 * @param images The image array to use
	 * @param durations An array of the times to display each image (must match size of {@code images})
	 */
	public Animation(Image[] images, int[] durations) {
		this.images=images;
		this.durations=durations;
		currTime=0;
		
	}

	/** Updates the animation by the specified time
	 * Allows the animation time to exceed the total time, causing the animation to return null afterwards
	 * 
	 * @param delta
	 */
	public void update(int delta) {
		currTime+=delta;
	}
	
	/** Resets the animation time
	 */
	public void reset() {
		currTime%=getDuration();
	}
	
	/** Updates the animation by the specified time
	 * Resets the animation if the time gets too large
	 */
	public void updateWithReset(int delta) {
		currTime+=delta;
		reset();
	}
	
	/** Returns true if the current animation time exceeds the total time, else false
	 */
	public boolean isFinished() {
		return currTime>=getDuration();
	}
	
	
	/** Returns the current image index or -1 if the animation is finished
	 */
	public int getFrame() {
		int durationSum=0;
		int i=-1;
		
		while(durationSum<=currTime) {
			i++;
			
			if(i>=images.length) return -1;
			durationSum+=durations[i];
			
			if(currTime>=getDuration()) {
				System.out.println("Animation is finished: "+this);
				throw new RuntimeException();
			}

		}
		
		return i;
		
		
	}
	
	/** Returns the image at the current frame, or null if the animation is finished
	 */
	public Image getCurrentFrame() {
		
		return (getFrame()==-1 ? null : images[getFrame()]);
	}
	
	/** Returns the number of frames
	 */
	public int getFrameCount() {
		return images.length;
	}
	
	/** Returns the current animation time
	 */
	public int getCurrentTime() {
		return currTime;
	}
	
	/** Returns the total time it will take the animation to play
	 */
	public int getDuration() {
		int sum=0;
		for(int d: durations) sum+=d;
		return sum;
	}
	
	/** Sets the duration of each image to the specified time
	 */
	public void setImageDuration(int timePerImage) {
		for(int i=0; i<durations.length; i++) {
			durations[i]=timePerImage;
		}
	}
	
	/** Sets the duration of the whole animation
	 */
	public void setDuration(int duration) {
		double durationD=(double)duration;
		double imageDuration=durationD/images.length;
		
		for(int i=0; i<durations.length; i++) {
			double lastDuration=durationD;
			durationD-=imageDuration;
			durations[i]=(int)(lastDuration-durationD);
		}
		
		durations[0]+=duration-getDuration();
		
		if(duration!=getDuration()) System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}
	
	/** Returns a copy of this animation
	 */
	public Animation copy() {
		return new Animation(images, durations);
	}
	
	public String toString() {
		String toReturn="Animation [";
		for(int i: durations) toReturn+=""+i+", ";
		toReturn+="] [";
		for(Image i: images) toReturn+=""+i+", ";
		return toReturn+"]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(durations);
		for(Image i: images) {
			result = prime * result + i.getResourceReference().hashCode();
		}
		return result;
	}
	
	//Generates a hash code for the image
	int imageHashCode(Image i) {
		final int prime = 19;
		int result = 5;
		result = prime * result + i.getResourceReference().hashCode();
		result = prime * result + i.getWidth();
		result = prime * result + i.getHeight();
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animation other = (Animation) obj;
		if (!Arrays.equals(durations, other.durations))
			return false;
		if (!Arrays.equals(images, other.images))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
}
