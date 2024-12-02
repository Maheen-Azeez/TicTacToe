package models;

public class Cell {
    private int row;
    private int col;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void print() {
        if(this.player != null){
            System.out.print(" " + this.player.getSymbol() + " ");
        }
        else {
            System.out.print(" _ ");
        }
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player currentPlayer) {
        this.player = currentPlayer;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
}
