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
    /**
     * Création d'un nombre aléatoire entre deux bornes
     *
     * @param a La borne inférieure
     * @param b La borne supérieure
     *
     * @return Un nombre aléatoire
     */
    public static double between(double a, double b)
    {
        return a + Math.random() * (b - a);
    }

    /**
     * Création d'un nombre aléatoire entre deux angles en degrés
     * La méthode s'occupe de la conversion en radian
     *
     * @param a L'angle inférieur
     * @param b L'angle supérieur
     *
     * @return Le nombre aléatoire en radian
     *
     * @see Random#between(double, double)
     */
    public static double degreesToRadians(double a, double b)
    {
        a = Math.toRadians(a);
        b = Math.toRadians(b);

        return between(a, b);
    }
}
