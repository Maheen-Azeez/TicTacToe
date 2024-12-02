package models;

import Factories.BotPlayingStrategyFactory;
import Factories.PlayerWinningStrategyFactory;
import exceptions.CellOccupiedException;
import exceptions.InvalidBotCountException;
import exceptions.InvalidPlayerCountException;
import strategies.bot_level_strategies.BotPlayingStrategy;
import strategies.winning_strategies.OrderOneStrategy;
import strategies.winning_strategies.PlayerWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIdx;
    private GameStatus gameStatus;
    private List<Moves> moves;
    private PlayerWinningStrategy playerWinningStrategy;
    private BotPlayingStrategy botPlayingStrategy;

    public int getCurrentPlayerIdx(){
        return currentPlayerIdx;
    }
    public GameStatus getGameStatus(){
        return gameStatus;
    }
    public List<Player> getPlayers(){
        return players;
    }
    public Board getBoard(){
        return board;
    }
    private Game(GameBuilder builder) {
        this.currentPlayerIdx  = 0;
        this.players = builder.players;
        int numberOfPlayers = players.size();
        this.board = new Board(numberOfPlayers + 1);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(BotLevel.EASY);
        this.playerWinningStrategy = PlayerWinningStrategyFactory.getPlayerWinningStrategy(PlayerWinningEvaluation.ORDER_ONE,numberOfPlayers + 1);
    }
    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }
    public static class GameBuilder{
        private List<Player> players;

        public GameBuilder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public Game build(){
            int botCount = 0;
            for(Player player : players){
                if(player instanceof BotPlayer){
                    if(++botCount > 1){
                        throw new InvalidBotCountException("more than one bot found");
                    }

                }
            }
            if(players.size() < 2){
                throw new InvalidPlayerCountException("Expecting at least two players");
            }
            return new Game(this);
        }
    }
    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerIdx);
        Pair<Integer,Integer> cordinates = currentPlayer.makeMove();
        try {
            Cell currentCell = this.board.setPlayer(cordinates.x,cordinates.y,currentPlayer);
            moves.add(new Moves(currentPlayer,currentCell));
            if(playerWinningStrategy.checkIfWon(currentCell)){
                this.gameStatus = GameStatus.WON;
                return;
            }
            if(moves.size() == (players.size()+1) * (players.size()+1)){
                this.gameStatus = GameStatus.DRAW;
                return;
            }
            currentPlayerIdx = ((currentPlayerIdx + 1) % (players.size()));
        } catch (CellOccupiedException e) {
            System.out.println(e.getMessage());
            makeMove();
        }

    }
}
