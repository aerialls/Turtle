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
 * Repr�sentation d'une �quipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Team
{
    /**
     * L'ensemble des joueurs de l'�quipe
     */
    protected Set<Turtle> mTurtles;

    /**
     * La couleur des joueurs
     */
    protected Color mColor;

    /**
     * Le score actuel de l'�quipe
     */
    protected int mScore;

    /**
     * Le comportement de l'�quipe
     */
    protected TeamBehaviorInterface mBehavior;

    /**
     * Cr�ation d'une �quipe
     *
     * @param color   La couleur de l'�quipe
     */
    public Team(Color color)
    {
        mTurtles = new HashSet<Turtle>();

        mColor = color;
        mScore = 0;
    }

    /**
     * Ajoute un joueur dans l'�quipe
     *
     * @param turtle Le joueur � ajouter
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
