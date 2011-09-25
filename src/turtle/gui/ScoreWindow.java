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
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import turtle.Kernel;
import turtle.entity.Game;

/**
 * Fenêtre ou les scores sont affichés
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class ScoreWindow extends AbstractWindow
{
    /**
     * Le label où est affiché le score
     */
    protected JLabel mScoreLabel;

    /**
     * Le label où est affiché le temps restant
     */
    protected JLabel mTimeLabel;

    public ScoreWindow(Kernel kernel, Game game, AbstractWindow parent)
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
        JPanel score = new JPanel();
        mScoreLabel  = new JLabel("0 - 0");

        Font font = mScoreLabel.getFont();
        mScoreLabel.setFont(new Font(font.getFontName(), font.getStyle(), 40));

        score.add(mScoreLabel);
        getContentPane().add(score, BorderLayout.CENTER);

        JPanel time = new JPanel();
        mTimeLabel  = new JLabel(getRemainingString(mGame.getMaxTime()));

        font = mTimeLabel.getFont();
        mTimeLabel.setFont(new Font(font.getFontName(), font.getStyle(), 15));

        time.add(mTimeLabel);
        getContentPane().add(time, BorderLayout.SOUTH);

        // Window informations
        setTitle("Score");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(170, 120);
        setResizable(false);

        if (mParent != null) {
            Point location = mParent.getLocation();
            Dimension size = mParent.getSize();

            int x = (int) (location.getX() + (size.getWidth() / 2) - (getWidth() / 2));
            int y = (int) (location.getY() + size.getHeight() + 20);

            setLocation(x, y);
        } else {
            setLocationRelativeTo(null);
        }
    }

    @Override
    public void updateView(Object arg)
    {
        mTimeLabel.setText(getRemainingString(mGame.getRemainingTime()));
    }

    private String getRemainingString(long remainingTime)
    {
        remainingTime /= 1000;

        int minutes  = (int) (remainingTime / 60);
        int secondes = (int) (remainingTime % 60);

        return String.format("%02d:%02d", minutes, secondes);
    }
}