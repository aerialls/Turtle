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
    protected final int players = 6;

    /**
     * La partie
     */
    protected Game mGame;

    public TeamFactory(Game game)
    {
        mGame = game;
    }

    /**
     * Création d'une équipe standard
     *
     * @param color La couleur de l'équipe
     * @param teamPosition La position de l'équipe
     *
     * @return Une nouvelle instance de Team
     *
     * @see TeamFactory#TEAM_LEFT
     * @see TeamFactory#TEAM_RIGHT
     */
    public Team createDefaultTeam(Color color, int teamPosition)
    {
        return null;
    }
}
