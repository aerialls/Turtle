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
    /**
     * Première équipe
     */
    protected Team mTeamA;

    /**
     * Deuxième équipe
     */
    protected Team mTeamB;

    /**
     * Si la partie est lancée ou non
     */
    protected boolean mLaunched;

    /**
     * Le temps depuis le commencement de la partie
     */
    protected float mCurrentTime;

    /**
     * Le temps maximal d'une partie en secondes
     */
    protected float mMaxTime;

    /**
     * Le terrain
     */
    protected Field mField;

    public Game()
    {
        mLaunched = false;
        mCurrentTime = 0.0f;
        // Hardcoded for the moment
        mMaxTime = 120;

        mField = new Field();

        // Creation of the teams
        TeamFactory factory = new TeamFactory(this);

        mTeamA = factory.createDefaultTeam(Color.RED, TeamFactory.TEAM_LEFT);
        mTeamB = factory.createDefaultTeam(Color.BLUE, TeamFactory.TEAM_RIGHT);
    }

    public Field getField()
    {
        return mField;
    }
}
