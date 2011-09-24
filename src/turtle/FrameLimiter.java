/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle;

import java.util.LinkedList;

/**
 * Permet de limiter le nombre de FPS pour l'affichage du jeu
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public class FrameLimiter
{
    protected int mDelay;

    private final LinkedList<Float> mTimes;

    private long mStartTime;

    private long mLastStartTime;

    /**
     * Constructeur du limiteur de FPS
     *
     * @param fps Le nombre de FPS
     */
    public FrameLimiter(int fps)
    {
        if (fps < 0) {
            throw new IllegalArgumentException("The fps must be a positive integer.");
        }

        mDelay = 1000 / fps;
        mTimes = new LinkedList<Float>();
    }

    /**
     * A lancer lors du début de boucle
     */
    public void start()
    {
        mStartTime = System.currentTimeMillis();

        if (mTimes.size() >= 10) {
            mTimes.poll();
        }

        mTimes.add(new Float(1000 /  (float) (mStartTime - mLastStartTime)));

        mLastStartTime = mStartTime;
    }

    /**
     * Vérifie si le thread doit être mis en pause pour limiter
     * le nombre de FPS
     *
     * @return false si une erreur
     */
    public boolean sleep()
    {
        long delay = System.currentTimeMillis() - mStartTime;

        if (delay < 0) {
            return false;
        }

        try {
            if (delay < mDelay) {
                Thread.sleep(mDelay - delay);
            }

            return true;
        }
        catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * Retourne le nombre de FPS actuellement
     */
    public float getFps()
    {
        float sum = 0;

        for (Float time : mTimes) {
            sum += time.floatValue();
        }

        return sum / mTimes.size();
    }
}
