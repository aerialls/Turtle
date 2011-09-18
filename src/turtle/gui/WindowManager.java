/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.util.ArrayList;

import turtle.Kernel;
import turtle.entity.Game;

public class WindowManager
{
    protected ArrayList<AbstractWindow> mWindows;
    protected Game mGame;

    public WindowManager(Kernel kernel, Game game)
    {
        mGame = game;

        //TODO: Make a better system, it sucks
        mWindows = new ArrayList<AbstractWindow>();

        mWindows.add(new InformationWindow(kernel, game));
        mWindows.add(new ScoreWindow(kernel, game));
        mWindows.add(new GameWindow(kernel, game));
    }

    public void link()
    {
        for (AbstractWindow window : mWindows) {
            mGame.addObserver(window);
        }
    }

    public void display()
    {
        for (AbstractWindow window : mWindows) {
            window.display();
        }
    }
}
