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
import turtle.gui.WindowManager;

/**
 * Point de départ du programme
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TurtleGame
{
    public static void main(String[] args)
    {
        Game game = new Game();
        Kernel kernel = new Kernel(game);
        WindowManager manager = new WindowManager(kernel, game);

        manager.link();
    }
}
