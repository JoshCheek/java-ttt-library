package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputerPlayer implements Player {
    private Game game;

    public ComputerPlayer(Game game) {
        this.game = game;
    }

    public void takeTurn() {
        game.mark(bestMove());
    }

    public int bestMove() {
        if(isFirstMoveInGame()) return 1;
        if(hasNecessaryMove())  return necessaryMove();
        return highestRatedMove();
    }

    private int highestRatedMove() {
        int bestMove=0;
        double bestRating=-2;
        for(int move: game.availableMoves()) {
            Game newGame  = game.pristineMove(move);
            double rating = Rating.rate_for(newGame.board(), playerNumber());
            if(rating > bestRating) {
                bestMove = move;
                bestRating = rating;
            }
        }
        return bestMove;
    }

    private int playerNumber() {
        return game.turn();
    }

    private boolean hasNecessaryMove() {
        return necessaryMove() != -1;
    }

    private int necessaryMove() {
        return -1;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean isFirstMoveInGame() {
        return game.board().equals("000000000");
    }


}
