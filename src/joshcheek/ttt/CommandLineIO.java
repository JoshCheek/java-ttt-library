package joshcheek.ttt;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineIO implements IO {

    private Game    game;
    private Scanner input = new Scanner(System.in);

    // wtf no specifying constructos in interfaces? -.^
    public void setGame(Game game) {
        this.game = game;
    }

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

    public int getMove() {
        out("Where would you like to move? " + game.availableMoves());
        return Integer.parseInt(input.nextLine());
    }

    private String markerFor(int position) {
        if (game.playerAt(position) == -1) return " ";
        return Integer.toString(game.playerAt(position));
    }

}
