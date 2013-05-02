package edu.brown.cs32.goingrogue.game;

import java.util.HashMap;
import java.util.List;

import org.newdawn.slick.Animation;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.graphics.GraphicsHandler;

/** Caches animations according to the creature and action that initiated them.
 * This ensures that an animation can be played continuously for a creature until the action that
 * animation was initiated by stops happening or is overridden
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class AnimationCache {
	
	//Stores an animation and the action that it is attached to
	static class AnimationData {
		Action action;
		List<Animation> animations;
		
		AnimationData(Action act, List<Animation> anim) {
			action=act;
			animations=anim;
		}
	}
	
	HashMap<Creature, AnimationData> cache;
	
	public AnimationCache() {
		cache=new HashMap<>();
	}
	
	/** Adds a creature and its animation data to the cache
	 * 
	 * @return true if the creature was already in the cache, else false
	 */
	public boolean add(Creature creature, Action action, List<Animation> anim) {
		AnimationData data=cache.put(creature, new AnimationData(action, anim));
		
		System.out.println("Cache - ADDED");
		
		return data!=null;
	}
	
	/** Returns the animation currently associated with the specified creature
	 */
	public List<Animation> get(Creature creature) {
		if(cache.get(creature)==null) return null;
		
		System.out.println("Cache - GETTING, currSize="+cache.size()+", "+cache.get(creature).animations.get(0));
		
		return cache.get(creature).animations;
	}
	
	/** Returns the animation currently associated with the specified creature
	 */
	public Action getAction(Creature creature) {
		if(cache.get(creature)==null) return null;
		return cache.get(creature).action;
	}
}
