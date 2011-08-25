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
                                                 return 9.0; //relativeRatingForComputer();
        }
        if(anyGuaranteedLoss(playerNum))         return -1;
        if(allGuaranteedWin(playerNum))          return 1;
                                                 return 9.0; //relativeRatingForOpponent();
    }

    private boolean allGuaranteedWin(int playerNum) {
        for(Rating rating : children)
            if(rating.ratingFor(playerNum) != 1.0)
                return false;
        return true;
    }

    private boolean anyGuaranteedLoss(int playerNum) {
        for(Rating rating : children)
            if(rating.ratingFor(playerNum) == -1.0)
                return true;
        return false;
    }

    private boolean anyGuaranteedWin(int playerNum) {
        for(Rating rating : children)
            if(rating.ratingFor(playerNum) == 1.0)
                return true;
        return false;
    }

    private boolean allGuaranteedLoss(int playerNum) {
        for(Rating rating : children)
            if(rating.ratingFor(playerNum) != -1.0)
                return false;
        return true;
    }


//    def rating_for(player_number)
//      else
//        ratings = children.map { |_, child| child.rating_for player_number }
//        crnt_player = game.turn
//        if crnt_player == player_number
//          return  1 if ratings.any? { |rating| rating ==  1 }   # if my turn, and I can move to a win, then I win
//          return -1 if ratings.all? { |rating| rating == -1 }   # if my turn, and all moves are losses, then I lose
//          ratings.reject! { |rating| rating == -1 }
//          return ratings.inject(:+).to_f / ratings.size         # otherwise, rating is the average of non-losing moves (I will never make a losing move)
//        else
//          return -1 if ratings.any? { |rating| rating == -1 }   # if his turn, and he can win, then I lose
//          return  1 if ratings.all? { |rating| rating ==  1 }   # if his turn, and all his moves lead to wins for me, then I win
//          return ratings.inject(:+).to_f / ratings.size         # otherwise, rating is the average of possible move scores
//        end
//      end
//    end
//
//  end

    public static double rate_for(String board, int player) {
        return new Rating(board).ratingFor(player);
    }
}
