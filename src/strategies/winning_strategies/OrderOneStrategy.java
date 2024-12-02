package strategies.winning_strategies;

import models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneStrategy  implements PlayerWinningStrategy{
    List<HashMap<Character,Integer>> rowMaps;
    List<HashMap<Character,Integer>> columnMaps;
    HashMap<Character,Integer> diagonalMap;
    HashMap<Character,Integer> reverseDiagonalMap;
    int size;

    public OrderOneStrategy(int size) {
        this.size = size;
        this.rowMaps = new ArrayList<>();
        for(int i = 0; i < size; i++){
            this.rowMaps.add(new HashMap<>());
        }
        columnMaps = new ArrayList<>();
        for(int i = 0; i < size; i++){
            this.columnMaps.add(new HashMap<>());
        }
        diagonalMap = new HashMap<>();
        reverseDiagonalMap = new HashMap<>();
    }

    @Override
    public boolean checkIfWon(Cell cell) {
        int x = cell.getRow();
        int y = cell.getCol();

        char symbol = cell.getPlayer().getSymbol();
        rowMaps.get(x).put(symbol, rowMaps.get(x).getOrDefault(symbol, 0) + 1);
        columnMaps.get(y).put(symbol, columnMaps.get(y).getOrDefault(symbol, 0) + 1);

        if(checkIfDiagonal(x,y)){
            diagonalMap.put(symbol, diagonalMap.getOrDefault(symbol, 0) + 1);
        }
        if(checkIfReverseDiagonal(x,y)){
            reverseDiagonalMap.put(symbol, diagonalMap.getOrDefault(symbol, 0) + 1);
        }

        if(rowMaps.get(x).get(symbol) == size){
            return true;
        }

        if(columnMaps.get(y).get(symbol) == size){
            return true;
        }

        if(checkIfDiagonal(x,y)){
            return diagonalMap.get(symbol) == size;
        }

        if(checkIfReverseDiagonal(x,y)){
            return reverseDiagonalMap.get(symbol) == size;
        }
        return false;
    }

    private boolean checkIfDiagonal(int x, int y) {
        return x == y;
    }

    private boolean checkIfReverseDiagonal(int x, int y) {
        return x + y == this.size - 1;
    }
}
