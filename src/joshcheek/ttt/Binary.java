package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 4:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Binary {

    private Interfase   interfase;

    public static void main(String[] args) {
        Binary binary = new Binary("000000000");
        binary.playGame();
    }

    public Binary(String board) {
        interfase = new CommandLineInterfase(new Game(board));
    }

    private void playGame() {
        interfase.playGame();
    }

}
