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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import turtle.behavior.team.Aggressive;
import turtle.behavior.team.Stationary;
import turtle.behavior.team.TeamBehaviorInterface;
import turtle.entity.field.Field;
import turtle.entity.field.Goal;
import turtle.util.Log;

/**
 * Permet la simplification de la création d'une équipe
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class TeamBuilder
{
    /**
     * Création d'une équipe à gauche du terrain
     */
    public final static int TEAM_LEFT = 1;

    /**
     * Création d'une équipe à droite du terrain
     */
    public final static int TEAM_RIGHT = 2;

    /**
     * Le nombre de joueur dans une équipe
     */
    protected HashMap<Point2D, TurtleBehavior> mSchema;

    /**
     * L'instance pour le singleton
     */
    protected static TeamBuilder mInstance;

    /**
     * Impossible d'instancier cet object via le constructeur
     *
     * @see TeamBuilder#getInstance()
     */
    private TeamBuilder()
    {
        mSchema = new HashMap<Point2D, TurtleBehavior>();

        // Pour faciliter la position des joueurs, mSchema contient
        // l'ensemble des positions des joueurs pour l'équipe de gauche
        // sous la forme d'une position <= 1 et le classe pour le type de joueur
        mSchema.put(new Point2D.Double(0.4, 0.5), TurtleBehavior.ATTACKER);

        mSchema.put(new Point2D.Double(0.35, 0.2), TurtleBehavior.DEFENDER);
        mSchema.put(new Point2D.Double(0.2, 0.5), TurtleBehavior.DEFENDER);
        mSchema.put(new Point2D.Double(0.35, 0.8), TurtleBehavior.DEFENDER);

        mSchema.put(new Point2D.Double(0.08, 0.5), TurtleBehavior.GOALKEEPER);
    }

    /**
     * Retourne l'instance pour le singleton
     */
    public static TeamBuilder getInstance()
    {
        return (mInstance == null) ? (mInstance = new TeamBuilder()) : mInstance;
    }

    /**
     * Création d'une équipe standard
     *
     * @param field        Le terrain de foot
     * @param color        La couleur de l'équipe
     * @param teamPosition La position de l'équipe
     *
     * @return Une nouvelle instance de Team
     *
     * @see TeamBuilder#TEAM_LEFT
     * @see TeamBuilder#TEAM_RIGHT
     */
    public Team create(Field field, Color color, String name, int teamPosition)
    {
        Dimension fieldDimension = field.getDimension();
        TurtleFactory factory = TurtleFactory.getInstance();

        Log.i(String.format("Team creation (name=%s, color=%s, teamPosition=%s)", name, color, teamPosition));

        Goal goal;

        if (teamPosition == TEAM_RIGHT) {
            goal = field.getGoalB();
        } else {
            goal = field.getGoalA();
        }

        Team team = new Team(goal, color, name);

        // Création des comportements
        addAvailableBehaviors(field, team);

        // Pour chaque élément présent dans la map
        Iterator<Entry<Point2D, TurtleBehavior>> it = mSchema.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Point2D, TurtleBehavior> pairs = it.next();

            Point2D position = pairs.getKey();
            TurtleBehavior type = pairs.getValue();

            double x = fieldDimension.getWidth() * position.getX();
            double y = fieldDimension.getHeight() * position.getY();

            // Si le joueur est à droite, il est nécessaire d'inverser
            // sa position sur l'axe des x
            if (teamPosition == TEAM_RIGHT) {
                x = fieldDimension.getWidth() - x;
            }

            Point2D turtlePosition = new Point2D.Double(x, y);
            Turtle turtle = null;

            switch (type) {
                case ATTACKER:
                    turtle = factory.createAttacker(field, team, turtlePosition);
                    break;
                case DEFENDER:
                    turtle = factory.createDefender(field, team, turtlePosition);
                    break;
                case GOALKEEPER:
                    turtle = factory.createGoalkeeper(field, team, turtlePosition);
                    break;
            }

            if (turtle != null) {
                team.addTurtle(turtle);
            }
        }

        return team;
    }

    /**
     * Ajoute les comportements à l'équipe
     *
     * @param field Le terrain de foot
     * @param team L'équipe
     */
    private void addAvailableBehaviors(Field field, Team team)
    {
        List<TeamBehaviorInterface> behaviors = new ArrayList<TeamBehaviorInterface>();

        behaviors.add(new Aggressive(field, team));
        behaviors.add(new Stationary(field, team));

        team.addAvailableBehaviors(behaviors);
    }

    /**
     * Comportement d'un joueur
     */
    private enum TurtleBehavior
    {
        ATTACKER,
        DEFENDER,
        GOALKEEPER
    }
}
