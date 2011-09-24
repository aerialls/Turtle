/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import turtle.entity.field.Field;
import turtle.entity.Turtle;

/**
 * Comportement d'un joueur abstrait
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
abstract public class AbstractTurtleBehavior implements TurtleBehaviorInterface
{
    /**
     * Le joueur concerné par le comportement
     */
    protected Turtle mTurtle;

    /**
     * Le jeu
     */
    protected Field mField;

    public AbstractTurtleBehavior(Field field)
    {
        mField = field;
    }

    @Override
    public void setTurtle(Turtle turtle)
    {
        mTurtle = turtle;
    }

    @Override
    public String toString()
    {
        return this.getClass().getName();
    }
}
