package Strategy;

import Model.Board;
import Model.Move;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagWinningStrategy implements WinningStrategy{
    private Map<Symbol, Integer> leftDiagCount = new HashMap<>();
    private Map<Symbol, Integer> rightDiagCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Symbol symbol = move.getPlayer().getSymbol();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        //left diagonal 3 == 3 or n == n
        if(row == col)
        {
            leftDiagCount.put(symbol,
                    leftDiagCount.getOrDefault(symbol,0) + 1);

            if(leftDiagCount.get(symbol) == board.getSize())
                return true;
        }

        //right diagonal sum of the diagonal is always equal to row+col == size-1
        if(row + col == board.getSize() - 1)
        {
            rightDiagCount.put(symbol,
                    rightDiagCount.getOrDefault(symbol,0) + 1);

            if(rightDiagCount.get(symbol) == board.getSize())
                return true;
        }

        return false;
    }


    @Override
    public void handleMove(Board board, Move move) {
//        int row = move.getCell().getRow();
//        Symbol symbol = move.getCell().getPlayer().getSymbol();
//
//        Map<Symbol, Integer> rowMap = countMap.get(row);
//
//        rowMap.put(symbol,rowMap.getOrDefault(symbol,0) - 1);
    }
}
