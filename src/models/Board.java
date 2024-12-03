package models;

import exceptions.CellOccupiedException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> grid;

    Board(int numberOfPlayers){
        grid = new ArrayList<>();
        for(int row = 0; row < numberOfPlayers; row++){
            List<Cell> rowCells = new ArrayList<>();
            for(int col = 0; col < numberOfPlayers; col++){
                Cell cell = new Cell(row,col);
                rowCells.add(cell);
            }
            grid.add(rowCells);
        }
    }
    public List<List<Cell>> getGrid(){
        return grid;
    }
    public void printBoard(){
        int matrixSize = this.grid.size();

        for(List<Cell> row : this.grid){
            for(Cell cell : row){
                cell.print();
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public Cell setPlayer(Integer x, Integer y, Player currentPlayer) throws CellOccupiedException {
        Cell cell = grid.get(x).get(y);
        if(cell.getPlayer() == null)
            cell.setPlayer(currentPlayer);
        else{
            throw new CellOccupiedException("cell is already occupied. please choose another one");
        }
        return cell;
    }

    public void undoMove(List<Move> moves) {
        Move lastMove = moves.get(moves.size()-1);
        Cell lastOccupiedCell = lastMove.getCell();
        lastOccupiedCell.setPlayer(null);
        moves.remove(lastMove);
    }
}
