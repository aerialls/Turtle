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

import turtle.Kernel;
import turtle.entity.field.Field;
import turtle.util.Log;

/**
 * Permet la simplification de la cr�ation d'une �quipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamBuilder
{
    public final static int TEAM_LEFT = 1;
    public final static int TEAM_RIGHT = 2;

    /**
     * Le nombre de joueur dans une �quipe
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
     * Cr�ation d'une �quipe standard
     *
     * @param field        Le terrain de foot
     * @param color        La couleur de l'�quipe
     * @param teamPosition La position de l'�quipe
     *
     * @return Une nouvelle instance de Team
     *
     * @see TeamBuilder#TEAM_LEFT
     * @see TeamBuilder#TEAM_RIGHT
     */
    public Team create(Field field, Color color, int teamPosition)
    {
        Dimension fieldDimension = field.getDimension();

        if (Kernel.DEBUG) {
            Log.i(String.format("Team creation (color:%s, teamPosition:%s)", color, teamPosition));
        }

        Team team = new Team(color);

        float height = (float) (fieldDimension.getHeight() / 2);
        float width  = (float) (fieldDimension.getWidth() / 4);

        if (teamPosition == TEAM_RIGHT) {
            width = (float) (fieldDimension.getWidth() - width);
        }

        //TODO Change the direction
        TurtleFactory.getInstance().createAttacker(field, team, new Point2D.Float(width, height), 0.0f);

        return team;
    }
}
