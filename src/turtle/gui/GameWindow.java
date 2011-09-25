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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import turtle.Kernel;
import turtle.entity.Game;
import turtle.entity.field.Field;
import turtle.gui.view.BallView;
import turtle.gui.view.FieldView;

/**
 * Fenêtre principale (ou se déroule le jeu de foot)
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class GameWindow extends AbstractWindow
{
    protected Graphics mBuffer;

    protected Image mImage;

    public GameWindow(Kernel kernel, Game game, AbstractWindow parent)
    {
        super(kernel, game, parent);

        initialize();

        setVisible(true);
    }

    /**
     * Création de la fenêtre et de ses composants
     */
    private void initialize()
    {
        setTitle("Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(mGame.getField().getDimension());
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void paint(Graphics g)
    {
        Field field = mGame.getField();

        // Double buffering software
        if (mBuffer == null) {
            mImage = createImage((int) field.getDimension().getWidth(), (int) field.getDimension().getHeight());
            mBuffer = mImage.getGraphics();

            // Anti aliasing
            ((Graphics2D) mBuffer).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }

        FieldView.paint(field, mBuffer);

        if (mGame.isLaunched()) {
            BallView.paint(field.getBall(), mBuffer);
        }

        g.drawImage(mImage, 0, 0, this);
    }

    @Override
    public void updateView(Object arg)
    {
        repaint();
    }
}
