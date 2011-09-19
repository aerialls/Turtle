/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

import java.awt.geom.Point2D;

import turtle.behavior.turtle.Attacker;
import turtle.behavior.turtle.Defender;
import turtle.behavior.turtle.TurtleBehaviorInterface;

/**
 * Permet la simplification de la création des joueurs
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TurtleFactory
{
    protected Game mGame;

    public TurtleFactory(Game game)
    {
        mGame = game;
    }

    public Turtle createAttacker(Team team, Point2D position, float direction)
    {
        return new Turtle(team, new Attacker(mGame), position, direction);
    }

    public Turtle createDefender(Team team, Point2D position, float direction)
    {
        return new Turtle(team, new Defender(mGame), position, direction);
    }
}
