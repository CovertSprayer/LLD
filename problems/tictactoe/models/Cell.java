package problems.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private Character value;
    
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = null;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
