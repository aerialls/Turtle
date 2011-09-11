package turtle.behavior.turtle;

import turtle.entity.Game;

public class Attacker extends AbstractTurtleBehavior
{
    public Attacker(Game game)
    {
        super(game);
    }

    @Override
    public float getSpeed()
    {
        return 5.0f;
    }
}
