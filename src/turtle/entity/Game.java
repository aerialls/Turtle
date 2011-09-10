package turtle.entity;

import java.awt.Color;

public class Game
{
    protected Team mTeamA;
    protected Team mTeamB;

    public Game()
    {
        mTeamA = new Team(Color.RED);
        mTeamB = new Team(Color.BLUE);
    }
}
