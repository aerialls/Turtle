/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.util;

import java.awt.geom.Ellipse2D;

/**
 * Représentation d'un cercle
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Circle2D extends Ellipse2D.Double
{
    /**
     * Création d'un cercle
     *
     * @param x      Le centre sur l'axe des x
     * @param y      Le centre sur l'axe des y
     * @param radius Le rayon du cercle
     */
    public Circle2D(double x, double y, double radius)
    {
        super(x - radius, y - radius, 2.0 * radius, 2.0 * radius);
    }
}
