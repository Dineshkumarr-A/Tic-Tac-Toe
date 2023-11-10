package Strategy;

import Model.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficult(BotDifficultyLevel botDifficultyLevel)
    {
        return new EasyBotPlayingStrategy();
        //We can have if else and then we can able to add multiple difficulty level

    }
}
