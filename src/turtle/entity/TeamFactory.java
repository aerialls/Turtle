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
import turtle.behavior.turtle.Attacker;
import turtle.behavior.turtle.TurtleBehaviorInterface;
import turtle.util.Log;

/**
 * Permet la simplification de la création d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamFactory
{
    public final static int TEAM_LEFT = 1;
    public final static int TEAM_RIGHT = 2;

    /**
     * Le nombre de joueur dans une équipe
     */
    protected final int mPlayers = 6;

    protected Game mGame;

    public TeamFactory(Game game)
    {
        mGame = game;
    }

    /**
     * Création d'une équipe standard
     *
     * @param color        La couleur de l'équipe
     * @param teamPosition La position de l'équipe
     *
     * @return Une nouvelle instance de Team
     *
     * @see TeamFactory#TEAM_LEFT
     * @see TeamFactory#TEAM_RIGHT
     */
    public Team createDefaultTeam(Color color, int teamPosition)
    {
        Dimension fieldDimension = mGame.getField().getDimension();

        if (Kernel.DEBUG) {
            Log.i(String.format("Team creation (color:%s, teamPosition:%s)", color, teamPosition));
        }

        TurtleBehaviorInterface behavior = new Attacker(mGame);
        Team team = new Team(color);

        float height = (float) (fieldDimension.getHeight() / 2);
        float width  = (float) (fieldDimension.getWidth() / 4);

        if (teamPosition == TEAM_RIGHT) {
            width = (float) (fieldDimension.getWidth() - width);
        }

        //TODO Change the direction
        Turtle turtle = new Turtle(behavior, new Point2D.Float(width, height), 0.0f);

        // Links between classes
        behavior.setTurtle(turtle);
        turtle.setTeam(team);
        team.addTurtle(turtle);

        return team;
    }
}
