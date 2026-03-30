package problems.tictactoe.states;

import problems.tictactoe.models.Game;

public class WonState implements GameState {

    @Override
    public void play(Game game, int row, int col) {
        System.out.println("Game already has a winner. Start a new game to continue.");
    }
}
