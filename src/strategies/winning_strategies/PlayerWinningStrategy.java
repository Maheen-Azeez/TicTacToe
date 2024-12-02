package strategies.winning_strategies;

import models.Cell;

public interface PlayerWinningStrategy {
    boolean checkIfWon(Cell cell);
}
