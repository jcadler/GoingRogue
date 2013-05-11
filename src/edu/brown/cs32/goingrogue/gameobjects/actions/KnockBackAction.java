package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;

public class KnockBackAction extends MoveAction {
	public KnockBackAction(){}
	public KnockBackAction(double direction, Creature creature, int delta){
		super(direction, creature, delta);
		_type = ActionType.CHANGE_DIR;	//	No animation
	}
}
