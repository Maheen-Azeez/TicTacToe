package models;

import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Pair<Integer,Integer> makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("its " + this.getName() + "'s turn. please make a move.");
        System.out.println("Enter row index: ");
        int row = sc.nextInt();
        System.out.println("Enter column index: ");
        int col = sc.nextInt();
        return new Pair<>(row,col);
    }
}
