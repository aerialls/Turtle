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

import turtle.entity.field.Field;

/**
 * Repr�sentation d'un jeu de foot (au niveau du mod�le)
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Game extends Observable
{
    /**
     * Premi�re �quipe
     */
    protected Team mTeamA;

    /**
     * Deuxi�me �quipe
     */
    protected Team mTeamB;

    /**
     * Si la partie est lanc�e ou non
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

    /**
     * Cr�ation du mod�le
     */
    public Game()
    {
        mLaunched = false;
        mCurrentTime = 0.0f;
        // Hardcoded for the moment
        mMaxTime = 120;

        mField = new Field(700, 500);

        // Creation of the teams
        TeamBuilder builder = TeamBuilder.getInstance();

        mTeamA = builder.create(mField, Color.RED, TeamBuilder.TEAM_LEFT);
        mTeamB = builder.create(mField, Color.BLUE, TeamBuilder.TEAM_RIGHT);
    }

    /**
     * Retourne le terrain de foot
     */
    public Field getField()
    {
        return mField;
    }
}
