/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

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
