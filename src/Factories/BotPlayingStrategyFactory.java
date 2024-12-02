package Factories;

import models.BotLevel;
import strategies.bot_level_strategies.BotPlayingStrategy;
import strategies.bot_level_strategies.EasyLevelStrategy;
import strategies.bot_level_strategies.HardLevelStrategy;
import strategies.bot_level_strategies.MediumLevelStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotLevel botLevel){
        return switch (botLevel){
            case EASY -> new EasyLevelStrategy();
            case MEDIUM -> new MediumLevelStrategy();
            case HARD -> new HardLevelStrategy();
        };
    }
}
