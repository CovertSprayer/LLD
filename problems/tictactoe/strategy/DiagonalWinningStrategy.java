package problems.tictactoe.strategy;

import problems.tictactoe.models.Board;
import problems.tictactoe.models.Cell;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean check(Board board, int row, int col, char mark) {
        Cell[][] grid = board.getGrid();
        int size = board.getSize();

        boolean winDiag = true;
        boolean winAntiDiag = true;

        for(int i=0; i<size; i++) {
            if(grid[i][i].getValue() == null || grid[i][i].getValue() != mark)
                winDiag = false;

            if(grid[i][size - 1 - i].getValue() == null || grid[i][size - 1 - i].getValue() != mark)
                winAntiDiag = false;
        }

        return winDiag || winAntiDiag;
    }
    
}
