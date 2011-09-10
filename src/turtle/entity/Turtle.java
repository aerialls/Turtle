package turtle.entity;

import java.awt.Point;

public class Turtle
{
    protected Point mPosition;

    public Turtle()
    {
        this(new Point(0, 0));
    }

    public Turtle(Point position)
    {
        if (position == null) {
            throw new IllegalArgumentException("You need to enter a correct position");
        }

        mPosition = position;
    }
}