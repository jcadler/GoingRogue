package edu.brown.cs32.jcalder.GameLogic.RogueMap;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.awt.Point;

/**
 *
 * @author john
 */
public class LogicMap implements RogueMap
{
    private List<Room> rooms;
    
    public LogicMap(List<Room> r)
    {
        rooms = r;
    }
    
    public static LogicMap getRandomMap() throws IOException,IllegalArgumentException
    {
        File folder = new File("./Maps");
        File map;
        List<File> maps = Arrays.asList(folder.listFiles());
        if(maps.size()==1)
            map=maps.get(0);
        else
            map=maps.get((new Random()).nextInt(maps.size()));
        return MapReader.readMap(map);
    }
    
    public boolean isValid(Point p)
    {
        for(Room r : rooms)
        {
            if(r.isValid(p))
                return true;
        }
        return false;
    }
}
