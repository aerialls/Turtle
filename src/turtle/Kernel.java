/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle;

import turtle.entity.Game;
import turtle.util.Log;

/**
 * Contr�leur principal
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class Kernel implements Runnable
{
    /**
     * Version du programme
     */
    public static final String VERSION = "1.0-PROTOTYPE";

    /**
     * Si le programme est en mode d�bug ou non
     */
    public static final boolean DEBUG = true;

    /**
     * Le mod�le
     */
    protected Game mGame;

    /**
     * Le temps entre chaque frame
     */
    protected int mDelay;

    /**
     * Cr�ation du contr�lleur
     *
     * @param game Le mod�le
     */
    public Kernel(Game game)
    {
        mGame = game;

        // The frame rate for 25 images per seconde
        mDelay = 40;

        new Thread(this, "Kernel").start();
    }

    @Override
    public void run()
    {
        long startTime = System.currentTimeMillis();

        long delay = 0;
        long frame = 0;

        while (true) {
            frame++;

            Log.i(String.format("New frame (number=%d, delay=%dms)", frame, delay));

            startTime += mDelay;
            delay = startTime - System.currentTimeMillis();

            try {
                Thread.sleep(Math.max(0, delay));
            } catch (InterruptedException e) {
                Log.e("Thread.sleep exception : " + e.getMessage());
                break;
            }
        }
    }
}
