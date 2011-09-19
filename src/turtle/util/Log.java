/*
 * This file is part of the Turtle project
 *
 * (c) 2011 Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package turtle.util;

/**
 * Simple gestion des logs
 *
 * @author Julien Brochet <julien.brochet@etu.univ-lyon1.fr>
 * @since 1.0
 */
public final class Log
{
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    private Log()
    {
    }

    public static void v(String msg)
    {
        println(VERBOSE, msg);
    }

    public static void d(String msg)
    {
        println(DEBUG, msg);
    }

    public static void i(String msg)
    {
        println(INFO, msg);
    }

    public static void w(String msg)
    {
        println(WARN, msg);
    }

    public static void e(String msg)
    {
        println(ERROR, msg);
    }

    public static void println(int priority, String msg)
    {
        String state = "Unknown";

        switch (priority) {
            case VERBOSE:
                state = "Verbose";
                break;
            case DEBUG:
                state = "Debug";
                break;
            case WARN:
                state = "Warning";
                break;
            case ERROR:
                state = "Error";
                break;
            case INFO:
                state = "Information";
                break;
        }

        System.out.println('[' + state + "] " + msg);
    }
}
