/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import turtle.entity.Turtle;
import turtle.util.Vector2D;

/**
 * Interface pour l'ensemble des comportements d'un joueur
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public interface TurtleBehaviorInterface
{
    public void setTurtle(Turtle turtle);

    public Vector2D getNextSpeedVector(long elapsedTime);

    public String getName();
}
