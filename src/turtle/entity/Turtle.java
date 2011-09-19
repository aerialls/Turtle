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

import turtle.Kernel;
import turtle.behavior.turtle.TurtleBehaviorInterface;
import turtle.util.Log;

/**
 * Repr�sentation d'un joueur de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Turtle
{
    /**
     * La position du joueur sur le terrain
     */
    protected Point2D mPosition;

    /**
     * La direction du joueur sur le terrain
     */
    protected float mDirection;

    /**
     * L'�quipe du joueur
     */
    protected Team mTeam;

    /**
     * Le comportement du joueur
     */
    protected TurtleBehaviorInterface mBehavior;

    /**
     * Cr�ation d'un joueur
     *
     * @param behavior  Le comportement
     * @param position  La position sur le terrain
     * @param direction La direction sur le terrain
     */
    public Turtle(TurtleBehaviorInterface behavior, Point2D position, float direction)
    {
        if (behavior == null) {
            throw new IllegalArgumentException("A Turtle needs to have a TurtleBehavior.");
        }

        if (Kernel.DEBUG) {
            Log.i(String.format("Turtle creation (behavior=%s, position=%s)", behavior, position));
        }

        mBehavior = behavior;
        mPosition = position;
        mDirection = direction;
    }

    /**
     * Retourne la position du joueur sur le terrain
     */
    public Point2D getPosition()
    {
        return mPosition;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param position L'objet position
     */
    public void setPosition(Point2D position)
    {
        mPosition = position;
    }

    /**
     * Retourne la direction du joueur sur le terrain
     */
    public float getDirection()
    {
        return mDirection;
    }

    /**
     * Change la direction du joueur sur le terrain
     *
     * @param direction La direction du joueur
     */
    public void setDirection(float direction)
    {
        mDirection = direction;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param x Le distance sur l'axe des X
     * @param y La distance sur l'axe des Y
     */
    public void setPosition(float x, float y)
    {
        mPosition = new Point2D.Float(x, y);
    }

    /**
     * Retourne le comportement du joueur
     *
     * @return Le comportement
     */
    public TurtleBehaviorInterface getBehavior()
    {
        return mBehavior;
    }

    /**
     * Change le comportement du joueur
     *
     * @param behavior Le nouveau comportement
     */
    public void setBehavior(TurtleBehaviorInterface behavior)
    {
        mBehavior = behavior;
    }

    /**
     * Associe une �quipe au joueur
     *
     * @param team L'�quipe
     */
    public void setTeam(Team team)
    {
        mTeam = team;
    }

    /**
     * Retourne la vitesse de d�placement du joueur
     *
     * @return La vitesse
     */
    public float getSpeed()
    {
        return mBehavior.getSpeed();
    }
}