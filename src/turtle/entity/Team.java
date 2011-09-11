/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import turtle.behavior.team.TeamBehaviorInterface;

public class Team
{
    /**
     * L'ensemble des joueurs de l'équipe
     */
    protected Set<Turtle> mPlayers;

    /**
     * La couleur des joueurs
     */
    protected Color mColor;

    /**
     * Le score actuel de l'équipe
     */
    protected int mScore;

    /**
     * Le comportement de l'équipe
     */
    protected TeamBehaviorInterface mBehavior;

    public Team(Color color, Set<Turtle> players)
    {
        mColor = color;
        mScore = 0;

        if (players == null) {
            throw new IllegalArgumentException("A team must have at least one player.");
        }

        mPlayers = players;
    }

    public Set<Turtle> getPlayers()
    {
        return mPlayers;
    }

    public Color getColor()
    {
        return mColor;
    }
}
