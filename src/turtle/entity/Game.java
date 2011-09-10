package turtle.entity;

import java.awt.Color;
import java.util.Observable;

public class Game extends Observable
{
    protected Team mTeamA;
    protected Team mTeamB;

    public Game()
    {
        mTeamA = new Team(Color.RED);
        mTeamB = new Team(Color.BLUE);
    }
}
