package edu.brown.cs32.jcadler.GameLogic.RogueMap;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author john
 */
public class MapReader 
{
    public static LogicMap readMap(File f) throws IOException,IllegalArgumentException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        List<Room> rooms = new ArrayList<>();
        List<Corridor> cs = new ArrayList<>();
        Map<String,Room> roomMap = new HashMap<>();
        String line;
        while((line = read.readLine())!=null)
        {
            List<String> s = Arrays.asList(line.split("\t"));
            switch(s.get(0))
            {
                case "Room":
                    rooms.add(parseRoom(s.subList(1,s.size()),roomMap));
                    break;
                case "Corridor":
                    cs.add(parseCorridor(s.subList(1,s.size()),roomMap));
                    break;
                default:
                    throw new IllegalArgumentException("Map file is malformatted");
            }
        }
        read.close();
        for(Corridor c : cs)
        {
            boolean addStart=false;
            for(Room r : rooms)
            {
                if(r.getID().equals(c.getStart().getID()))
                {
                    r.addCorridor(c);
                    addStart=true;
                }
            }
            if(!addStart)
                throw new IllegalArgumentException("A corridor lacks a starting room");
        }
        return new LogicMap(rooms);
    }
    
    private static Room parseRoom(List<String> s, Map<String,Room> rooms) throws IllegalArgumentException
    {
        try
        {
            int x = Integer.parseInt(s.get(0));
            int y = Integer.parseInt(s.get(1));
            int width = Integer.parseInt(s.get(2));
            int height = Integer.parseInt(s.get(3));
            String id = s.get(4);
            Room ret = new Room(new Point(x,y),width,height,id,false);
            rooms.put(id,ret);
            return ret;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(s.toString());
            throw new IllegalArgumentException("Room string is formatted incorrectly");
        }
    }
    
    private static Corridor parseCorridor(List<String> s,Map<String,Room> rooms) throws IllegalArgumentException
    {
        try
        {
            String start = s.get(0);
            String end = s.get(1);
            int dir = Integer.parseInt(s.get(2));
            int width = Integer.parseInt(s.get(3));
            String[] poss = s.get(4).split(",");
            int pos1 = Integer.parseInt(poss[0]);
            int pos2 = Integer.parseInt(poss[1]);
            if(rooms.get(start)==null)
                System.out.println(start+" is null");
            if(rooms.get(end)==null)
                System.out.println(end+" is null");
            if(rooms.get(start)==null || rooms.get(end)==null)
                throw new Exception();
            return new Corridor(rooms.get(start),rooms.get(end),dir,width,pos1,pos2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(s.toString());
            throw new IllegalArgumentException("Corridor string is formatted incorrectly");
        }
    }
}
