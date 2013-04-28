package edu.brown.cs32.goingrogue.network;

import java.awt.geom.Point2D;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Inventory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;

public class Network {
	public static final int port = 54242;

	public static void register(EndPoint e){
		Kryo k = e.getKryo();
		//	Register any and all classes being sent over the network!
		//	k.register(Action.class);
		k.register(String.class);
		k.register(GridItem.class);
		k.register(Creature.class);
		k.register(Player.class);
		//	Items in Creature
		k.register(List.class);
		k.register(Point2D.class);
		k.register(Attribute.class);
		k.register(CreatureStats.class);
		k.register(Stats.class);
		k.register(Inventory.class);
		k.register(Item.class);
	}
}
