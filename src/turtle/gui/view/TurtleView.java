/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui.view;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import turtle.behavior.turtle.Attacker;
import turtle.behavior.turtle.Defender;
import turtle.behavior.turtle.TurtleBehaviorInterface;
import turtle.entity.Turtle;

/**
 * Représentation de la vue d'un joueur
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TurtleView implements ViewInterface
{
    public static void paint(Turtle turtle, Graphics2D g)
    {
        TurtleBehaviorInterface behavior = turtle.getBehavior();
        Point2D position = turtle.getPosition();

        g.setColor(turtle.getColor());

        Shape circle = new Ellipse2D.Double((double) (position.getX() - turtle.getDiameter()), (double) (position.getY() - turtle.getDiameter()), turtle.getDiameter() * 2, turtle.getDiameter() * 2);
        g.draw(circle);

        if (behavior instanceof Attacker) {
            g.drawLine((int) position.getX(), (int) (position.getY() - turtle.getDiameter()), (int) position.getX(), (int) (position.getY() + turtle.getDiameter()));
            g.drawLine((int) (position.getX() - turtle.getDiameter()), (int) position.getY(), (int) (position.getX() + turtle.getDiameter()), (int) position.getY());
        } else if (behavior instanceof Defender) {
            // Do stuff later
        }
    }
}
