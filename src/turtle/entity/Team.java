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

public class Team
{
    protected Set<Turtle> mPlayers;
    protected Color mColor;

    public Team(Color color)
    {
        mColor = color;
        mPlayers = new HashSet<Turtle>();
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
