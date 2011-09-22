/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity.field;

import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 * Repr�sentation d'un terrain de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Field
{
    /**
     * Les dimensions du terrain
     */
    protected Dimension mDimension;

    /**
     * Le premier but
     */
    protected Goal mGoalA;

    /**
     * Le deuxi�me but
     */
    protected Goal mGoalB;

    /**
     * Le ballon sur le terrain de foot
     */
    protected Ball mBall;

    /**
     * La largeur du terrain de foot
     */
    private final int mWidth = 700;

    /**
     * La hauteur du terrain de foot
     */
    private final int mHeight = 500;

    /**
     * Construction du terrain de foot
     */
    public Field()
    {
        mDimension = new Dimension(mWidth, mHeight);

        // The ball
        mBall = new Ball(new Point2D.Float(0.0f, 0.0f));

        // Goal A
        float height = (float) (0.35 * mHeight);

        float x = (float) (0.05 * mWidth);
        float y = (mHeight - height) / 2;

        mGoalA = new Goal(new Point2D.Float(x, y), new Point2D.Float(x, y + height));

        // Goal B
        x = mWidth - x;

        mGoalB = new Goal(new Point2D.Float(x, y), new Point2D.Float(x, y + height));
    }

    /**
     * Retourne les dimensions du terrain
     */
    public Dimension getDimension()
    {
        return mDimension;
    }

    /**
     * Retourne le but de l'�quipe A
     */
    public Goal getGoalA()
    {
        return mGoalA;
    }

    /**
     * Retourne le but de l'�quipe B
     */
    public Goal getGoalB()
    {
        return mGoalB;
    }

    /**
     * Retourne le ballon du terrain de foot
     */
    public Ball getBall()
    {
        return mBall;
    }
}
