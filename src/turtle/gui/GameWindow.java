/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.awt.Graphics;
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
    protected FieldPanel mFieldPanel;

    public GameWindow(Kernel kernel, Game game, AbstractWindow parent)
    {
        super(kernel, game, parent);

        initialize();

        // Window informations
        setTitle("Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Création de la fenêtre et de ses composants
     */
    protected void initialize()
    {
        mFieldPanel = new FieldPanel(mGame.getField());

        setSize(mGame.getField().getDimension());
    }

    @Override
    public void paint(Graphics g)
    {
        mFieldPanel.paint(g);
    }

    @Override
    public void updateView(Object arg)
    {
    }
}
