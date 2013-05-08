package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.Potion;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class QuaffRange implements Range {

    private Item _item;
    private Creature _sourceCreature;

    public QuaffRange(Item item, Creature sourceCreature) {
        _item = item;
        _sourceCreature = sourceCreature;
    }

    @Override
    public boolean inRange(Creature creature) {
        return _item.getGridItem().getAttributes().contains(Attribute.POTION)
                && creature.equals(_sourceCreature);
    }

    @Override
    public void decrementTimer(int delta) {
        // do nothing
    }
    
    Item getItem() {
        return _item;
    }
    
    Creature getSourceCreature() {
        return _sourceCreature;
    }
}