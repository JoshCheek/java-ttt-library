package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rating {
    private Game      game;
    private Rating    parent;
    private Rating[]  children;

    public Rating(String board, Rating parent) {
        this(new Game(board), parent);
    }

    public Rating(Game game, Rating parent) {
        this.game = game;
        this.parent = parent;
    }

    public Rating(String board) {
        this(board, null);
    }

    public Rating[] children() {
        if(children != null) return children;
        int[] availableMoves = game.availableMoves();
        children = new Rating[availableMoves.length];
        for(int i=0; i < children().length; ++i)
            children[i] = new Rating(game.pristineMove(availableMoves[i]), this);
        return children;
    }

    public boolean isLeaf() {
        return children().length == 0;
    }

    public double ratingFor(int playerNum) {
        if(isLeaf())
            return game.isTie() ? 0 : game.winner() == playerNum ? 1 : -1;
        int currentPlayer = game.turn();
        if(currentPlayer == playerNum) {
            if(anyGuaranteedWin(playerNum))      return 1;
            if(allGuaranteedLoss(playerNum))     return -1;
                                                 return relativeRatingForComputer(playerNum);
        }
        if(anyGuaranteedLoss(playerNum))         return -1;
        if(allGuaranteedWin(playerNum))          return 1;
                                                 return relativeRatingForOpponent(playerNum);
    }

    private double relativeRatingForOpponent(int playerNum) {
        double sum=0;
        for(Rating child : children())
            sum += child.ratingFor(playerNum);
        return sum / children().length;
    }

    private double relativeRatingForComputer(int playerNum) {
        double sum=0, size=0;
        for(Rating child : children()) {
            double rating = child.ratingFor(playerNum);
            if(rating != -1) {
                sum += rating;
                ++size;
            }
        }
        return sum / size;
    }

    private boolean allGuaranteedWin(int playerNum) {
        for(Rating rating : children())
            if(rating.ratingFor(playerNum) != 1.0)
                return false;
        return true;
    }

    private boolean anyGuaranteedLoss(int playerNum) {
        for(Rating rating : children())
            if(rating.ratingFor(playerNum) == -1.0)
                return true;
        return false;
    }

    private boolean anyGuaranteedWin(int playerNum) {
        for(Rating rating : children())
            if(rating.ratingFor(playerNum) == 1.0)
                return true;
        return false;
    }

    private boolean allGuaranteedLoss(int playerNum) {
        for(Rating rating : children())
            if(rating.ratingFor(playerNum) != -1.0)
                return false;
        return true;
    }


    public static double rate_for(String board, int player) {
        return new Rating(board).ratingFor(player);
    }
}
