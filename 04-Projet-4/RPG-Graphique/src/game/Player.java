package game;

public class Player {

    private String name;
    private PlayerCast cast;
    private int row; // Add row and column properties
    private int col;

    public Player(String n, PlayerCast c) {
        this.row = 0;
        this.col = 0;
        this.name = n;
        this.cast = c;
    }

    public String getName() {
        return this.name;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
