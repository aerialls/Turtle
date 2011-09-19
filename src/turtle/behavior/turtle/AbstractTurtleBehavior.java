/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.behavior.turtle;

import turtle.entity.Game;
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
     * Le joueur concern� par le comportement
     */
    protected Turtle mTurtle;

    /**
     * Le jeu
     */
    protected Game mGame;

    public AbstractTurtleBehavior(Game game)
    {
        mGame = game;
    }

    @Override
    public void setTurtle(Turtle turtle)
    {
        mTurtle = turtle;
    }
}
