package problems.tictactoe.strategy;

import problems.tictactoe.models.Board;
import problems.tictactoe.models.Cell;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean check(Board board, int row, int col, char mark) {
        Cell[][] grid = board.getGrid();
        int size = board.getSize();

        for(int i=0; i<size; i++) {
            if(grid[row][i].getValue() == null || grid[row][i].getValue() != mark)
                return false;
        }

        return true;
    }
    
}
