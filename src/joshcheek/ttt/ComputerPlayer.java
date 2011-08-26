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
//        game.mark(bestMove());
    }

    public int bestMove() {
//        int bestMove=0;
//        double bestRating=0;
//        for(int move: game.availableMoves()) {
//            Game newGame  = game.pristineMove(move);
//            double rating = Rating.rate_for(game.board(), playerNumber());
//        }
        return 1;
    }
//
//    private int playerNumber() {
//        return 0;  //To change body of created methods use File | Settings | File Templates.
//    }
}
