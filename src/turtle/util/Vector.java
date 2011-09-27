/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.util;

/**
 * Gestion des vecteurs en deux dimensions
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Vector
{
    protected float mX;
    protected float mY;

    public Vector(float x, int y)
    {
        mX = x;
        mY = y;
    }

    /**
     * Effectue une rotation du vecteur
     *
     * @param angle L'angle de rotation (en gradient)
     */
    public void rotate(float angle)
    {
        float rx = (float) ((mX * Math.cos(angle)) - (mY * Math.sin(angle)));
        float ry = (float) ((mY * Math.sin(angle)) + (mY * Math.cos(angle)));

        mX = rx;
        mY = ry;
    }

    /**
     * Retourne la longueur du vecteur
     */
    public double getLength()
    {
        return Math.sqrt(mX * mX + mY * mY);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector vector = (Vector) obj;

        if (Float.floatToIntBits(this.mX) != Float.floatToIntBits(vector.mX)) {
            return false;
        }
        if (Float.floatToIntBits(this.mY) != Float.floatToIntBits(vector.mY)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 83 * hash + Float.floatToIntBits(this.mX);
        hash = 83 * hash + Float.floatToIntBits(this.mY);

        return hash;
    }

    /**
     * Additione un vecteur au vecteur actuel
     *
     * @param vector Le vecteur a additioner
     */
    public void sum(Vector vector)
    {
        mX += vector.mX;
        mY += vector.mY;
    }

    /**
     * Retourne la composante X du vecteur
     */
    public float getX()
    {
        return mX;
    }

    /**
     * Retourne lacomposante Y du vecteur
     */
    public float getY()
    {
        return mY;
    }
}
