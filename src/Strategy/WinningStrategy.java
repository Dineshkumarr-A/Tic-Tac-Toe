package Strategy;

import Model.Board;
import Model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
    void handleMove(Board board, Move move);
}
