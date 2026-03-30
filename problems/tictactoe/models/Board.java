package problems.tictactoe.models;

public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int n) {
        this.size = n;
        this.grid = new Cell[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean makeMove(int row, int col, char marker) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }

        if(!grid[row][col].isEmpty()) {
            return true;
        }

        grid[row][col].setValue(marker);
        return true;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {

                if(grid[i][j].getValue() == null)
                    System.out.print("- ");
                else
                    System.out.print(grid[i][j].getValue() + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");
    }

    public Cell[][] getGrid() {
        return this.grid;
    }
}
