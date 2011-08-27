package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/27/11
 * Time: 5:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineOutput {

    public void displayIntro() {
        out("Welcome to Tic Tac Toe!");
    }

    // pass -1 if tie game
    public void displayResults(int winner, String board) {
        displayBoard(board);
        if(winner == -1)
            out("Tie game!");
        else
            out("Player " + winner + " won the game!");
    }

    public void displayOutro() {
        out("Play again soon!");
    }

    private void out(String msg) {
        System.out.println(msg);
    }

    // pass 9 character string that represents board ie "120000100" would be player 2's turn
    // and they'd need to move midleft to block player1's win, making next game state "120200100"
    public void displayBoard(String board) {
        out("   |   |   ");
        out(" " + markerFor(0, board) + " | " + markerFor(1, board) + " | " + markerFor(2, board) + " ");
        out("   |   |   ");
        out("---|---|---");
        out("   |   |   ");
        out(" " + markerFor(3, board) + " | " + markerFor(4, board) + " | " + markerFor(5, board) + " ");
        out("   |   |   ");
        out("---|---|---");
        out("   |   |   ");
        out(" " + markerFor(6, board) + " | " + markerFor(7, board) + " | " + markerFor(8, board) + " ");
        out("   |   |   ");
        out("");
    }

    private String markerFor(int position, String board) {
        if (board.charAt(position) == '1') return "X";
        if (board.charAt(position) == '2') return "O";
        return " ";
    }
}
