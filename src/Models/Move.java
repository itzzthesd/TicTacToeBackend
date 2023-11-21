package Models;

public class Move {
    private Player player;
    private Cells cell;

    public Move(Player player, Cells cells) {
        this.player = player;
        this.cell = cells;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cells getCell() {
        return cell;
    }

    public void setCell(Cells cell) {
        this.cell = cell;
    }
}
