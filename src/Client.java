import Controller.GameController;
import Model.*;
import Strategy.ColWinningStrategy;
import Strategy.DiagWinningStrategy;
import Strategy.RowWinningStrategy;
import Strategy.WinningStrategy;
import exceptions.DuplicateSymbolException;
import exceptions.MoreThanOneBotException;
import exceptions.PlayersCountDimensionMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();

        //Scanner scanner = new Scanner(System.in);

        int dimensions = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1,"Dinesh", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Bot(1,"Pradeep", new Symbol('0'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagWinningStrategy()
        );

        Game game = gameController.startGame(3, players, winningStrategies);

        while (gameController.getState(game).equals(GameState.IN_PROGRESS))
        {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        gameController.printBoard(game);

        System.out.println("Game is finished");

        GameState gameState = gameController.getState(game);

        if(gameState.equals(GameState.DRAW))
        {
            System.out.println("Match is draw");
        }
        else
        {
            System.out.println("we have a winner");
        }
    }
}
