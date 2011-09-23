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
import turtle.entity.field.Field;

/**
 * Permet la simplification de la cr�ation des joueurs
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
     * Cr�ation d'un nouvel attaquant
     *
     * @param field     Le terrain de foot
     * @param team      L'�quipe du joueur
     * @param position  La position sur le terrain de foot
     * @param direction La direction du joueur
     */
    public Turtle createAttacker(Field field, Team team, Point2D position, float direction)
    {
        return new Turtle(team, new Attacker(field), position, direction);
    }

    /**
     * Cr�ation d'un nouveau d�fenseur
     *
     * @param field     Le terrain de foot
     * @param team      L'�quipe du joueur
     * @param position  La position sur le terrain de foot
     * @param direction La direction du joueur
     */
    public Turtle createDefender(Field field, Team team, Point2D position, float direction)
    {
        return new Turtle(team, new Defender(field), position, direction);
    }
}
