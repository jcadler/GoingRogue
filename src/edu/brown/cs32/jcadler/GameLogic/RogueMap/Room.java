package edu.brown.cs32.jcadler.GameLogic.RogueMap;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

import edu.brown.cs32.goingrogue.map.Space;
import edu.brown.cs32.goingrogue.map.Tile;
import edu.brown.cs32.goingrogue.map.Wall;
import edu.brown.cs32.goingrogue.util.IndexPair;

/**
 *
 * @author john
 */
public class Room implements Space
{
    private Rectangle2D.Double room;
    private String id;
    private List<Corridor> connections;
    private boolean exitRoom;
    
    public Room(Point p, int w, int h, String i, boolean exit)
    {
        room=new Rectangle2D.Double(p.getX(),p.getY(),w,h);
        connections = new ArrayList<>();
        id=i;
        exitRoom=exit;
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
    
    public int width()
    {
        return getWidth();
    }
    
    public int height()
    {
        return getHeight();
    }
    
    public Point upperLeft()
    {
        return new Point((int)room.getX(),(int)room.getY());
    }
    
    public Tile[][] getFloor()
    {
        int x = (int)room.getWidth();
        int y = (int)room.getHeight();
        Tile[][] ret = new Tile[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(exitRoom && i==(int)(x/2) && j==(int)(y/2))
                    ret[i][j]=Tile.WATER;
                else
                    ret[i][j]=Tile.GROUND;
            }
        }
        return ret;
    }
    
    public Wall getWallType()
    {
        return Wall.DEFAULT;
    }
    
    public int getX()
    {
        return (int)room.getX();
    }
    
    public int getY()
    {
        return (int)room.getY();
    }
    
    public boolean isValid(Point2D.Double p)
    {
        if(room.contains(p))
            return true;
        for(Corridor c : connections)
        {
            if(c.isValid(p))
                return true;
        }
        return false;
    }
    
    public List<Corridor> getCorridors()
    {
        return connections;
    }
    
    public boolean exitRoom()
    {
        return exitRoom;
    }
    
    public void setExit()
    {
        exitRoom=true;
    }
    
    public boolean atExit(Point2D p)
    {
        Rectangle rect = new Rectangle((int)(room.getX()+(int)(room.getWidth()/2)),
                                       (int)(room.getY()+(int)(room.getHeight()/2)),
                                       1,1);
        return exitRoom && rect.contains(p);
    }
}
