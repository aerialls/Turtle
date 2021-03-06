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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import turtle.behavior.team.TeamBehaviorInterface;
import turtle.entity.field.Goal;

/**
 * Représentation d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Team
{
    /**
     * L'ensemble des joueurs de l'équipe
     */
    protected List<Turtle> mTurtles;

    /**
     * La couleur des joueurs
     */
    protected Color mColor;

    /**
     * Le nom de l'équipe
     */
    protected String mName;

    /**
     * Le but de l'équipe
     */
    protected Goal mGoal;

    /**
     * Le score actuel de l'équipe
     */
    protected int mScore;

    /**
     * Le comportement de l'équipe
     */
    protected TeamBehaviorInterface mBehavior;

    /**
     * L'ensemble des comportements pour une équipe
     */
    protected ArrayList<TeamBehaviorInterface> mAvailableBehaviors;

    /**
     * Création d'une équipe
     *
     * @param color   La couleur de l'équipe
     * @param name    Le nom de l'équipe
     */
    public Team(Goal goal, Color color, String name)
    {
        mTurtles = new ArrayList<Turtle>();
        mAvailableBehaviors = new ArrayList<TeamBehaviorInterface>();

        mColor = color;
        mGoal = goal;
        mName = name;
        mScore = 0;
    }

    /**
     * Fait avancer le jeu
     */
    public void update(long elapsedTime)
    {
        // Il est nécessaire de mélanger les joueurs
        // pour avoir un traitement le plus aléatoire possible
        Collections.shuffle(mTurtles);

        Iterator<Turtle> it = mTurtles.iterator();
        while (it.hasNext()) {
            Turtle turtle = it.next();
            turtle.update(elapsedTime);
        }
    }

    /**
     * Ajoute un joueur dans l'équipe
     *
     * @param turtle Le joueur à ajouter
     */
    public void addTurtle(Turtle turtle)
    {
        mTurtles.add(turtle);
    }

    /**
     * Augmente le score de l'équipe
     *
     * @param inc  Le nombre de but
     */
    public void incrementScore(int inc)
    {
        mScore += inc;
    }

    /**
     * Augmente le score de l'équipe de 1
     */
    public void incrementScore()
    {
        mScore += 1;
    }

    /**
     * Retourne l'ensemble des joueurs
     */
    public List<Turtle> getTurtles()
    {
        return mTurtles;
    }

    /**
     * Retourne la couleur de l'équipe
     */
    public Color getColor()
    {
        return mColor;
    }

    /**
     * Retourne le nom de l'équipe
     */
    public String getName()
    {
        return mName;
    }

    /**
     * Retourne le goal de l'équipe
     */
    public Goal getGoal()
    {
        return mGoal;
    }

    /**
     * Retourne le score de l'équipe
     */
    public int getScore()
    {
        return mScore;
    }

    /**
     * Change le comportement de l'équipe
     *
     * @param behavior Le nouveau comportement pour l'équipe
     *
     * @throw IllegalArgumentException Si le comportement n'est pas listé
     * dans la liste des comportements disponible
     *
     * @see Team#getAvailableBehaviors()
     */
    public void setBehavior(TeamBehaviorInterface behavior)
    {
        if (behavior != null && !mAvailableBehaviors.contains(behavior)) {
            throw new IllegalArgumentException("The behavior must be in the list of available behaviors. (see Team::getAvailableBehaviors())");
        }

        mBehavior = behavior;
    }

    /**
     * Retourne le comportement de l'équipe
     */
    public TeamBehaviorInterface getBehavior()
    {
        return mBehavior;
    }

    /**
     * Retourne l'ensemble des comportements disponible
     */
    public ArrayList<TeamBehaviorInterface> getAvailableBehaviors()
    {
        return mAvailableBehaviors;
    }

    /**
     * Ajoute un nouveau comportement pour l'équipe
     *
     * @param behavior Le comportement
     */
    public void addAvailableBehavior(TeamBehaviorInterface behavior)
    {
        mAvailableBehaviors.add(behavior);
    }

    /**
     * Ajoute plusieurs comportement pour l'équipe
     *
     * @param behaviors La collection contenant l'ensemble des comportements
     */
    public void addAvailableBehaviors(Collection<TeamBehaviorInterface> behaviors)
    {
        mAvailableBehaviors.addAll(behaviors);
    }

    @Override
    public String toString()
    {
        return mName;
    }
}
