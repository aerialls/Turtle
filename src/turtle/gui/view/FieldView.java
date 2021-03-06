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
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import turtle.entity.field.Field;

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

        double delta  = field.getGoalA().getRectangle().getMaxX();

        double width  = field.getDimension().getWidth();
        double height = field.getDimension().getHeight();

        double innerWidth  = width - 2 * delta;
        double innerHeight = height - 2 * delta;

        g.drawRect((int) delta, (int) delta, (int) innerWidth, (int) innerHeight);
        g.drawLine((int) (width / 2), (int) delta, (int) (width / 2), (int) (height - delta));

        // Circle in the center
        double circleDiameter = 0.3 * width;
        Shape circle = new Ellipse2D.Double((double) (width / 2 - circleDiameter / 2), (double) (height / 2 - circleDiameter / 2), (double) circleDiameter, (double) circleDiameter);

        g.draw(circle);

        g.draw(field.getGoalA().getRectangle());
        g.draw(field.getGoalB().getRectangle());
    }
}
