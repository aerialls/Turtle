/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.entity;

import java.awt.Dimension;

/**
 * Représentation d'un terrain de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Field
{
    protected Dimension mDimension;

    public Field()
    {
        mDimension = new Dimension(700, 500);
    }

    public Dimension getDimension()
    {
        return mDimension;
    }
}
