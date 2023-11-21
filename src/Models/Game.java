package Models;

import Exceptions.InvalidDimensionException;
import Strategy.GameWinningStrategy;
import Strategy.OrderOneGameWinningStrategy;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gamestatus;
    private int nextPlayerIndex;

    private Player winningPlayer;

    private GameWinningStrategy gameWinningStrategy;

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGamestatus() {
        return gamestatus;
    }

    public void setGamestatus(GameStatus gamestatus) {
        this.gamestatus = gamestatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void makeNextMove(Game game) throws Exception {
        Player currplayer = players.get(nextPlayerIndex);
        System.out.println("It is " +
                currplayer +"'s move");

        Move move = currplayer.decideMove(board); // confusion

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(board.getBoard().get(row).get(col)
                .getCellstate()
                .equals(CellState.EMPTY)){

                board.applyMove(move);
                moves.add(move);
                //check winner
                if(gameWinningStrategy.checkWinner(board, move)){
                    gamestatus = GameStatus.ENDED;
                    winningPlayer = currplayer;
                }
                nextPlayerIndex += 1;
                nextPlayerIndex %= players.size();

        }else{
            throw new Exception();
        }

    }

    public static class Builder{
        private int dimension;
        private List<Player> players;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayer(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build()  {
            try{
                isValid();
            }catch(InvalidDimensionException e){
                return null;
            }
            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new LinkedList<>());
            game.setNextPlayerIndex(0);
            game.setGamestatus(GameStatus.IN_PROGRESS);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
            return game;
        }

        private boolean isValid() throws InvalidDimensionException {
            if(dimension< 3) throw new InvalidDimensionException
                    ("Please put dimension greater than 2.");
            return true;
        }
    }
}
