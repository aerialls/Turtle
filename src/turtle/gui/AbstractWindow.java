package turtle.gui;

import java.util.Observer;

import javax.swing.JFrame;

import turtle.entity.Game;

abstract public class AbstractWindow extends JFrame implements Observer
{
    protected Game mGame;

    public AbstractWindow(Game game)
    {
        mGame = game;
    }
}
