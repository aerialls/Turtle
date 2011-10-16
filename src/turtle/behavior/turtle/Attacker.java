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
import java.awt.geom.Rectangle2D;
import turtle.entity.field.Ball;
import turtle.entity.field.Field;
import turtle.entity.field.Goal;
import turtle.util.Log;
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
        Goal goal = mTurtle.getTeam().getGoal();

        Point2D turtlePosition = mTurtle.getPosition();
        Point2D ballPosition = ball.getPosition();

        // Le ballon est proche du joueur
        if (mTurtle.isAround(ball)) {
            Vector2D ballVector = new Vector2D();
            Rectangle2D rectangle = goal.getRectangle();

            // Le joueur va donc tirer le ballon du côté des buts
            // On ajoute une incertitude sur l'axe des Y pour qu'il ne
            // tire pas obligatoirement correctement dedans
            double x = rectangle.getCenterX();
            double y = rectangle.getCenterY();
            double delta = rectangle.getHeight();

            y = Random.between(y - delta, y + delta);
            ballVector.set(x - turtlePosition.getX() , y - turtlePosition.getY());
            ballVector.setLength(Random.between(0.08, 0.13));

            ball.setSpeedVector(ballVector);
        } else {
            // Vecteur en direction de la balle
            vector.set(ballPosition.getX() - turtlePosition.getX(), ballPosition.getY() - turtlePosition.getY());

            // Il faut regarder si le ballon se dirige dans la bonne direction :
            // S'il avance du bon côté, le joueur n'a pas a courrir après

            if (mField.gettingCloser(goal, ball)) {
                vector.setLength(Random.between(0.00, 0.01));
            } else {
                vector.setLength(Random.between(0.03, 0.06));
            }

            vector.rotate(Random.between(-0.5,0.5));
        }
    }
}
