package edu.brown.cs32.jcalder.GameLogic;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import edu.brown.cs32.jcalder.GameLogic.RogueMap.LogicMap;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.AICreatureFactory;
import edu.brown.cs32.goingrogue.gameobjects.items.factories.GridItemFactory;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.PlayerFactory;

/**
 *
 * @author john
 */
public class GameLogic 
{
    private LogicMap crrntMap;
    private List<Creature> creatures;
    private Player player;
    
    public GameLogic() throws IOException
    {
        crrntMap = LogicMap.getRandomMap();
        Random r = new Random();
        int numCreatures = r.nextInt(3)+1;
        creatures = new ArrayList<>();
        AICreatureFactory creatureFactory = new AICreatureFactory();
        GridItemFactory itemFactory = new GridItemFactory();
        for(int i=0;i<numCreatures;i++)
        {
            Creature put = creatureFactory.create();
            
        }
    }
}
