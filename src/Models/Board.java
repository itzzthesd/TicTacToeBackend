package Models;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cells>> cells;

    public Board(int dimension) {
        this.size = dimension;
        this.cells = new LinkedList<>();
        for(int i=0;i<dimension; i++){
            this.cells.add(new LinkedList<>());
            for(int j=0;j<dimension; j++){
                this.cells.get(i).add(new Cells(i,j));
            }

        }
    }

    public List<List<Cells>> getBoard(){
        return cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cells>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cells>> cells) {
        this.cells = cells;
    }

    public void displayBoard() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(cells.get(i).get(j).getCellstate()
                        == CellState.EMPTY){
                    System.out.print("| |");
                }else{
                    System.out.print("|" +
                            cells.get(i).get(j).getPlayer().getSymbol() + "|");
                }

            }
            System.out.println();
        }
    }

    public void applyMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        this.getBoard().get(row).get(col)
                .setCellstate(CellState.FILLED);
        this.getBoard().get(row).get(col)
                .setPlayer(move.getPlayer());
    }
}
