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
 * Contrôleur principal
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
     * Si le programme est en mode débug ou non
     */
    public static final boolean DEBUG = true;

    /**
     * Le modèle
     */
    protected Game mGame;

    /**
     * Le numéro de la frame en cours
     */
    protected int mFrame;

    /**
     * Le temps entre chaque frame
     */
    protected int mDelay;

    /**
     * Le nombre d'image par seconde
     */
    protected final int mFps = 25;

    /**
     * Création du contrôlleur
     *
     * @param game Le modèle
     */
    public Kernel(Game game)
    {
        mGame = game;
        mFrame = 0;

        // The frame rate for 25 images per seconde
        mDelay = 40;

        new Thread(this, "Kernel").start();
    }

    @Override
    public void run()
    {
        long startTime = System.currentTimeMillis();

        while (true) {
            mFrame++;

            // Do stuff later

            try {
                startTime += mDelay;
                Thread.sleep(Math.max(0, startTime - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                Log.e("Thread.sleep exception : " + e.getMessage());
                break;
            }
        }
    }
}
