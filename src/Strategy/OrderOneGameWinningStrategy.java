package Strategy;

import Models.Board;
import Models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    List<HashMap<Character, Integer>> rowSymbolCounts
            = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCounts
            = new ArrayList<>();

    HashMap<Character, Integer> leftDiagSymbolCounts
            = new HashMap<>();

    HashMap<Character, Integer> rightDiagSymbolCounts
            = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension){
        for( int i=0; i< dimension; i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        char symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int dimension = board.getBoard().size();

        // update row map
        if(!rowSymbolCounts.get(row).containsKey(symbol)){ // this is the first time the symbols are getting stored in the hasmap
            rowSymbolCounts.get(row).put(symbol, 0);
        }

        rowSymbolCounts.get(row).put(symbol
                        , rowSymbolCounts.get(row)
                        .get(symbol) + 1);

        // update col map
        if(!colSymbolCounts.get(col).containsKey(symbol)){ // this is the first time the symbols are getting stored in the hasmap
            colSymbolCounts.get(col).put(symbol, 0);
        }

        colSymbolCounts.get(col).put(symbol
                , colSymbolCounts.get(col)
                        .get(symbol) + 1);

        // update left diagonal
        if(row == col){
            if(!leftDiagSymbolCounts.containsKey(symbol)){ // this is the first time the symbols are getting stored in the hasmap
                leftDiagSymbolCounts.put(symbol, 0);
            }

            leftDiagSymbolCounts.put(symbol
                    , leftDiagSymbolCounts
                            .get(symbol) + 1);
        }

        // update right diagonal
        if(row + col == dimension - 1){
            if(!rightDiagSymbolCounts.containsKey(symbol)){ // this is the first time the symbols are getting stored in the hasmap
                rightDiagSymbolCounts.put(symbol, 0);
            }

            rightDiagSymbolCounts.put(symbol
                    , rightDiagSymbolCounts
                            .get(symbol) + 1);
        }

        if(rowSymbolCounts.get(row).get(symbol)== dimension
        || colSymbolCounts.get(col).get(symbol) == dimension){
            return true;
        }
        else if ( row == col &&
        leftDiagSymbolCounts.get(symbol) == dimension ){
            return true;
        }
        else if( row + col == dimension -1 &&
        rightDiagSymbolCounts.get(symbol) == dimension){
            return true;
        }

        return false;
    }
}
