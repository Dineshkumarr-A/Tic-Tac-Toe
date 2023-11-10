package Strategy;

import Model.Board;
import Model.Move;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol, Integer>> countMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!countMap.containsKey(row))
        {
            countMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> rowMap = countMap.get(row);

        rowMap.put(symbol,rowMap.getOrDefault(symbol,0) + 1);

        if(rowMap.get(symbol) == board.getSize())
            return true;

        return false;
    }

    @Override
    public void handleMove(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getCell().getPlayer().getSymbol();

        Map<Symbol, Integer> rowMap = countMap.get(row);

        rowMap.put(symbol,rowMap.getOrDefault(symbol,0) - 1);
    }
}
