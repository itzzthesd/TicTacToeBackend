package Strategy;

import Models.Board;
import Models.Move;

public interface GameWinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
