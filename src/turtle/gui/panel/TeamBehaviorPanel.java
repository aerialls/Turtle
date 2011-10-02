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
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import turtle.entity.Team;

/**
 * Représentation du panel permettant le changement du
 * comportement d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamBehaviorPanel extends JPanel
{
    protected Team mTeam;

    public TeamBehaviorPanel(Team team)
    {
        mTeam = team;

        initialize();
    }

    /**
     * Création de la fenêtre et de ses composants
     */
    private void initialize()
    {
        Border paddingBorder = BorderFactory.createEmptyBorder(0,10,10,0);

        JLabel label = new JLabel("Comportement de l'équipe " + mTeam.getName());
        label.setBorder(paddingBorder);

        JComboBox comboBox = new JComboBox();

        setLayout(new BorderLayout());

        add(label, BorderLayout.NORTH);
        add(comboBox, BorderLayout.SOUTH);
    }
}
