/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.team;

import turtle.entity.Team;
import turtle.entity.Turtle;
import turtle.entity.field.Ball;
import turtle.entity.field.Field;
import turtle.util.Random;
import turtle.util.geom.Vector2D;

/**
 * Comportement agressif d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Aggressive extends AbstractTeamBehavior
{
    public Aggressive(Field field, Team team)
    {
        super(field, team);
    }

    @Override
    public void apply(Vector2D vector, long elapsedTime)
    {
        Ball ball = mField.getBall();
        Turtle lastShooter = (Turtle) ball.getLastShooter();

        if (lastShooter != null && lastShooter.getTeam() == mTeam) {
            // Le ballon a été tiré par l'équipe du joueur
            Vector2D speed = ball.getSpeedVector();
            speed.rotate(Random.degreesToRadians(-3, +3));
        }

        // Augmentation de la vitesse mais perte de précision
        vector.scale(Random.between(1.2, 1.5));
        vector.rotate(Random.between(-1, +1));
    }
}
