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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import turtle.behavior.team.TeamBehaviorInterface;
import turtle.controller.Kernel;
import turtle.entity.Team;
import turtle.util.Log;

/**
 * Représentation du panel permettant le changement du
 * comportement d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamBehaviorPanel extends JPanel implements ActionListener
{
    /**
     * L'équipe concernée
     */
    protected Team mTeam;

    /**
     * Le contrôlleur
     */
    protected Kernel mKernel;

    public TeamBehaviorPanel(Kernel kernel, Team team)
    {
        mTeam = team;
        mKernel = kernel;

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

        JComboBox comboBox = new JComboBox(mTeam.getAvailableBehaviors().toArray());

        comboBox.addActionListener(this);
        comboBox.setSelectedIndex(-1);

        setLayout(new BorderLayout());

        add(label, BorderLayout.NORTH);
        add(comboBox, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JComboBox cb = (JComboBox) e.getSource();

        TeamBehaviorInterface behavior = (TeamBehaviorInterface) cb.getSelectedItem();
        TeamBehaviorInterface oldBehavior = mTeam.getBehavior();

        if (behavior != oldBehavior) {
            Log.i(String.format("Behavior change for Team %s (old=%s, new=%s)", mTeam.getName(), mTeam.getBehavior(), behavior));

            mKernel.changeTeamBehavior(mTeam, behavior);
        }
    }
}
