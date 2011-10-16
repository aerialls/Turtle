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
import turtle.controller.Kernel;
import turtle.entity.Game;

/**
 * Permet d'instancier plus facilement l'ensemble des fenêtres
 * du jeu de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class WindowManager
{
    protected ArrayList<AbstractWindow> mWindows;
    protected Game mGame;

    public WindowManager(Kernel kernel, Game game)
    {
        mGame = game;

        //TODO: Make a better system, it sucks
        mWindows = new ArrayList<AbstractWindow>();

        AbstractWindow main = new GameWindow(kernel, game, null);

        mWindows.add(main);
        mWindows.add(new ScoreWindow(kernel, game, main));
        mWindows.add(new InformationWindow(kernel, game, main));
    }

    public void link()
    {
        for (AbstractWindow window : mWindows) {
            mGame.addObserver(window);
        }
    }
}
