package problems.tictactoe.models;

import problems.tictactoe.enums.GameStatus;
import problems.tictactoe.states.GameState;
import problems.tictactoe.states.InProgressState;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private int movesPlayed;
    private GameState state;

    public Game(Player p1, Player p2) {
        this.board = new Board(3);
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.status = GameStatus.IN_PROGRESS;
        this.movesPlayed = 0;
        this.state = new InProgressState();
    }

    public void playMove(int row, int col) {
        state.play(this, row, col);
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean checkWinner(int row, int col) {
        Cell[][] grid = board.getGrid();
        char mark = currentPlayer.getMarker();
        int size = board.getSize();

        boolean winRow = true;
        boolean winCol = true;
        boolean winDiag = true;
        boolean winAntiDiag = true;

        for(int i = 0; i < size; i++) {

            if(grid[row][i].getValue() == null || grid[row][i].getValue() != mark)
                winRow = false;

            if(grid[i][col].getValue() == null || grid[i][col].getValue() != mark)
                winCol = false;

            if(grid[i][i].getValue() == null || grid[i][i].getValue() != mark)
                winDiag = false;

            if(grid[i][size - 1 - i].getValue() == null || grid[i][size - 1 - i].getValue() != mark)
                winAntiDiag = false;
        }

        return winRow || winCol || winDiag || winAntiDiag;
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
