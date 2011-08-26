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
        game.mark(bestMove());
    }

    public int bestMove() {
        if(game.board().equals("000000000"))
            return 1;
        int bestMove=0;
        double bestRating=0;
        for(int move: game.availableMoves()) {
            Game newGame  = game.pristineMove(move);
            double rating = Rating.rate_for(newGame.board(), game.turn());
            if(rating > bestRating) {
                bestMove = move;
                bestRating = rating;
            }
        }
        return bestMove;
    }

//
//    private int playerNumber() {
//        return 0;  //To change body of created methods use File | Settings | File Templates.
//    }
}
