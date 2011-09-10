package turtle.gui;

import java.util.Observable;

import turtle.entity.Game;

public class GameWindow extends AbstractWindow
{
    public GameWindow(Game game)
    {
        super(game);
    }

    @Override
    public void update(Observable o, Object arg)
    {
    }
}
