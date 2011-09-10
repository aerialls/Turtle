package turtle.entity;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class Team
{
    protected Set<Turtle> mPlayers;
    protected Color mColor;

    public Team(Color color)
    {
        mColor = color;
        mPlayers = new HashSet<Turtle>();
    }

    public Set<Turtle> getPlayers()
    {
        return mPlayers;
    }

    public Color getColor()
    {
        return mColor;
    }
}
