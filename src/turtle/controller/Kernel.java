/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.controller;

import java.util.ArrayList;
import turtle.behavior.team.TeamBehaviorInterface;
import turtle.entity.Game;
import turtle.entity.Team;
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
    public static final String VERSION = "1.0-PROTOTYPE-3";

    /**
     * Si le programme est en mode débug ou non
     */
    public static final boolean DEBUG = true;

    /**
     * Le modèle
     */
    protected Game mGame;

    /**
     * Le limitateur de FPS
     */
    protected FrameLimiter mFrameLimiter;

    /**
     * Le thread du kernel
     */
    protected Thread mThread;

    /**
     * Le nombre de frame
     */
    protected long mFrame;

    /**
     * Création du contrôlleur
     *
     * @param game Le modèle
     */
    public Kernel(Game game)
    {
        mGame = game;
        mFrameLimiter = new FrameLimiter(50);
        mFrame = 0;
    }

    /**
     * Lance le jeu
     */
    public void start()
    {
        if (mThread != null) {
            return;
        }

        mGame.setLaunched(true);

        mThread = new Thread(this, "Kernel");
        mThread.start();
    }

    public void paused()
    {
        if (mThread == null) {
            return;
        }

        mThread.interrupt();
    }

    @Override
    public void run()
    {
        long elapsedTime = System.currentTimeMillis();

        while (!mThread.isInterrupted()) {
            mFrameLimiter.start();
            mFrame++;

            elapsedTime = System.currentTimeMillis() - elapsedTime;

            if (mGame.isEnded()) {
                mThread.interrupt();
                Log.i("The game is over!");
                continue;
            }

            mGame.update(elapsedTime);

            // Check for goal

            mGame.notifyObservers();

            elapsedTime = System.currentTimeMillis();

            Log.i(String.format("New frame (number=%d, fps=%f)", mFrame, mFrameLimiter.getFps()));

            if (!mFrameLimiter.sleep()) {
                break;
            }
        }

        mGame.setLaunched(false);
        mThread = null;
    }

    /**
     * Change le comportement d'une équipe
     *
     * @param team     L'équipe
     * @param behavior Le nouveau comportement
     */
    public void changeTeamBehavior(Team team, TeamBehaviorInterface behavior)
    {
        ArrayList<TeamBehaviorInterface> behaviors = team.getAvailableBehaviors();

        if (behaviors.contains(behavior)) {
            team.setBehavior(behavior);
        } else {
            Log.e(String.format("The behavior %s cannot be used for the team %s", behavior, team));
        }
    }
}
