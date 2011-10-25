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
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import turtle.entity.field.Ball;
import turtle.entity.field.Field;
import turtle.util.geom.Circle2D;

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
     * Construction du modèle pour le jeu de foot
     *
     * @param maxTime        La durée d'une partie en secondes
     * @param fieldDimension Les dimensions du terrain
     */
    public Game(int maxTime, Dimension fieldDimension)
    {
        mLaunched = false;
        mCurrentTime = 0;
        mMaxTime = maxTime;

        mField = new Field(fieldDimension);

        // Création des équipes
        TeamBuilder builder = TeamBuilder.getInstance();

        mTeamA = builder.create(mField, new Color(17, 119, 187), "A", TeamBuilder.TEAM_LEFT);
        mTeamB = builder.create(mField, new Color(255, 51, 51), "B", TeamBuilder.TEAM_RIGHT);
    }

    /**
     * Construction du modèle pour le jeu de foot par défaut
     * Le temps de la partie sera de 10min avec un terrain
     * de taille 700x500
     */
    public Game()
    {
        this(600000, new Dimension(700, 500));
    }

    /**
     * Fait avancer le jeu
     */
    public void update(long elapsedTime)
    {
        mCurrentTime += elapsedTime;

        // Terrain
        mField.update(elapsedTime);

        checkGoals();

        List<Turtle> turtles = getTurtles();
        Collections.shuffle(turtles);

        Iterator<Turtle> it = turtles.iterator();
        while (it.hasNext()) {
            Turtle turtle = it.next();
            turtle.update(elapsedTime);

            if (checkCollision(turtle)) {
                turtle.goBack(elapsedTime);
            }
        }

        // On informe le modèle qu'il a changé pour transmettre les
        // informations à la vue
        setChanged();
    }

    /**
     * Retourne l'ensemble des joueurs du jeu
     */
    public List<Turtle> getTurtles()
    {
        List<Turtle> turtles = new ArrayList<Turtle>();

        turtles.addAll(mTeamA.getTurtles());
        turtles.addAll(mTeamB.getTurtles());

        return turtles;
    }

    /**
     * Regarde si le ballon est dans un but
     */
    private void checkGoals()
    {
        Ball ball = mField.getBall();

        Iterator<Team> it = getTeams().iterator();
        while (it.hasNext()) {
            Team team = it.next();
            if (team.getGoal().contains(ball)) {
                Turtle turtle = (Turtle) ball.getLastShooter();
                turtle.getTeam().incrementScore();

                mField.resetBallPosition();
                resetTurtlesPosition();
            }
        }
    }

    /**
     * Place les joueurs à leurs positions d'origine
     */
    private void resetTurtlesPosition()
    {
        List<Turtle> turtles = getTurtles();
        Iterator<Turtle> it = turtles.iterator();

        while (it.hasNext()) {
            Turtle turtle = it.next();
            turtle.resetPosition();
        }
    }

    private boolean checkCollision(Turtle turtle)
    {
        List<Turtle> turtles = getTurtles();

        Iterator<Turtle> it = turtles.iterator();
        while (it.hasNext()) {
            Turtle tmp = it.next();

            if (tmp == turtle) {
                continue;
            }

            Rectangle2D c1 = tmp.getSquareRepresentation();
            Rectangle2D c2 = turtle.getSquareRepresentation();

            if (c1.intersects(c2)) {
                return true;
            }
        }

        return false;
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
     * Retourne l'ensemble des équipes d'une partie
     */
    public List<Team> getTeams()
    {
        List<Team> teams = new ArrayList<Team>();

        teams.add(mTeamA);
        teams.add(mTeamB);

        return teams;
    }

    /**
     * Retourne la balle du terrain
     */
    public Ball getBall()
    {
        return mField.getBall();
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

    /**
     * Retourne vrai si le jeu est en cours
     */
    public boolean isLaunched()
    {
        return mLaunched;
    }

    /**
     * Retourne vrai si le jeu est terminé
     */
    public boolean isEnded()
    {
        return getRemainingTime() <= 0;
    }
}
