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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import turtle.behavior.team.TeamBehaviorInterface;
import turtle.behavior.turtle.TurtleBehaviorInterface;
import turtle.entity.field.Ball;
import turtle.util.geom.Circle2D;
import turtle.util.Generate;
import turtle.util.Log;
import turtle.util.geom.Vector2D;

/**
 * Représentation d'un joueur de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Turtle
{
    /**
     * La position du joueur sur le terrain
     */
    protected Point2D mPosition;

    /**
     * La position initiale du joueur sur le terrain
     */
    protected Point2D mInitialPosition;

    /**
     * Le vecteur vitesse
     */
    protected Vector2D mSpeedVector;

    /**
     * Le diamètre d'un joueur
     */
    protected final int mDiameter = 7;

    /**
     * L'équipe du joueur
     */
    protected Team mTeam;

    /**
     * Le comportement du joueur
     */
    protected TurtleBehaviorInterface mBehavior;

    /**
     * Determine si le joeur est en collision ou non
     */
    protected boolean mCollision;

    /**
     * Création d'un joueur
     *
     * @param team      L'équipe du joueur
     * @param behavior  Le comportement
     * @param position  La position sur le terrain
     */
    public Turtle(Team team, TurtleBehaviorInterface behavior, Point2D position)
    {
        if (behavior == null) {
            throw new IllegalArgumentException("A Turtle needs to have a TurtleBehavior.");
        }

        behavior.setTurtle(this);

        mSpeedVector = new Vector2D();
        mTeam = team;
        mCollision = false;
        mBehavior = behavior;
        mPosition = position;
        mInitialPosition = (Point2D) position.clone();

        Log.i(String.format("Turtle creation (behavior=%s, position=%s)", behavior, position));
    }

    /**
     * Met à jour la position d'un joueur
     *
     * @param elapsedTime Le temps écoulé depuis le dernier appel
     */
    public void update(long elapsedTime)
    {
        // Si le joueur est en collision, on saute son mouvement
        if (mCollision) {
            return;
        }

        Vector2D vector = new Vector2D();

        // Le comportement du joueur
        TeamBehaviorInterface teamBehavior = mTeam.getBehavior();
        mBehavior.apply(vector, elapsedTime);

        // Ainsi que le comportement de l'équipe
        if (teamBehavior != null) {
            teamBehavior.apply(vector, elapsedTime);
        }

        Log.i(String.format("PLAYER - New speed vector (team=%s, player=%s, vector=%s)", mTeam, this, vector));

        mSpeedVector = vector;
        move(elapsedTime);
    }

    /**
     * Supprime le dernier mouvement du joueur
     *
     * @param elapsedTime Le temps écoulé depuis le dernier appel
     */
    public void goBack(long elapsedTime)
    {
        mPosition.setLocation(mPosition.getX() - mSpeedVector.getX() * elapsedTime, mPosition.getY() - mSpeedVector.getY() * elapsedTime);
    }

    /**
     * Met à jour la position du joueur en fonction de sa vitesse
     *
     * @param elapsedTime Le temps écoulé depuis le dernier appel
     */
    private void move(long elapsedTime)
    {
        mPosition.setLocation(mPosition.getX() + mSpeedVector.getX() * elapsedTime, mPosition.getY() + mSpeedVector.getY() * elapsedTime);
    }

    /**
     * Place le joueur à sa position d'origine
     */
    public void resetPosition()
    {
        mPosition = (Point2D) mInitialPosition.clone();
    }

    /**
     * Regarde si la ball est proche du joueur
     *
     * @param ball Le ballon du terrain
     *
     * @return Vrai si la balle est proche du joueur, faux sinon
     */
    public boolean isAround(Ball ball)
    {
        return isAround(ball, mDiameter);
    }

    /**
     * Regarde si la ball est proche du joueur
     *
     * Cette méthode s'occupe de créer un cercle de diamiètre {distance}
     * et regarde si le ballon est présent dans ce cercle
     *
     * @param ball     Le ballon du terrain
     * @param distance La distance de recherche max
     *
     * @return Vrai si le ballon est dans le carré, faux sinon
     */
    public boolean isAround(Ball ball, double distance)
    {
        Circle2D circle = new Circle2D(mPosition.getX(), mPosition.getY(), distance);

        return circle.contains(ball.getPosition());
    }

    /**
     * Retourne un rectangle représentant le joueur sur le terrain
     */
    public Rectangle2D getSquareRepresentation()
    {
        return Generate.squareCenteredOn(mPosition.getX(), mPosition.getY(), mDiameter);
    }

    /**
     * Retourne la position du joueur sur le terrain
     */
    public Point2D getPosition()
    {
        return mPosition;
    }

    /**
     * Retourne la position initial du joueur sur le terrain
     */
    public Point2D getInitialPosition()
    {
        return mInitialPosition;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param position L'objet position
     */
    public void setPosition(Point2D position)
    {
        mPosition = position;
    }

    /**
     * Change la position du joueur sur le terrain
     *
     * @param x Le distance sur l'axe des X
     * @param y La distance sur l'axe des Y
     */
    public void setPosition(double x, double y)
    {
        mPosition = new Point2D.Double(x, y);
    }

    /**
     * Change le vecteur vitesse du joueur
     *
     * @param vector Le nouveau vecteur de vitesse
     */
    public void setSpeedVector(Vector2D vector)
    {
        mSpeedVector = vector;
    }

    /**
     * Retourne le vecteur de vitesse
     */
    public Vector2D getSpeedVector()
    {
        return mSpeedVector;
    }

    /**
     * Retourne le comportement du joueur
     *
     * @return Le comportement
     */
    public TurtleBehaviorInterface getBehavior()
    {
        return mBehavior;
    }

    /**
     * Retourne l'équipe du joueur
     */
    public Team getTeam()
    {
        return mTeam;
    }

    /**
     * Retourne si le joueur est actuellement en collision avec un autre joueur
     */
    public boolean getCollision()
    {
        return mCollision;
    }

    /**
     * Change l'état de collision du joueur
     *
     * @param collision Si oui ou non le joueur est en collision
     */
    public void setCollision(boolean collision)
    {
        mCollision = collision;
    }

    /**
     * Retourne le diamiètre du joueur
     */
    public int getDiameter()
    {
        return mDiameter;
    }

    /**
     * Retourne la couleur du joueur
     */
    public Color getColor()
    {
        return mTeam.getColor();
    }
}