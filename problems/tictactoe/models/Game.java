package problems.tictactoe.models;

import problems.tictactoe.enums.GameStatus;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private int movesPlayed;

    public Game(Player p1, Player p2) {
        this.board = new Board(3);
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
        this.status = GameStatus.IN_PROGRESS;
        this.movesPlayed = 0;
    }

    public void playMove(int row, int col) {
        boolean success = board.makeMove(row, col, currentPlayer.getMarker());

        if(!success) {
            System.out.println("Invalid move!");
            return;
        }

        this.movesPlayed++;

        board.printBoard();

        if(checkWinner(row, col)) {
            status = GameStatus.WIN;
            System.out.println(currentPlayer.getName() + " wins!");
            return;
        }

        if(this.movesPlayed == 9) {
            status = GameStatus.DRAW;
            System.out.println("Game Draw!");
            return;
        }

        switchPlayer();
    }

    private void switchPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean checkWinner(int row, int col) {
        Cell[][] grid = board.getGrid();
        char mark = currentPlayer.getMarker();

        boolean winRow = true;
        boolean winCol = true;
        boolean winDiag = true;
        boolean winAntiDiag = true;

        for(int i=0;i<3;i++) {

            if(grid[row][i].getValue() == null || grid[row][i].getValue() != mark)
                winRow = false;

            if(grid[i][col].getValue() == null || grid[i][col].getValue() != mark)
                winCol = false;

            if(grid[i][i].getValue() == null || grid[i][i].getValue() != mark)
                winDiag = false;

            if(grid[i][2-i].getValue() == null || grid[i][2-i].getValue() != mark)
                winAntiDiag = false;
        }

        return winRow || winCol || winDiag || winAntiDiag;
    }

}
