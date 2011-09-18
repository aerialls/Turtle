/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Représentation d'un but
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Goal
{
    /**
     * La position du but
     */
    protected Line2D mLine;

    /**
     * Le propriétaire du but
     */
    protected Team mTeam;

    /**
     * Création d'un but d'une équipe
     *
     * @param team      Le propriétaire du but
     * @param positionA Le premier point pour la position du but
     * @param positionB Le deuxième point pour la position du but
     */
    public Goal(Team team, Point2D positionA, Point2D positionB)
    {
        mLine = new Line2D.Float(positionA, positionB);
        mTeam = team;
    }
}
