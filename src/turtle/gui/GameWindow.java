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
    protected BufferStrategy mBufferStrategy;

    protected Graphics mBuffer;

    public GameWindow(Kernel kernel, Game game, AbstractWindow parent)
    {
        super(kernel, game, parent);

        initialize();

        setVisible(true);

        setIgnoreRepaint(true);
        createBufferStrategy(2);

        mBufferStrategy = getBufferStrategy();
        mBuffer = mBufferStrategy.getDrawGraphics();
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

    public void render()
    {
        Field field = mGame.getField();

        FieldView.paint(field, mBuffer);

        if (mGame.isLaunched()) {
            BallView.paint(field.getBall(), mBuffer);
        }

        mBufferStrategy.show();
    }

    @Override
    public void updateView(Object arg)
    {
        render();
    }
}
