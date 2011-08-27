package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class HumanPlayer implements Player {

    private Game                game;
    private CommandLineInput    input;

    public HumanPlayer(Game game, CommandLineInput input) {
        this.game   = game;
        this.input  = input;
    }

    public void takeTurn() {
        game.mark(input.getMove(game.availableMoves()));
    }

}
