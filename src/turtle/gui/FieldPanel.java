/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import turtle.entity.field.Field;
import turtle.entity.field.Goal;

/**
 * Représentation de la vue d'un terrain de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class FieldPanel
{
    protected Field mField;

    public FieldPanel(Field field)
    {
        mField = field;
    }

    public void paint(Graphics g)
    {
        // Green
        g.setColor(new Color(31, 160, 31));

        // Background
        g.fillRect(0, 0, (int) mField.getDimension().getWidth(), (int) mField.getDimension().getHeight());

        // White
        g.setColor(Color.WHITE);

        // Goals
        paintGoal(g, mField.getGoalA());
        paintGoal(g, mField.getGoalB());
    }

    /**
     * Dessine un but sur le terrain
     *
     * @param g    L'object Graphics
     * @param goal Le but a dessiner
     */
    private void paintGoal(Graphics g, Goal goal)
    {
        Line2D line = goal.getLine();

        g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());
    }
}
