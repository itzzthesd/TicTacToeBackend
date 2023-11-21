package Controller;

import Models.Game;
import Models.GameStatus;
import Models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return   Game.getBuilder()
                .setDimension(dimension)
                .setPlayer(players)
                .build();
    }

    public GameStatus getGamestatus(Game game) {
        return game.getGamestatus();
    }

    public Player getWinningPlayer(Game game) {
        return game.getWinningPlayer();
    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public void executeNextMove(Game game) throws Exception {
        game.makeNextMove(game);
    }
}
