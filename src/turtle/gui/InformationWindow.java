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

public class InformationWindow extends AbstractWindow
{
    public InformationWindow(Kernel kernel)
    {
        super(kernel);

        // Window informations
        setTitle("Informations / Turtle Game - Version " + Kernel.VERSION);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setResizable(false);
    }

    @Override
    public void updateGame(Object arg)
    {
    }
}