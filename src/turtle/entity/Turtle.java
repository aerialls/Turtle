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

import turtle.behavior.turtle.TurtleBehaviorInterface;

/**
 * Représentation d'un joueur de foot
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
     * L'équipe du joueur
     */
    protected Team mTeam;

    /**
     * Le comportement du joueur
     */
    protected TurtleBehaviorInterface mBehavior;

    /**
     * Création d'un joueur
     *
     * @param team     L'équipe du joueur
     * @param behavior Le comportement
     * @param position La position sur le terrain
     */
    public Turtle(Team team, TurtleBehaviorInterface behavior, Point2D position)
    {
        if (behavior == null) {
            throw new IllegalArgumentException("A Turtle needs to have a TurtleBehavior.");
        }

        mTeam = team;
        mBehavior = behavior;
        mPosition = position;
    }

    /**
     * Retourne la position du joueur sur le terrain
     *
     * @return La position du joueur
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
     * Retourne la vitesse de déplacement du joueur
     *
     * @return La vitesse
     */
    public float getSpeed()
    {
        return mBehavior.getSpeed();
    }
}