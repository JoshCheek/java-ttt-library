package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/26/11
 * Time: 7:45 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IO {
    public void setGame(Game game);
    public void displayIntro();
    public void displayResults(Game game);
    public void displayOutro();
    public char promptPlayerType(int turnNumber);
    public void displayBoard(Game game);
    public int  getMove();
}
