/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.gui;

import java.util.Observable;

import turtle.entity.Game;

public class InformationWindow extends AbstractWindow
{
    public InformationWindow(Game game)
    {
        super(game);
    }

    @Override
    public void update(Observable o, Object arg)
    {
    }
}
