package problems.tictactoe.states;

import problems.tictactoe.models.Game;

public interface GameState {
    void play(Game game, int row, int col);
}
