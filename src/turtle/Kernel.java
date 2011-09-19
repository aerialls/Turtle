/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle;

import turtle.entity.Game;

/**
 * Contrôleur principal
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Kernel
{
    /**
     * Version du programme
     */
    public static final String VERSION = "1.0-PROTOTYPE";

    /**
     * Si le programme est en mode débug ou non
     */
    public static final boolean DEBUG = true;

    protected Game mGame;

    public Kernel(Game game)
    {
        mGame = game;
    }
}
