package turtle.behavior.turtle;

import turtle.entity.Game;

public class Defender extends AbstractTurtleBehavior
{
    public Defender(Game game)
    {
        super(game);
    }

    @Override
    public float getSpeed()
    {
        return 1.0f;
    }
}
