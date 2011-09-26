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
import java.awt.Graphics2D;

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
    public static void paint(Field field, Graphics2D g)
    {
        // Green
        g.setColor(new Color(31, 160, 31));

        // Background
        g.fillRect(0, 0, (int) field.getDimension().getWidth(), (int) field.getDimension().getHeight());

        // White
        g.setColor(Color.WHITE);

        double delta  = field.getGoalA().getLine().getX1();
        double width  = field.getDimension().getWidth();
        double height = field.getDimension().getHeight();

        g.drawRect((int) delta, (int) delta, (int) (width - 2 * delta), (int) (height - 2 * delta));
        g.drawLine((int) (width / 2), (int) delta, (int) (width / 2), (int) (height - delta));

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
    private static void paintGoal(Graphics2D g, Goal goal)
    {
        //g.drawRect((int) (0.5 * delta), (int) line.getY1(), (int) (0.5 * delta), (int) (line.getY2() - line.getY1()));
        //g.draw(goal.getLine());
    }
}
