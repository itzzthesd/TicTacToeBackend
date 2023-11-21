package Models;

import Strategy.BotPlayingStrategy;
import Strategy.EasyBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, String botName,
               BotDifficultyLevel botDifficultyLevel,
               PlayerType playerType) {
        super(symbol, botName, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        // todo: better way is to use factory on the bot diff level
        this.botPlayingStrategy = new EasyBotPlayingStrategy();
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }
}
