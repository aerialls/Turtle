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

    public Turtle()
    {
        this(new Point(0, 0));
    }

    public Turtle(Point position)
    {
        if (position == null) {
            throw new IllegalArgumentException("You need to enter a correct position");
        }

        mPosition = position;
    }
}