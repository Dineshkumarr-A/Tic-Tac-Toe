package Model;
import Strategy.WinningStrategy;
import exceptions.DuplicateSymbolException;
import exceptions.MoreThanOneBotException;
import exceptions.PlayersCountDimensionMismatchException;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private List<WinningStrategy> winningStrategiesList;
    private int nextMovePlayerIndex;
    private Player winner;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private GameState gameState;
    private List<Move> moves;

    private Game(Builder builder)
    {
        this.players = builder.players;
        this.winningStrategiesList = builder.winningStrategies;
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.board = new Board(builder.dimensions);
        this.moves = new ArrayList<>();
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    // we are having a builder class since we have some validation to perform
    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy>  winningStrategies;
        private int dimensions;

        public Builder setDimensions(int dimension)
        {
            this.dimensions = dimension;
            return this;
        }

        //If you are passing multiple players at a time
        public Builder setPlayers(List<Player> players)
        {
            this.players = players;
            return this;
        }

        public Builder addPlayers(Player player)
        {
            this.players.add(player);
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies)
        {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy)
        {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build() throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
            validate();
            return new Game(this);
        }

        private void validate() throws MoreThanOneBotException, PlayersCountDimensionMismatchException, DuplicateSymbolException {
            validateBotCount();
            validateDimensionsAndPlayersCount();
            validateUniqueSymbolForPlayers();
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;
            for(Player player: this.players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
            }

            if(botCount > 1)
                throw new MoreThanOneBotException();
        }

        private void validateDimensionsAndPlayersCount() throws PlayersCountDimensionMismatchException {
            if(players.size() != dimensions - 1)
                throw new PlayersCountDimensionMismatchException();
        }

        private void validateUniqueSymbolForPlayers() throws DuplicateSymbolException {
            HashSet<Character> hashSet = new HashSet<>();
            for(Player player: players)
            {
                if(!hashSet.contains(player.getSymbol().getaChar()))
                {
                    hashSet.add(player.getSymbol().getaChar());
                }
                else
                    throw new DuplicateSymbolException();
            }
        }
    }

    public void printBoard()
    {
        board.printBoard();
    }

    private boolean validateMove(int row, int col)
    {

        if(row >= board.getSize() || col >= board.getSize())
            return false;
        else return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    private boolean checkWinner(Move move)
    {
        for(WinningStrategy winningStrategy: winningStrategiesList)
        {
            if(winningStrategy.checkWinner(board,move))
                return true;
        }
        return false;
    }

    public void makeMove()
    {
        Player currentMoveplayer = players.get(nextMovePlayerIndex);
        System.out.println("It is " + currentMoveplayer.getName() + "'s move. Please make move.");
        Move currentmove = currentMoveplayer.makeMove(board);

        int row = currentmove.getCell().getRow();
        int col = currentmove.getCell().getCol();

        System.out.println("The player " + currentMoveplayer.getName() + " has made the move. The row is " + row
        + " and the col is " + col);

        if(!validateMove(row,col))
        {
            System.out.println("Invalid move. Please try again");
            return;
        }

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentMoveplayer);

        Move finalMove = new Move(cellToChange, currentMoveplayer);
        moves.add(finalMove);

        //Set next player index
        nextMovePlayerIndex++;
        nextMovePlayerIndex %= players.size();

        if(checkWinner(currentmove))
        {
            gameState = GameState.WIN;
            winner = currentMoveplayer;
        }
        else if(moves.size() == board.getSize() * board.getSize())
        {
            gameState = GameState.DRAW;
        }
    }

    public void undo()
    {
        if(moves.size() == 0)
        {
            System.out.println("No move to undo");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);

        //Cell cell = lastMove.
    }

}
