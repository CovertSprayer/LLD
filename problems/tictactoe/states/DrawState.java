package problems.tictactoe.states;

import problems.tictactoe.models.Game;

public class DrawState implements GameState {

    @Override
    public void play(Game game, int row, int col) {
        System.out.println("Game already ended in a draw. Start a new game to continue.");
    }
}
