package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rating {
    public static double rate_for(String board, int player) {
        return new Game(board).winner() == player ? 1.0 : -1.0;
    }
}
