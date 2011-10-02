/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.awt.BorderLayout;
import turtle.gui.panel.BehaviorPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import turtle.controller.Kernel;
import turtle.entity.Game;

/**
 * Fenêtre permettant la modification des variables du jeu
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class InformationWindow extends AbstractWindow implements MouseListener
{
    protected JButton mStateButton;
    protected BehaviorPanel mBehaviorPanel;

    public InformationWindow(Kernel kernel, Game game, AbstractWindow parent)
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
        setLayout(new BorderLayout());

        mStateButton = new JButton("Démarrer");
        mStateButton.addMouseListener(this);

        mBehaviorPanel = new BehaviorPanel(mGame);

        add(mStateButton, BorderLayout.WEST);
        add(mBehaviorPanel, BorderLayout.EAST);

        setTitle("Informations");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(290, 165);
        setResizable(false);

        // Change the location of the window
        if (mParent != null) {
            Point location = mParent.getLocation();
            Dimension size = mParent.getSize();

            int x = (int) (location.getX() + size.getWidth() + 20);
            int y = (int) (location.getY() + (size.getHeight() / 2) - (getHeight() / 2));

            setLocation(x, y);
        } else {
            setLocationRelativeTo(null);
        }
    }

    @Override
    public void updateView(Object arg)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() == mStateButton) {
            mKernel.start();
            mStateButton.setEnabled(false);
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