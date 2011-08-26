package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class HumanPlayer implements Player {

    private Game game;
    private IO   io;

    public HumanPlayer(Game game, IO io) {
        this.game = game;
        this.io   = io;
    }

    public void takeTurn() {
        game.mark(io.getMove());
    }

}
