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

public class TeamFactory
{
    /**
     * Le nombre de joueur dans une �quipe
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
     * Cr�ation d'une �quipe standard
     *
     * @param color La couleur de l'�quipe
     *
     * @return Une nouvelle instance de Team
     */
    public Team createDefaultTeam(Color color)
    {
        return null;
    }
}
