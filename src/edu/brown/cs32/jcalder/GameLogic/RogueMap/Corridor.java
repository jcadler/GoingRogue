package edu.brown.cs32.jcalder.GameLogic.RogueMap;

import java.awt.Point;

/**
 *
 * @author john
 */
public class Corridor 
{
    private Room start;
    private Room end;
    private int direction;
    private int width;
    private int position1;
    private int position2;
    
    public Corridor(Room s, Room e, int d, int w, int p1, int p2)
    {
        start = s;
        end = e;
        direction = d;
        width = w;
        position1 = p1;
        position2 = p2;
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
    
    public boolean isValid(Point p)
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
}
