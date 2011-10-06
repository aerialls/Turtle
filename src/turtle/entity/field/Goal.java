/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity.field;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Représentation d'un but
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Goal
{
    /**
     * La position du but
     */
    protected Rectangle2D mRectangle;

    /**
     * Création d'un but d'une équipe
     *
     * @param position La position du but
     * @param width    La largeur du but
     * @param height   La hauteur du but
     */
    public Goal(Point2D position, double width, double height)
    {
        mRectangle = new Rectangle2D.Double(position.getX(), position.getY(), width, height);
    }

    /**
     * Retourne le rectangle modélisant le but
     */
    public Rectangle2D getRectangle()
    {
        return mRectangle;
    }

    /**
     * Regarde si le ballon est dans le but
     *
     * @param ball Le ballon à tester
     *
     * @return Vrai si le rectangle de but contient la position
     * du ballon
     */
    public boolean contains(Ball ball)
    {
        return mRectangle.contains(ball.getPosition());
    }
}
