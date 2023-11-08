package Strategy;

import Model.Board;

public interface WinningStrategy {
    void checkWinner(Board board);
}
