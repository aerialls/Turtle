/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import turtle.entity.Game;
import turtle.entity.Turtle;

/**
 * Comportement d'un d�fenseur
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Defender extends AbstractTurtleBehavior
{
    public Defender(Game game)
    {
        super(game);
    }

    @Override
    public float getSpeed()
    {
        return 1.0f;
    }
}
