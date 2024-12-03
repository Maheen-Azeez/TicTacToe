package contorllers;

import models.Board;
import models.Game;
import models.Player;
import models.PlayerType;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> players){
        return Game.getBuilder()
                .setPlayers(players)
                .build();
    }

    public void printBoard(Board board){
        board.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
    public Player getWinner(Game game) {
        return game.getPlayers().get(game.getCurrentPlayerIdx());
    }
    public void undoMove(Game game) {
        game.undoMove();
    }
}
