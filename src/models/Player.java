package models;


public abstract class Player {
    protected String Name;
    protected char Symbol;

    public Player(String name, char symbol) {
        this.Name = name;
        this.Symbol = symbol;
    }
    public String getName() {
        return Name;
    }
    public char getSymbol() {
        return Symbol;
    }
    public  abstract Pair<Integer,Integer> makeMove();
}
