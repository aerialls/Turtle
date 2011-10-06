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
import turtle.entity.field.Field;
import turtle.entity.field.Goal;

/**
 * Permet la simplification de la création des joueurs
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TurtleFactory
{
    /**
     * L'instance pour le singleton
     */
    protected static TurtleFactory mInstance;

    /**
     * Impossible d'instancier cet object via le constructeur
     *
     * @see TurtleFactory#getInstance()
     */
    private TurtleFactory()
    {
    }

    /**
     * Retourne l'instance pour le singleton
     */
    public static TurtleFactory getInstance()
    {
        return (mInstance == null) ? (mInstance = new TurtleFactory()) : mInstance;
    }

    /**
     * Création d'un nouvel attaquant
     *
     * @param field     Le terrain de foot
     * @param goal      Le but de l'équipe
     * @param team      L'équipe du joueur
     * @param position  La position sur le terrain de foot
     * @param direction La direction du joueur
     */
    public Turtle createAttacker(Field field, Goal goal, Team team, Point2D position, double direction)
    {
        return new Turtle(goal, team, new Attacker(field), position, direction);
    }

    /**
     * Création d'un nouveau défenseur
     *
     * @param field     Le terrain de foot
     * @param goal      Le but de l'équipe
     * @param team      L'équipe du joueur
     * @param position  La position sur le terrain de foot
     * @param direction La direction du joueur
     */
    public Turtle createDefender(Field field, Goal goal, Team team, Point2D position, double direction)
    {
        return new Turtle(goal, team, new Defender(field), position, direction);
    }
}
