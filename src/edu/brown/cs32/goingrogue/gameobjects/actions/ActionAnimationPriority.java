package edu.brown.cs32.goingrogue.gameobjects.actions;

import java.util.ArrayList;
import java.util.List;

/** Prioritizes animations so that only the highest priority action appears
 * For instance, attack animations override move animations
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public enum ActionAnimationPriority {
	
	MOVE, ATTACK, PICKUP;
	
	static List<ActionAnimationPriority> priorities=new ArrayList<>();
	
	/** Returns an integer representing the action animation priority.
	 * Higher priorities are preferred
	 */
	static int getPriority(ActionAnimationPriority a) {
		if(priorities.isEmpty()) {
			priorities.add(PICKUP);
			priorities.add(MOVE);
			priorities.add(ATTACK);
		}
		return priorities.indexOf(a);
	}
	
	public int getPriority() {
		return getPriority(this);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello!");
	}
}
