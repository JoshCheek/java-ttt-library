package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 5:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineInterfase implements Interfase {

    private Game              game;
    private Player            player1;
    private Player            player2;
    private CommandLineInput  input  = new CommandLineInput();
    private CommandLineOutput output = new CommandLineOutput();

    public CommandLineInterfase(Game game) {
        this.game = game;
    }

    public void setPlayers() {
        player1 = setPlayer(1);
        player2 = setPlayer(2);
    }

    private Player setPlayer(int turnNumber) {
        if(input.promptPlayerType(turnNumber) == 'h')
            return new HumanPlayer(game, input);
        else
            return new ComputerPlayer(game);
    }

    private void takeTurns() {
        while(!game.isOver()) {
            output.displayBoard(game.board());
            currentPlayer().takeTurn();
        }
    }

    public Player currentPlayer() {
        if(game.turn() == 1)
            return player1;
        return player2;
    }

    public void playGame() {
        output.displayIntro();
        setPlayers();
        takeTurns();
        output.displayResults(game.winner(), game.board());
        output.displayOutro();
    }

}
