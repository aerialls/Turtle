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

    protected FrameLimiter mFrameLimiter;

    /**
     * Cr�ation du contr�lleur
     *
     * @param game Le mod�le
     */
    public Kernel(Game game)
    {
        mGame = game;
        mFrameLimiter = new FrameLimiter(40);

        new Thread(this, "Kernel").start();
    }

    @Override
    public void run()
    {
        long frame = 0;
        long elapsedTime = System.currentTimeMillis();

        while (true) {
            mFrameLimiter.start();
            frame++;

            elapsedTime = System.currentTimeMillis() - elapsedTime;

            // Render the field

            elapsedTime = System.currentTimeMillis();

            Log.i(String.format("New frame (number=%d, fps=%f)", frame, mFrameLimiter.getFps()));

            if (!mFrameLimiter.sleep()) {
                break;
            }
        }
    }
}
