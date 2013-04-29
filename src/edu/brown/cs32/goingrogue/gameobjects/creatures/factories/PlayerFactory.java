package edu.brown.cs32.goingrogue.gameobjects.creatures.factories;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import static edu.brown.cs32.goingrogue.gameobjects.creatures.Attribute.*;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class PlayerFactory {

    public static Player create() {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(PLAYER);
        String sprite = ""; // TODO fill this in later
        Player returnCreature = new Player(new Point2D.Double(0.0, 0.0), Math.PI / 2.0, "Bob",
                attributes, Constants.STARTING_PLAYER_STATS, sprite);
        returnCreature.addItem(new Item(GridItemFactory.create()));
        return returnCreature;
    }
}
