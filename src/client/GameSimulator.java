package client;

import contorllers.GameController;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSimulator {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of human players: ");
        int humanCount = scanner.nextInt();
        List<Player> players = new ArrayList<>();

        for(int i = 0; i < humanCount; i++) {
            System.out.println("Enter the name of the player: ");
            String name = scanner.next();

            System.out.println("Enter the symbol of the player: ");
            char symbol = scanner.next().charAt(0);

            players.add(new HumanPlayer(name, symbol));
        }

        while(true) {
            System.out.println("should we allow bots? (Y/N)");
            char response = scanner.next().charAt(0);

            if (response == 'Y') {
                players.add(new BotPlayer("computer",'B'));
                break;
            } else if (response == 'N') {
                System.out.println("No issue.");
                break;
            } else {
                System.out.println("Invalid response. please try again.");
            }
        }

        Game game = gameController.createGame(players);
        gameController.printBoard(game.getBoard());

        while(game.getGameStatus() == GameStatus.IN_PROGRESS) {
            gameController.makeMove(game);
            gameController.printBoard(game.getBoard());
        }

        if(game.getGameStatus() == GameStatus.WON) {
            Player winner = gameController.getWinner(game);
            System.out.println(winner.getName() +" with symbol: " + winner.getSymbol() + " has won");
            gameController.printBoard(game.getBoard());
        }

        if(game.getGameStatus() == GameStatus.DRAW) {
            System.out.println("Game is draw");
        }

//        System.out.println("Do you want to restart the game? (Y/N)");
//        char response = scanner.next().charAt(0);
//        if (response == 'Y') {
//
//        }


    }
}
