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

import turtle.behavior.team.Aggressive;
import turtle.behavior.team.TeamBehaviorInterface;

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
    protected Set<Turtle> mTurtles;

    /**
     * La couleur des joueurs
     */
    protected Color mColor;

    /**
     * Le nom de l'équipe
     */
    protected String mName;

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
    protected Set<TeamBehaviorInterface> mAvailableBehaviors;

    /**
     * Création d'une équipe
     *
     * @param color   La couleur de l'équipe
     * @param name    Le nom de l'équipe
     */
    public Team(Color color, String name)
    {
        mTurtles = new HashSet<Turtle>();

        createAvailableBehaviors();

        mColor = color;
        mName = name;
        mScore = 0;
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
     * Retourne l'ensemble des joueurs
     */
    public Set<Turtle> getTurtles()
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
        if (!mAvailableBehaviors.contains(behavior)) {
            throw new IllegalArgumentException("The behavior must be in the list of available behaviors. (see Team::getAvailableBehaviors())");
        }

        mBehavior = behavior;
    }

    /**
     * Retourne l'ensemble des comportements disponible
     */
    public Set<TeamBehaviorInterface> getAvailableBehaviors()
    {
        return mAvailableBehaviors;
    }

    /**
     * Création de l'ensemble des comportements
     * disponible pour l'équipe
     */
    private void createAvailableBehaviors()
    {
        mAvailableBehaviors = new HashSet<TeamBehaviorInterface>();

        mAvailableBehaviors.add(new Aggressive(this));
    }
}
