package problems.tictactoe.strategy;

import problems.tictactoe.models.Board;
import problems.tictactoe.models.Cell;

public class ColumnWinningStrategy implements WinningStrategy {

    @Override
    public boolean check(Board board, int row, int col, char mark) {
        Cell[][] grid = board.getGrid();
        int size = board.getSize();

        for(int i=0; i<size; i++) {
            if(grid[i][col].getValue() == null || grid[i][col].getValue() != mark)
                return false;
        }

        return true;
    }
    
}
