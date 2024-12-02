package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BotPlayer extends Player {

    public BotPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Pair<Integer,Integer> makeMove() {
        return null;
    }
}
