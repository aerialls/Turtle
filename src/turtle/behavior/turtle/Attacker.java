/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import turtle.entity.field.Field;
import turtle.util.Vector2D;

/**
 * Comportement d'un attaquant
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Attacker extends AbstractTurtleBehavior
{
    public Attacker(Field field)
    {
        super(field);
    }

    @Override
    public Vector2D getNextSpeedVector(long elapsedTime)
    {
        return null;
    }
}
