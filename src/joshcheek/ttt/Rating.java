package joshcheek.ttt;

import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rating {
    private Game                        game;
    private Rating                      parent;
    private Hashtable<Integer, Rating>  children;

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

    public Hashtable<Integer, Rating> children() {
        if(children != null) return children;
        children = new Hashtable<Integer, Rating>();
        for(int position : game.availableMoves()) {
            Game afterMoving = game.pristineMove(position);
            children.put(position, new Rating(afterMoving, this));
        }
        return children;
    }

    public boolean isLeaf() {
        return children().isEmpty();
    }

    public double ratingFor(int playerNum) {
        if(isLeaf()) {
            return game.isTie() ? 0 : game.winner() == playerNum ? 1 : -1;
        }
         return 9;
    }

//    def rating_for(player_number)
//      if leaf?
//        return 0  if game.tie?
//        return 1  if game.winner == player_number
//        return -1
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
