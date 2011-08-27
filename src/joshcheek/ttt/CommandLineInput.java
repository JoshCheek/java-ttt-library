package joshcheek.ttt;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/27/11
 * Time: 5:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineInput {

    private Scanner input = new Scanner(System.in);

    public int getMove(int[] availableMoves) {
        String moveOptions = "(";
        for(int move : availableMoves)
            moveOptions += " " + move;
        moveOptions += " )";
        System.out.print("Where would you like to move? " + moveOptions);
        return Integer.parseInt(input.nextLine());
    }

    public char promptPlayerType(int turnNumber) {
        System.out.print("Do you want player " + turnNumber + " to be played by a human or computer? (h/c): ");
        return input.nextLine().charAt(0);
    }

}
