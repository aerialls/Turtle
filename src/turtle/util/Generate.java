/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.util;

import java.awt.geom.Rectangle2D;

/**
 * Génération de formes géométrique simplifiés
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Generate
{
    /**
     * Création d'un carré centré sur le point (x,y) de longueur {length}
     *
     * @param x      Le centre sur l'axe des x
     * @param y      Le centre sur l'axe des y
     * @param length La longueur du carré
     *
     * @return Une instance de Rectangle2D
     */
    public static Rectangle2D squareCenteredOn(double x, double y, double length)
    {
        return new Rectangle2D.Double(x - length / 2.0, y - length / 2.0, length, length);
    }
}
