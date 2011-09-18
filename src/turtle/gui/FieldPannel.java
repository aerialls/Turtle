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

        setBackground(new Color(31, 160, 31));
    }
}
