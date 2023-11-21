package Models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType playerType;

    @Override
    public String toString() {
        return this.name;
    }

    public Player(char symbol, String botName, PlayerType playerType) {
        this.symbol = symbol;
        this.playerType = playerType;
        this.name = botName;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row of the move:");
        int row = sc.nextInt();

        System.out.println("enter the column of the move:");
        int col = sc.nextInt();

        return new Move(this, new Cells(row, col));
    }
}
