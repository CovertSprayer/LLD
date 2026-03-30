package problems.tictactoe.models;

import java.util.List;

import problems.tictactoe.enums.GameStatus;
import problems.tictactoe.states.GameState;
import problems.tictactoe.states.InProgressState;
import problems.tictactoe.strategy.WinningStrategy;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private int movesPlayed;
    private GameState state;
    private final List<WinningStrategy> winningStrategies;

    public Game(Player p1, Player p2, List<WinningStrategy> strategies) {
        this.board = new Board(3);
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.status = GameStatus.IN_PROGRESS;
        this.movesPlayed = 0;
        this.state = new InProgressState();
        this.winningStrategies = strategies;
    }

    public void playMove(int row, int col) {
        state.play(this, row, col);
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean checkWinner(int row, int col) {
        for(WinningStrategy ws: winningStrategies) {
            if(ws.check(board, row, col, currentPlayer.getMarker())) return true;
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getMovesPlayed() {
        return movesPlayed;
    }

    public void incrementMovesPlayed() {
        this.movesPlayed++;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }
}
