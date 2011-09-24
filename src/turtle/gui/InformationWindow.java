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
import turtle.entity.Game;

/**
 * Fen�tre permettant la modification des variables du jeu
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class InformationWindow extends AbstractWindow
{
    public InformationWindow(Kernel kernel, Game game)
    {
        super(kernel, game);

        initialize();

        // Window informations
        setTitle("Informations");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setResizable(false);
    }

    /**
     * Cr�ation de la fen�tre et de ses composants
     */
    protected void initialize()
    {
    }

    @Override
    public void updateView(Object arg)
    {
    }
}