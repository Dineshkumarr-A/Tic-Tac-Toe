package Model;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Please enter the row no to move: ");
        int row = scanner.nextInt();
        System.out.println("Please enter the col to move: ");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col),this);
    }
}
