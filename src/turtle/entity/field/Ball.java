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

/**
 * Représentation d'un ballon de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Ball
{
    /**
     * La position du ballon
     */
    protected Point2D mPosition;

    /**
     * Construction du ballon
     *
     * @param position La position sur le terrain
     */
    public Ball(Point2D position)
    {
        mPosition = position;
    }

    /**
     * Construction du ballon
     *
     * @param x La position sur l'axe des x
     * @param y La position sur l'axe des y
     */
    public Ball(double x, double y)
    {
        this(new Point2D.Double(x, y));
    }

    /**
     * Construction du ballon
     *
     * Le ballon sera positionné à la position (0,0)
     */
    public Ball()
    {
        this(0, 0);
    }

    /**
     * Change la position du ballon
     *
     * @param position La nouvelle position du ballon
     */
    public void setPosition(Point2D position)
    {
        mPosition = position;
    }

    /**
     * Retourne la position du ballon
     */
    public Point2D getPosition()
    {
        return mPosition;
    }
}
