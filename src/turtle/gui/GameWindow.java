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
        setSize(mGame.getFieldDimension());

        mFieldPannel = new FieldPannel(mGame);

        getContentPane().add(mFieldPannel);
    }

    @Override
    public void updateGame(Object arg)
    {
    }
}
