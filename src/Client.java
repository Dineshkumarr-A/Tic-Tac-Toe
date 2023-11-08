import Controller.GameController;
import Model.Game;
import Model.GameState;
import exceptions.DuplicateSymbolException;
import exceptions.MoreThanOneBotException;
import exceptions.PlayersCountDimensionMismatchException;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();

        Game game = gameController.startGame(3, new ArrayList<>(), new ArrayList<>());

        while (gameController.getState(game).equals(GameState.IN_PROGRESS))
        {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
    }
}
