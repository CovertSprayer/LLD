package problems.tictactoe;
import java.util.List;

import problems.tictactoe.models.Game;
import problems.tictactoe.models.Player;
import problems.tictactoe.strategy.ColumnWinningStrategy;
import problems.tictactoe.strategy.DiagonalWinningStrategy;
import problems.tictactoe.strategy.RowWinningStrategy;
import problems.tictactoe.strategy.WinningStrategy;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Shreyance", 'X');
        Player p2 = new Player("Rahul", 'O');

        WinningStrategy rowWinningStrategy = new RowWinningStrategy();
        WinningStrategy colWinningStrategy = new ColumnWinningStrategy();
        WinningStrategy diagonalWinningStrategy = new DiagonalWinningStrategy();

        Game game = new Game(p1, p2, List.of(rowWinningStrategy, colWinningStrategy, diagonalWinningStrategy));

        game.playMove(0,0);
        game.playMove(1,0);

        game.playMove(0,1);
        game.playMove(1,1);

        game.playMove(0,2); // Player 1 wins
    }
}
