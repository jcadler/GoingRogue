package edu.brown.cs32.jcalder.GameLogic.RogueMap;

import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Room 
{
    private Rectangle room;
    private String id;
    private List<Corridor> connections;
    
    public Room(Point p, int w, int h, String id)
    {
        room=new Rectangle(p,new Dimension(w,h));
        connections = new ArrayList<>();
    }
    
    public void addCorridor(Corridor c)
    {
        connections.add(c);
    }
    
    public String getID()
    {
        return id;
    }
    
    public int getWidth()
    {
        return (int)room.getWidth();
    }
    
    public int getHeight()
    {
        return (int)room.getHeight();
    }
    
    public int getX()
    {
        return (int)room.getX();
    }
    
    public int getY()
    {
        return (int)room.getY();
    }
    
    public boolean isValid(Point p)
    {
        if(p.getX()>=room.getX() && p.getX()<=room.getX()+room.getWidth()&&
           p.getY()>=room.getY() && p.getY()<=room.getY()+room.getHeight())
            return true;
        for(Corridor c : connections)
        {
            if(c.isValid(p))
                return true;
        }
        return false;
    }
}
