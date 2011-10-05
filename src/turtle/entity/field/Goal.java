/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity.field;

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
     * Création d'un but d'une équipe
     *
     * @param positionA Le premier point pour la position du but
     * @param positionB Le deuxième point pour la position du but
     */
    public Goal(Point2D positionA, Point2D positionB)
    {
        mLine = new Line2D.Float(positionA, positionB);
    }

    /**
     * Retourne la ligne modélisant le but
     */
    public Line2D getLine()
    {
        return mLine;
    }

    /**
     * Regarde si le ballon est dans le but
     *
     * @param ball Le ballon à tester
     *
     * @return Vrai si la ligne de but contient la position
     * du ballon
     */
    public boolean contains(Ball ball)
    {
        return mLine.contains(ball.getPosition());
    }
}
