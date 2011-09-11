/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import turtle.Kernel;
import turtle.entity.Game;

abstract public class AbstractWindow extends JFrame implements WindowInterface, Observer
{
    protected Game mGame;
    protected Kernel mKernel;

    public AbstractWindow(Kernel kernel)
    {
        mKernel = kernel;
    }

    public void display()
    {
        setVisible(true);
    }

    @Override
    public void setGame(Game game)
    {
        mGame = game;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof Game && o != null) {
            updateGame(arg);
        }
    }
}
