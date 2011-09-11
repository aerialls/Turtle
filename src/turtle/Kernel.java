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

public class Kernel
{
    public static final String VERSION = "1.0 PR1";

    protected Game mGame;

    public Kernel(Game game)
    {
        mGame = game;
    }
}
