/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui.view;

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
public class FieldView implements ViewInterface
{
    public static void paint(Field field, Graphics g)
    {
        // Green
        g.setColor(new Color(31, 160, 31));

        // Background
        g.fillRect(0, 0, (int) field.getDimension().getWidth(), (int) field.getDimension().getHeight());

        // White
        g.setColor(Color.WHITE);

        double delta = field.getGoalA().getLine().getX1();
        g.drawRect((int) delta, (int) delta, (int) (field.getDimension().getWidth() - 2 * delta), (int) (field.getDimension().getHeight() - 2 * delta));

        // Goals
        paintGoal(g, field.getGoalA());
        paintGoal(g, field.getGoalB());
    }

    /**
     * Dessine un but sur le terrain
     *
     * @param g    L'object Graphics
     * @param goal Le but a dessiner
     */
    private static void paintGoal(Graphics g, Goal goal)
    {
        Line2D line = goal.getLine();

        g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());
    }
}
