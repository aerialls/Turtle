/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

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
}
