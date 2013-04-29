package edu.brown.cs32.jcadler.GameLogic.RogueMap;

import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Rectangle;

import edu.brown.cs32.goingrogue.map.Space;
import edu.brown.cs32.goingrogue.map.Tile;
import edu.brown.cs32.goingrogue.map.Wall;

/**
 *
 * @author john
 */
public class Corridor implements Space
{
    private Room start;
    private Room end;
    private int direction;
    private int width;
    private int position1;
    private int position2;
    private Rectangle rect;
    
    public Corridor(Room s, Room e, int d, int w, int p1, int p2)
    {
        start = s;
        end = e;
        direction = d;
        width = w;
        position1 = p1;
        position2 = p2;
        Point p = getTopLeft();
        int wdth=0;
        int hght=0;
        switch(direction)
        {
            case 0:
                wdth=width;
                hght=(int)(p.getY()-start.getY());
                break;
            case 1:
                wdth=(int)(p.getX()-end.getX());
                hght=width;
            case 2:
                wdth=width;
                hght=(int)(p.getY()-end.getY());
            case 3:
                wdth=(int)(p.getX()-start.getX());
                hght=width;
        }
        rect=new Rectangle(p.x,p.y,wdth,hght);
    }
    
    public Room getStart()
    {
        return start;
    }
    
    public Room getEnd()
    {
        return end;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public boolean isValid(Point2D.Double p)
    {
        switch(direction)
        {
            case 0:
                return p.getY()>=start.getY() && 
                       p.getX()>=start.getX()+position1 &&
                       p.getX()<=start.getX()+position1+width &&
                       p.getY()<=end.getY()+end.getHeight();
            case 1:
                return p.getX()>=start.getX()+start.getWidth() &&
                       p.getY()>=start.getY()+position1 &&
                       p.getY()<=start.getY()+position1+width &&
                       p.getX()<=end.getX();
            case 2:
                return p.getY()>=start.getY()+start.getHeight() &&
                       p.getX()>=start.getX()+position1 &&
                       p.getX()<=start.getX()+position1+width &&
                       p.getY()<=end.getY();
            case 3:
                return p.getX()<=start.getX() &&
                       p.getY()<=start.getY()+position1 &&
                       p.getY()>=start.getY()+position1+width &&
                       p.getX()>=end.getX()+end.getWidth();
        }
        throw new IllegalArgumentException("Direction does not have the right value");
    }
    
    public Corridor flipped()
    {
        return new Corridor(end,start,(direction+2)%4,width,position2,position1);
    }
    
    public int width()
    {
        return rect.width;
    }
    
    public int height()
    {
        return rect.height;
    }
    
    public Point upperLeft()
    {
        return new Point(rect.x,rect.y);
    }
    
    public Tile[][] getFloor()
    {
        Tile[][] ret = new Tile[rect.width][rect.height];
        for(int i=0;i<rect.width;i++)
        {
            for(int j=0;j<rect.height;j++)
                ret[i][j]=Tile.GROUND;
        }
        return ret;
    }
    
    public Wall getWallType()
    {
        return Wall.DEFAULT;
    }
    
    private Point getTopLeft()
    {
        int x=0;
        int y=0;
        switch(direction)
        {
            case 0:
                x=end.getX()+position2;
                y=end.getY()+end.getHeight();
                break;
            case 1:
                x=start.getX()+start.getWidth();
                y=start.getY()+position1;
                break;
            case 2:
                x=start.getX()+position1;
                y=start.getY()+start.getHeight();
                break;
            case 3:
                x=end.getX()+end.getWidth();
                y=end.getY()+position2;
                break;
        }
        return new Point(x,y);
    }
    
    public Rectangle getRectangle()
    {
        return rect;
    }
}
