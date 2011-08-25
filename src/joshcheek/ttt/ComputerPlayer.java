package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputerPlayer {
    private Game game;

    public ComputerPlayer(Game game) {
        this.game = game;
    }

    public void takeTurn() {
        game.mark(3);
    }
}
