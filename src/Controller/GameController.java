package Controller;

import Model.Game;
import Model.GameState;
import Model.Player;
import Strategy.WinningStrategy;
import exceptions.DuplicateSymbolException;
import exceptions.MoreThanOneBotException;
import exceptions.PlayersCountDimensionMismatchException;

import java.util.List;

public class GameController {

    public Game startGame(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies)
            throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void printBoard(Game game)
    {
        game.printBoard();
    }

    public GameState getState(Game game)
    {
        return game.getGameState();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
