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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import turtle.controller.Kernel;
import turtle.entity.Game;
import turtle.entity.Team;
import turtle.entity.Turtle;

/**
 * Fenêtre ou les scores sont affichés
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class ScoreWindow extends AbstractWindow
{
    /**
     * Le label où est affiché le score de l'équipe A
     */
    protected JLabel mScoreTeamALabel;

    /**
     * Le label où est affiché le score de l'équipe B
     */
    protected JLabel mScoreTeamBLabel;

    /**
     * Le label où est affiché le temps restant
     */
    protected JLabel mTimeLabel;

    /**
     * Le label où est affiché le dernier tireur du ballon
     */
    protected JLabel mLastShooterLabel;

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
        // Ball last shooter
        mLastShooterLabel = createJLabel("Personne", 10, null);

        JPanel shooter = new JPanel();
        JLabel title = createJLabel("Dernier tireur : ", 10, null);

        shooter.add(title);
        shooter.add(mLastShooterLabel);

        // Score
        mScoreTeamALabel  = createJLabel("0", 40, mGame.getTeamA().getColor());
        mScoreTeamBLabel  = createJLabel("0", 40, mGame.getTeamB().getColor());

        JPanel score = new JPanel();
        JLabel dash = createJLabel(" - ", 40, null);

        score.add(mScoreTeamALabel);
        score.add(dash);
        score.add(mScoreTeamBLabel);

        // Time
        JPanel time = new JPanel();
        mTimeLabel  = createJLabel(getRemainingString(mGame.getMaxTime()), 15, null);

        time.add(mTimeLabel);

        add(shooter, BorderLayout.NORTH);
        add(score, BorderLayout.CENTER);
        add(time, BorderLayout.SOUTH);

        // Window informations
        setTitle("Score");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(170, 140);
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
        // Last shooter
        updateLastShooter();

        // Score
        mScoreTeamALabel.setText(String.valueOf(mGame.getTeamA().getScore()));
        mScoreTeamBLabel.setText(String.valueOf(mGame.getTeamB().getScore()));

        // Remaining time
        mTimeLabel.setText(getRemainingString(mGame.getRemainingTime()));
    }

    private void updateLastShooter()
    {
        Object object = mGame.getBall().getLastShooter();

        if (object != null && object instanceof Turtle) {
            Team team = ((Turtle) object).getTeam();

            mLastShooterLabel.setText(String.format("Equipe %s", team.getName()));
        } else {
            mLastShooterLabel.setText("Personne");
        }
    }

    private String getRemainingString(long remainingTime)
    {
        remainingTime /= 1000;

        int minutes  = (int) (remainingTime / 60);
        int secondes = (int) (remainingTime % 60);

        return String.format("%02d:%02d", minutes, secondes);
    }

    private JLabel createJLabel(String text, int size, Color color)
    {
        JLabel label = new JLabel(text);
        Font font = label.getFont();

        label.setFont(new Font(font.getFontName(), font.getStyle(), size));

        if (color != null) {
            label.setForeground(color);
        }

        return label;
    }
}