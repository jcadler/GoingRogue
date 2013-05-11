package edu.brown.cs32.goingrogue.network;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryonet.EndPoint;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.actions.ActionAnimation;
import edu.brown.cs32.goingrogue.gameobjects.actions.ActionType;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.ArcAttackRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.ChangeDirectionAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.ChangeDirectionRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.KnockBackAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.MoveRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.PickupRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.QuaffAction;
import edu.brown.cs32.goingrogue.gameobjects.actions.QuaffRange;
import edu.brown.cs32.goingrogue.gameobjects.actions.Range;
import edu.brown.cs32.goingrogue.gameobjects.actions.util.RangeUtil;
import edu.brown.cs32.goingrogue.gameobjects.creatures.AICreature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.CreatureStats;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Inventory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Stats;
import edu.brown.cs32.goingrogue.gameobjects.items.AttackPotion;
import edu.brown.cs32.goingrogue.gameobjects.items.DefensePotion;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;
import edu.brown.cs32.goingrogue.gameobjects.items.HealthPotion;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.ItemStats;
import edu.brown.cs32.goingrogue.gameobjects.items.Potion;
import edu.brown.cs32.goingrogue.map.RogueMap;
import edu.brown.cs32.goingrogue.map.Space;
import edu.brown.cs32.goingrogue.map.Tile;
import edu.brown.cs32.goingrogue.map.Wall;
import edu.brown.cs32.goingrogue.util.CreatureSize;
import edu.brown.cs32.goingrogue.util.IndexPair;
import edu.brown.cs32.goingrogue.util.Location;
import edu.brown.cs32.goingrogue.util.Text;
import edu.brown.cs32.goingrogue.util.Util;
import edu.brown.cs32.jcadler.GameLogic.GameLogic;
import edu.brown.cs32.jcadler.GameLogic.NetworkedGameLogic;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Corridor;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.MapReader;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.Room;

public class Network {
	public static final int port = 54242;

	public static void register(EndPoint e){
		Kryo k = e.getKryo();
		//	Register any and all classes being sent over the network!
		//	Key Classes
		k.setDefaultSerializer(FieldSerializer.class);
		k.register(File.class, new JavaSerializer());
		k.register(RoguePort.class);
		k.register(NetworkedGameLogic.class);
		k.register(GameLogic.class);
		k.register(ArrayList.class);
		k.register(HashMap.class);
		k.register(Creature.class);
		k.register(Player.class);
		k.register(java.util.UUID.class, new JavaSerializer());
		//	Items in Creature
		k.register(List.class);
		k.register(Point2D.class);
		k.register(java.awt.geom.Point2D.Double.class);
		k.register(Rectangle2D.class);
		k.register(java.awt.geom.Rectangle2D.Double.class);
		k.register(Rectangle.class);
		k.register(java.awt.Rectangle.Double.class);
		k.register(Attribute.class);
		k.register(CreatureStats.class);
		k.register(Stats.class);
		k.register(Inventory.class);
		k.register(Item.class);
		k.register(AICreature.class);
		//	Classes in Action
		k.register(Action.class);
		k.register(ActionAnimation.class);
		k.register(ActionType.class);
		k.register(ChangeDirectionAction.class);
		k.register(ChangeDirectionRange.class);
		k.register(QuaffAction.class);
		k.register(QuaffRange.class);
		k.register(Range.class);
		k.register(ArcAttackAction.class);
		k.register(ArcAttackRange.class);
		k.register(MoveAction.class);
		k.register(MoveRange.class);
		k.register(PickupAction.class);
		k.register(PickupRange.class);
		k.register(KnockBackAction.class);	
		k.register(RangeUtil.class);
		//	Classes in Items
		k.register(GridItem.class);
		k.register(Potion.class);
		k.register(ItemStats.class);
		k.register(AttackPotion.class);
		k.register(DefensePotion.class);
		k.register(HealthPotion.class);
		//	Classes in Map
		k.register(RogueMap.class);
		k.register(Space.class);
		k.register(Tile.class);
		k.register(Wall.class);
		k.register(Room.class);
		k.register(Corridor.class);
		//k.register(Room.class, new ReferenceFieldSerializer(k, Room.class));
		//k.setSerializer(Room.class, new ReferenceFieldSerializer(k, Room.class));
		//k.register(Corridor.class, new ReferenceFieldSerializer(k, Corridor.class));
		//k.setSerializer(Corridor.class, new ReferenceFieldSerializer(k, Corridor.class));
		k.register(LogicMap.class);
		k.register(MapReader.class);
		//	Classes in util???
		k.register(CreatureSize.class);
		k.register(IndexPair.class);
		k.register(Location.class);
		k.register(Text.class);
		k.register(Util.class);
	}
}
