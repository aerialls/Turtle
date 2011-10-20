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
import turtle.util.geom.Vector2D;

/**
 * Comportement d'un défenseur
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Defender extends AbstractTurtleBehavior
{
    public Defender(Field field)
    {
        super(field);
    }

    @Override
    public void apply(Vector2D vector, long elapsedTime)
    {
    }
}
