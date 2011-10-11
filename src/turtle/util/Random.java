/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.util;

/**
 * Boîte à outils concernant la génération de nombre aléatoire
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Random
{
    public static double between(double a, double b)
    {
        return a + Math.random() * (b - a);
    }
}
