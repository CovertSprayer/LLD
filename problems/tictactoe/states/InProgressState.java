package problems.tictactoe.states;

import problems.tictactoe.enums.GameStatus;
import problems.tictactoe.models.Game;
import problems.tictactoe.models.Player;

public class InProgressState implements GameState {

    @Override
    public void play(Game game, int row, int col) {
        Player currentPlayer = game.getCurrentPlayer();
        boolean success = game.getBoard().makeMove(row, col, currentPlayer.getMarker());

        if (!success) {
            System.out.println("Invalid move!");
            return;
        }

        game.incrementMovesPlayed();
        game.getBoard().printBoard();

        if (game.checkWinner(row, col)) {
            game.setStatus(GameStatus.WIN);
            game.setState(new WonState());
            System.out.println(currentPlayer.getName() + " wins!");
            return;
        }

        if (game.getMovesPlayed() == game.getBoard().getSize() * game.getBoard().getSize()) {
            game.setStatus(GameStatus.DRAW);
            game.setState(new DrawState());
            System.out.println("Game Draw!");
            return;
        }

        game.switchPlayer();
    }
}
