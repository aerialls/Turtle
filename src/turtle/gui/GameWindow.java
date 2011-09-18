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
 * Fenêtre principale (ou se déroule le jeu de foot)
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class GameWindow extends AbstractWindow
{
    protected FieldPannel mFieldPannel;

    public GameWindow(Kernel kernel, Game game)
    {
        super(kernel, game);

        initialize();

        // Window informations
        setTitle("Game / Turtle Game - Version " + Kernel.VERSION);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    protected void initialize()
    {
        setSize(mGame.getField().getDimension());

        mFieldPannel = new FieldPannel(mGame.getField());

        getContentPane().add(mFieldPannel);
    }

    @Override
    public void updateView(Object arg)
    {
    }
}
