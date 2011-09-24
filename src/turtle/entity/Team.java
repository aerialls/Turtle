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
     * Le score actuel de l'équipe
     */
    protected int mScore;

    /**
     * Le comportement de l'équipe
     */
    protected TeamBehaviorInterface mBehavior;

    /**
     * Création d'une équipe
     *
     * @param color   La couleur de l'équipe
     */
    public Team(Color color)
    {
        mTurtles = new HashSet<Turtle>();

        mColor = color;
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

    public Set<Turtle> getTurtles()
    {
        return mTurtles;
    }

    public Color getColor()
    {
        return mColor;
    }
}
