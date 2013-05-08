package edu.brown.cs32.goingrogue.gameobjects.items.factories;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.getItemName;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.getSprite;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.util.RandomDataUtil.randomItemStats;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class GridPotionFactory {
    public static GridItem create(List<Creature> creatures, List<Room> rooms) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(Attribute.POTION_TYPE);
        attributes.add(randomPotionType());
        String name = getItemName(attributes);
        String sprite = getSprite(attributes);
        ItemStats stats = randomItemStats(attributes);
        CreatureSize size = new CreatureSize(1.0, 1.0);
        GridItem returnCreature = new GridItem(new Point2D.Double(0.0, 0.0),
                name, attributes, stats, sprite, size);
        return returnCreature;
    }
    
    public static Attribute randomPotionType() {
    	int rand=(int)(3*Math.random());
    	switch(rand) {
    		case 0: return Attribute.ATTACK_POTION;
    		case 1: return Attribute.DEFENSE_POTION;
    		case 2: return Attribute.HEALTH_POTION;
    	}
    	
    	return Attribute.ATTACK_POTION;
    }
}
