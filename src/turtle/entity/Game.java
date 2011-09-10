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
import java.util.Observable;

public class Game extends Observable
{
    protected Team mTeamA;
    protected Team mTeamB;

    public Game()
    {
        mTeamA = new Team(Color.RED);
        mTeamB = new Team(Color.BLUE);
    }
}
