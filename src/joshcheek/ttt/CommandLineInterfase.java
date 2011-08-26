package joshcheek.ttt;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 5:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineInterfase implements Interfase {

    private Game game;
    private Player player1;
    private Player player2;
    private IO     io;

    public CommandLineInterfase(Game game) {
        this.game = game;
        io = new IO();
    }

    public void setPlayers() {
        player1 = setPlayer(1);
        player2 = setPlayer(2);
    }

    private Player setPlayer(int turnNumber) {
        if(io.promptPlayerType(turnNumber) == 'h')
            return new ComputerPlayer(game);
        else
            return new ComputerPlayer(game);
    }

    private void takeTurns() {
        while(!game.isOver()) {
            io.displayBoard(game);
            currentPlayer().takeTurn();
        }
    }

    public Player currentPlayer() {
        if(game.turn() == 1)
            return player1;
        return player2;
    }

    public void playGame() {
        io.displayIntro();
        setPlayers();
        takeTurns();
        io.displayResults(game);
        io.displayOutro();
    }

    private class IO {

        private Scanner input = new Scanner(System.in);

        public void displayIntro() {
            out("intro");
        }

        public void displayResults(Game game) {
            out("results");
        }

        public void displayOutro() {
            out("outro");
        }

        public char promptPlayerType(int turnNumber) {
            out("Do you want player " + turnNumber + " to be played by a human or computer? (h/c): ");
            return input.nextLine().charAt(0);
        }

        private void out(String msg) {
            System.out.println(msg);
        }

        public void displayBoard(Game game) {
            out("   |   |   ");
            out(" " + markerFor(1) + " | " + markerFor(2) + " | " + markerFor(3) + " ");
            out("   |   |   ");
            out("---|---|---");
            out("   |   |   ");
            out(" " + markerFor(4) + " | " + markerFor(5) + " | " + markerFor(6) + " ");
            out("   |   |   ");
            out("---|---|---");
            out("   |   |   ");
            out(" " + markerFor(7) + " | " + markerFor(8) + " | " + markerFor(9) + " ");
            out("   |   |   ");
            out("");
        }

        private String markerFor(int position) {
            if(game.playerAt(position) == -1) return " ";
            return Integer.toString(game.playerAt(position));
        }
    }
}
