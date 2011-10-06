/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui.panel;

import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import turtle.controller.Kernel;
import turtle.entity.Game;

/**
 * Représentation du panel permettant le changement du
 * comportement des équipes
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class BehaviorPanel extends JPanel
{
    /**
     * Le jeu
     */
    protected Game mGame;

    /**
     * Le contrôlleur
     */
    protected Kernel mKernel;

    public BehaviorPanel(Kernel kernel, Game game)
    {
        mGame = game;
        mKernel = kernel;

        initialize();
    }

    /**
     * Création de la fenêtre et de ses composants
     */
    private void initialize()
    {
        setLayout(new BorderLayout());

        add(new TeamBehaviorPanel(mKernel, mGame.getTeamA()), BorderLayout.NORTH);
        add(new TeamBehaviorPanel(mKernel, mGame.getTeamB()), BorderLayout.SOUTH);
    }

    @Override
    public Insets getInsets()
    {
        return new Insets(10,10,10,10);
    }
}
