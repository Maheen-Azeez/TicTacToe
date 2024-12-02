package strategies.bot_level_strategies;

import models.Pair;

public interface BotPlayingStrategy {
    Pair<Integer,Integer> makeMove();
}
