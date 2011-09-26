/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle.gui.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
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
    protected static float mBallDiameter = 15.0f;

    public static void paint(Ball ball, Graphics2D g)
    {
        Point2D position = ball.getPosition();
        Shape circle = new Ellipse2D.Float((float) (position.getX() - mBallDiameter / 2), (float) (position.getY() - mBallDiameter / 2), mBallDiameter, mBallDiameter);

        g.setColor(Color.WHITE);
        g.fill(circle);
    }
}
