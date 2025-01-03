package Strategy;

import Models.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {

        for(int i=0;i< board.getBoard().size(); i++){
            for(int j=0; j<board.getBoard().size(); j++ ){
                if(board.getBoard().get(i).get(j).getCellstate() == CellState.EMPTY){
                    return new Move(player, new Cells(i,j));
                }
            }
        }
        return null;
    }
}
