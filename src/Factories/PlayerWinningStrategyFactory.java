package Factories;

import models.PlayerWinningEvaluation;
import strategies.winning_strategies.IterationStrategy;
import strategies.winning_strategies.OrderOneStrategy;
import strategies.winning_strategies.PlayerWinningStrategy;

public class PlayerWinningStrategyFactory {
    public static PlayerWinningStrategy getPlayerWinningStrategy(PlayerWinningEvaluation evaluationType, int size) {
        return  switch(evaluationType){
            case ITERATIVE -> new IterationStrategy();
            case ORDER_ONE -> new OrderOneStrategy(size);
        };
    }
}
