/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

import java.awt.Point;

import turtle.behavior.turtle.TurtleBehaviorInterface;

public class Turtle
{
    /**
     * La position du joueur sur le terrain
     */
    protected Point mPosition;

    /**
     * Le comportement du joueur
     */
    protected TurtleBehaviorInterface mBehavior;

    public Turtle(TurtleBehaviorInterface behavior)
    {
        if (behavior == null) {
            throw new IllegalArgumentException("A Turtle needs to have a TurtleBehavior.");
        }

        mBehavior = behavior;
    }

    /**
     * Retourne la position du joueur sur le terrain
     *
     * @return La position du joueur
     */
    public Point getPosition()
    {
        return mPosition;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param x Le distance sur l'axe des X
     * @param y La distance sur l'axe des Y
     */
    public void setPosition(Point position)
    {
        mPosition = position;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param x Le distance sur l'axe des X
     * @param y La distance sur l'axe des Y
     */
    public void setPosition(int x, int y)
    {
        mPosition = new Point(x, y);
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