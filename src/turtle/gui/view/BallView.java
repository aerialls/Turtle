/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import turtle.entity.field.Ball;

/**
 * Représentation graphique d'un ballon
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class BallView implements ViewInterface
{
    public static void paint(Ball ball, Graphics g)
    {
        Point2D position = ball.getPosition();

        // Grey
        g.setColor(new Color(219, 219, 219));

        g.fillOval((int) position.getX(), (int) position.getY(), 15, 15);
    }
}
