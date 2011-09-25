/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import turtle.gui.view.ViewInterface;

import java.awt.Graphics;
import javax.swing.JFrame;

import turtle.Kernel;
import turtle.entity.Game;
import turtle.gui.view.FieldView;

/**
 * Fenêtre principale (ou se déroule le jeu de foot)
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class GameWindow extends AbstractWindow
{
    protected ViewInterface mFieldView;

    public GameWindow(Kernel kernel, Game game, AbstractWindow parent)
    {
        super(kernel, game, parent);

        initialize();
    }

    /**
     * Création de la fenêtre et de ses composants
     */
    private void initialize()
    {
        mFieldView = new FieldView(mGame.getField());

        // Window informations
        setTitle("Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(mGame.getField().getDimension());
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void paint(Graphics g)
    {
        mFieldView.paint(g);
    }

    @Override
    public void updateView(Object arg)
    {
    }
}
