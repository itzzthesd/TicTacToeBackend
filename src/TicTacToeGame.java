import Controller.GameController;
import Models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world! welcome to tic tac toe");
        Scanner sc = new Scanner(System.in);

        System.out.println("Put the dimension of the game.");
        int dimension = sc.nextInt();

        System.out.println("Put the no of plaayers of the game.");
        int noOfPlayers = sc.nextInt();

        List<Player> players = new LinkedList<>();

        System.out.println("will there be any bot? y/n");
        String isBot = sc.next();

        if(isBot.equals("y")){
            noOfPlayers = noOfPlayers - 1;

            System.out.println("enter the name of the bot.");
            String botName = sc.next();

            System.out.println("enter the symbol of the bot.");
            String botSymbol = sc.next();

            System.out.println("enter bot difficulty level. level: 1-Easy, 2-Medium, 3-Hard");
            int difficultyLevel = sc.nextInt();

            // create a bot
            players.add(new Bot(botSymbol.charAt(0), botName, BotDifficultyLevel.EASY, PlayerType.BOT));

        }

        for (int i=0;i<noOfPlayers; i++){
            System.out.println("what is the name of the player:" + (i+1));
            String name = sc.next();

            System.out.println("what is the symbol of the player:" + (i+1));
            String symbol = sc.next();

            Player player = new Player(symbol.charAt(0), name,PlayerType.HUMAN);
            players.add(player);

        }
        /*
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayer(players)
                .build();

         */

        GameController gc = new GameController();
        Game game = gc.createGame(dimension, players);

        while(gc.getGamestatus(game) == GameStatus.IN_PROGRESS){
            // todo the play game
            System.out.println("current board:");
            gc.displayBoard(game);

            gc.executeNextMove(game);

            //break;
        }

        if(gc.getGamestatus(game) == GameStatus.DRAW){
            System.out.println("The game is draw");
        }else{
            System.out.println("Game has won by:" + gc.getWinningPlayer(game));
        }


    }
}