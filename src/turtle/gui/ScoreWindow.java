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
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import turtle.Kernel;
import turtle.entity.Game;

/**
 * Fen�tre ou les scores sont affich�s
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class ScoreWindow extends AbstractWindow
{
    /**
     * Le label o� est affich� le score
     */
    protected JLabel mScoreLabel;

    /**
     * Le label o� est affich� le temps restant
     */
    protected JLabel mTimeLabel;

    public ScoreWindow(Kernel kernel, Game game)
    {
        super(kernel, game);

        initialize();

        // Window informations
        setTitle("Score / Turtle Game - Version " + Kernel.VERSION);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(170, 120);
        setResizable(false);
    }

    /**
     * Cr�ation de la fen�tre et de ses composants
     */
    protected void initialize()
    {
        JPanel score = new JPanel();
        mScoreLabel  = new JLabel("0 - 0");

        Font font = mScoreLabel.getFont();
        mScoreLabel.setFont(new Font(font.getFontName(), font.getStyle(), 40));

        score.add(mScoreLabel);
        getContentPane().add(score, BorderLayout.CENTER);

        JPanel time = new JPanel();
        mTimeLabel  = new JLabel("90:00");

        font = mTimeLabel.getFont();
        mTimeLabel.setFont(new Font(font.getFontName(), font.getStyle(), 15));

        time.add(mTimeLabel);
        getContentPane().add(time, BorderLayout.SOUTH);
    }

    @Override
    public void updateView(Object arg)
    {
    }
}