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
 * Représentation d'un jeu de foot (au niveau du modèle)
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
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
     * Le temps depuis le commencement de la partie en ms
     */
    protected long mCurrentTime;

    /**
     * Le temps maximal d'une partie en ms
     */
    protected long mMaxTime;

    /**
     * Le terrain
     */
    protected Field mField;

    /**
     * Création du modèle
     */
    public Game()
    {
        mLaunched = false;
        mCurrentTime = 0;
        // Hardcoded for the moment
        mMaxTime = 5400000;

        mField = new Field(700, 500);

        // Creation of the teams
        TeamBuilder builder = TeamBuilder.getInstance();

        mTeamA = builder.create(mField, Color.RED, TeamBuilder.TEAM_LEFT);
        mTeamB = builder.create(mField, Color.BLUE, TeamBuilder.TEAM_RIGHT);
    }

    /**
     * Fait avancer le jeu
     */
    public void update(long elapsedTime)
    {
        mCurrentTime += elapsedTime;
        // Do stuff later

        setChanged();
    }

    /**
     * Retourne le terrain de foot
     */
    public Field getField()
    {
        return mField;
    }

    /**
     * Retourne l'équipe A
     */
    public Team getTeamA()
    {
        return mTeamA;
    }

    /**
     * Retourne l'équipe B
     */
    public Team getTeamB()
    {
        return mTeamB;
    }

    /**
     * Retourne le temps depuis le commencement de la partie (en ms)
     */
    public long getCurrentTime()
    {
        return mCurrentTime;
    }

    /**
     * Retourne le temps restant (en ms)
     */
    public long getRemainingTime()
    {
        return mMaxTime - mCurrentTime;
    }

    /**
     * Retourne le temps maximal de la partie (en ms)
     */
    public long getMaxTime()
    {
        return mMaxTime;
    }

    public void setLaunched(boolean launched)
    {
        mLaunched = launched;
    }

    public boolean isLaunched()
    {
        return mLaunched;
    }
}
