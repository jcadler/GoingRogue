package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Inventory;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.Potion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class QuaffAction extends Action {

    Range _range;
    
  //  int numQuaffs;
    
    public QuaffAction(){}
    public QuaffAction(Item item, Creature sourceCreature) {
        super(0, new QuaffRange(item, sourceCreature));
        _type=ActionType.QUAFF;
        
     //   numQuaffs=1;
    }

    @Override
    public void act(Creature creature) {
        Potion potion = Inventory.makePotion(((QuaffRange) getRange()).getItem());
        potion.act(((QuaffRange) getRange()).getSourceCreature());
        
       // if(numQuaffs==1) throw new RuntimeException("Testing!");
       // numQuaffs++;
    }

    @Override
    public List<ActionAnimation> getActionAnimations() {
        return new ArrayList<>();
    }
}
