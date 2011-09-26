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

        double innerWidth  = width - 2 * delta;
        double innerHeight = height - 2 * delta;

        g.drawRect((int) delta, (int) delta, (int) innerWidth, (int) innerHeight);
        g.drawLine((int) (width / 2), (int) delta, (int) (width / 2), (int) (height - delta));

        // Goal A
        Line2D line = field.getGoalA().getLine();

        g.drawRect((int) (0.4 * delta), (int) line.getY1(), (int) (0.6 * delta), (int) (line.getY2() - line.getY1()));

        // Goal B
        line = field.getGoalB().getLine();

        g.drawRect((int) (delta + innerWidth), (int) line.getY1(), (int) (0.6 * delta), (int) (line.getY2() - line.getY1()));
    }
}
