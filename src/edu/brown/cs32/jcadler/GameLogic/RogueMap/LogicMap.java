package edu.brown.cs32.jcadler.GameLogic.RogueMap;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.geom.Point2D;
import java.awt.Rectangle;

import edu.brown.cs32.goingrogue.map.RogueMap;
import edu.brown.cs32.goingrogue.map.Space;

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
        File folder = new File("Maps");
        File map;
        List<File> maps = Arrays.asList(folder.listFiles());
        if(maps.size()==1)
            map=maps.get(0);
        else
            map=maps.get((new Random()).nextInt(maps.size()));
        return MapReader.readMap(map);
    }
    
    public boolean isValid(Point2D.Double p)
    {
        for(Room r : rooms)
        {
            if(r.isValid(p))
                return true;
        }
        return false;
    }
    
    public List<Room> getRooms()
    {
        return rooms;
    }
    
    public List<Space> getData(int minX, int minY,int maxX, int maxY)
    {
        Rectangle view = new Rectangle(minX,minY,maxX-minX,maxY-minY);
        List<Space> ret = new ArrayList<>();
        for(Room r : rooms)
        {
            Rectangle rm = new Rectangle(r.getX(),r.getY(),r.getWidth(),r.getHeight());
            if(view.intersects(rm))
                ret.add(r);
            for(Corridor c : r.getCorridors())
            {
                if(view.intersects(c.getRectangle()))
                    ret.add(c);
            }
        }
        return ret;
    }
}
