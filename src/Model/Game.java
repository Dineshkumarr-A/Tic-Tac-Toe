package Model;
import Strategy.WinningStrategy;
import java.util.List;

public class Game {
    private List<Player> player;
    private Board board;
    private List<WinningStrategy> winningStrategiesList;
    private int nextMovePlayerIndex;
    private Player winner;
    private GameState gameState;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<WinningStrategy> getWinningStrategiesList() {
        return winningStrategiesList;
    }

    public void setWinningStrategiesList(List<WinningStrategy> winningStrategiesList) {
        this.winningStrategiesList = winningStrategiesList;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
