package edu.brown.cs32.jcalder.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import edu.brown.cs32.jcalder.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.items.Item;
import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;

/**
 *
 * @author john
 */
public class GameLogic 
{
    private LogicMap crrntMap;
    private List<Creature> creatures;
    private List<GridItem> items;
    
    public GameLogic() throws IOException
    {
        crrntMap = LogicMap.getRandomMap();
    }
}
