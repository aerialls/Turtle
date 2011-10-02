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

/**
 * Comportement abstrait pour une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public abstract class AbstractTeamBehavior implements TeamBehaviorInterface
{
    protected Team mTeam;

    public AbstractTeamBehavior(Team team)
    {
        mTeam = team;
    }

    @Override
    public String toString()
    {
        return getName();
    }

    @Override
    public String getName()
    {
        return this.getClass().getName();
    }
}
