package edu.brown.cs32.jcalder.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import edu.brown.cs32.jcalder.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.AICreatureFactory;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
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
        Random r = new Random();
        int numCreatures = r.nextInt(3);
        creatures = new ArrayList<>();
        items = new ArrayList<>();
        for(int i=0;i<numCreatures;i++)
        {
            creatures.add(
        }
    }
}
