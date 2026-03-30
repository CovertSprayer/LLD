package problems.tictactoe.strategy;

import problems.tictactoe.models.Board;

public interface WinningStrategy {
    boolean check(Board board, int row, int col, char mark);
}
