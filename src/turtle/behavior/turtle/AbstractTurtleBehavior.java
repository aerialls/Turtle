package turtle.behavior.turtle;

import turtle.entity.Game;

abstract public class AbstractTurtleBehavior implements TurtleBehaviorInterface
{
    protected Game mGame;

    public AbstractTurtleBehavior(Game game)
    {
        mGame = game;
    }
}
