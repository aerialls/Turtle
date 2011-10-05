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
import java.awt.geom.Point2D;

import turtle.entity.field.Field;
import turtle.entity.field.Goal;
import turtle.util.Log;

/**
 * Permet la simplification de la création d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamBuilder
{
    /**
     * Création d'une équipe à gauche du terrain
     */
    public final static int TEAM_LEFT = 1;

    /**
     * Création d'une équipe à droite du terrain
     */
    public final static int TEAM_RIGHT = 2;

    /**
     * Le nombre de joueur dans une équipe
     */
    protected final int mPlayers = 6;

    /**
     * L'instance pour le singleton
     */
    protected static TeamBuilder mInstance;

    /**
     * Impossible d'instancier cet object via le constructeur
     *
     * @see TeamBuilder#getInstance()
     */
    private TeamBuilder()
    {
    }

    /**
     * Retourne l'instance pour le singleton
     */
    public static TeamBuilder getInstance()
    {
        return (mInstance == null) ? (mInstance = new TeamBuilder()) : mInstance;
    }

    /**
     * Création d'une équipe standard
     *
     * @param field        Le terrain de foot
     * @param color        La couleur de l'équipe
     * @param teamPosition La position de l'équipe
     *
     * @return Une nouvelle instance de Team
     *
     * @see TeamBuilder#TEAM_LEFT
     * @see TeamBuilder#TEAM_RIGHT
     */
    public Team create(Field field, Color color, String name, int teamPosition)
    {
        Dimension fieldDimension = field.getDimension();

        Log.i(String.format("Team creation (name=%s, color=%s, teamPosition=%s)", name, color, teamPosition));

        Team team = new Team(color, name);
        Goal goal;

        float height = (float) (fieldDimension.getHeight() / 2);
        float width  = (float) (fieldDimension.getWidth() / 4);

        if (teamPosition == TEAM_RIGHT) {
            width = (float) (fieldDimension.getWidth() - width);
            goal = field.getGoalB();
        } else {
            goal = field.getGoalA();
        }

        TurtleFactory factory = TurtleFactory.getInstance();

        factory.createAttacker(field, goal, team, new Point2D.Float(width, height), 0.0f);

        return team;
    }
}
