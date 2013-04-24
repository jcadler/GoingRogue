package edu.brown.cs32.bweedon.gameobjects.creatures;

import java.awt.geom.Point2D;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class MoveAction extends Action {

    private double _direction; // angle of motion in radians, with East being 0 rad
    private Creature _sourceCreature;

    public MoveAction(double direction, Creature creature) {
        super(0, new MoveRange(creature));
        _direction = direction;
        _sourceCreature = creature;
    }

    @Override
    public void act(Creature creature) {
        double xTranslation = creature.getPxPerMove() * cos(_direction);
        double yTranslation = creature.getPxPerMove() * sin(_direction);
        Point2D origPos = creature.getPosition();
        creature.setPosition(new Point2D.Double(origPos.getX() + xTranslation, origPos.getY() + yTranslation));
    }
}