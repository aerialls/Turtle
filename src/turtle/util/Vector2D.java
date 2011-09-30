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
public class Vector2D implements Cloneable
{
    protected float mX;
    protected float mY;

    public Vector2D(float x, int y)
    {
        mX = x;
        mY = y;
    }

    public Vector2D(Vector2D vector)
    {
        mX = vector.mX;
        mY = vector.mY;
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
     * Retourne la norme du vecteur
     */
    public float norm()
    {
        return (float) Math.sqrt(mX * mX + mY * mY);
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
        final Vector2D vector = (Vector2D) obj;

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
     * @param vector Le vecteur à additioner
     *
     * @return L'instance courante avec l'opération réalisée
     */
    public Vector2D sum(Vector2D vector)
    {
        mX += vector.mX;
        mY += vector.mY;

        return this;
    }

    /**
     * Soustrait un vecteur au vecteur actuel
     *
     * @param vector Le vecteur à soustraire
     *
     * @return L'instance courante avec l'opération réalisée
     */
    public Vector2D sub(Vector2D vector)
    {
        mX -= vector.mX;
        mY -= vector.mY;

        return this;
    }

    /**
     * Multiplie le vecteur avec une constante
     *
     * @param a Le vecteur à multipliser
     *
     * @return L'instance courante avec l'opération réalisée
     */
    public Vector2D mul(float a)
    {
        mX *= a;
        mY *= a;

        return this;
    }

    /**
     * Inversion le vecteur
     *
     * @return L'instance courante avec l'opération réalisée
     */
    public Vector2D neg()
    {
        mX -= mX;
        mY -= mY;

        return this;
    }

    /**
     * Effectue une rotation de 90° au vecteur
     *
     * @return L'instance courante avec l'opération réalisée
     */
    public Vector2D rotate90()
    {
        float tmp = mX;

        mX = -mY;
        mY = tmp;

        return this;
    }

    /**
     * Calcule la distance entre deux vecteurs
     *
     * @param vector Le deuxième vecteur
     *
     * @return La distance
     */
    public float dist(Vector2D vector)
    {
        float dx = mX - vector.mX;
        float dy = mY - vector.mY;

        return (float) Math.sqrt(dx * dx + dy * dy);
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

    @Override
    public Vector2D clone()
    {
        return new Vector2D(this);
    }

    @Override
    public String toString()
    {
        return "[" + mX + "," + mY + "]";
    }
}
