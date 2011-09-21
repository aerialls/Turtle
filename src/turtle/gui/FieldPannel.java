/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import turtle.entity.Field;

/**
 * Représentation de la vue d'un terrain de foot
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class FieldPannel extends JPanel
{
    protected Field mField;

    public FieldPannel(Field field)
    {
        mField = field;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // Green
        g.setColor(new Color(31, 160, 31));

        // Background
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // White
        g.setColor(Color.WHITE);

        // Goal A
        Line2D line = mField.getGoalA().getLine();

        g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());

    }
}
