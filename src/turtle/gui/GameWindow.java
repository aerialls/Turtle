/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import javax.swing.JFrame;

import turtle.Kernel;

public class GameWindow extends AbstractWindow
{
    public GameWindow(Kernel kernel)
    {
        super(kernel);

        // Window informations
        setTitle("Game / Turtle Game - Version " + Kernel.VERSION);

        //TODO: We need to define a callback here for closing all the windows at the same time
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void updateGame(Object arg)
    {
    }
}
