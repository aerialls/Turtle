/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import java.awt.geom.Point2D;
import turtle.entity.field.Ball;
import turtle.entity.field.Field;
import turtle.entity.field.Goal;
import turtle.util.Random;
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
    public void apply(Vector2D vector, long elapsedTime)
    {
        Ball ball = mField.getBall();

        Point2D turtlePosition = mTurtle.getPosition();
        Point2D ballPosition = ball.getPosition();

        // The ball is near the player
        if (mTurtle.isAround(ball)) {
            Goal goal = mTurtle.getTeam().getGoal();
            return;
        }

        vector.set(ballPosition.getX() - turtlePosition.getX(), ballPosition.getY() - turtlePosition.getY());
        vector.setLength(Random.between(0.05, 0.08));
    }
}
