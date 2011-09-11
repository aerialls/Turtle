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
    protected Kernel mKernel;

    public WindowManager(Kernel kernel)
    {
        mKernel = kernel;

        //TODO: Make a better system
        mWindows = new ArrayList<AbstractWindow>();

        mWindows.add(new InformationWindow());
        mWindows.add(new ScoreWindow());
        mWindows.add(new GameWindow());
    }

    public void link(Game game)
    {
        for (AbstractWindow window : mWindows) {
            window.setGame(game);
            // We need to link the model with the view
            game.addObserver(window);
        }
    }
}
