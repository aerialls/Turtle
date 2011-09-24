/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import turtle.Kernel;
import turtle.entity.Game;

/**
 * Fenêtre permettant la modification des variables du jeu
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class InformationWindow extends AbstractWindow implements MouseListener
{
    protected JButton mStartButton;

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
     * Création de la fenêtre et de ses composants
     */
    protected void initialize()
    {
        mStartButton = new JButton("Lancer !");

        mStartButton.addMouseListener(this);

        add(mStartButton);
    }

    @Override
    public void updateView(Object arg)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() == mStartButton) {
            mKernel.start();
            mStartButton.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}