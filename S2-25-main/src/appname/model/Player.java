package appname.model;

public class Player {
    private String name;
    private boolean win;
    private boolean connected;
    private Tile selectedTile;
   
    public Player(String name, boolean win) {
        this.name = name;
        this.win = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }


    public Player() {
        this.selectedTile = null;
    }
/*
    public void placeTile(Tile tile, Board board, int row, int col) {
        if (selectedTile != null && selectedTile.equals(tile)) {
            board.placeTile(tile, row, col);
            selectedTile = null;
        } else {
            System.out.println("You must select a tile first.");
        }
    }

    public void removeTile(Board board, int row, int col) {
        Tile removedTile = board.removeTile(row, col);
        if (removedTile != null) {
            System.out.println("backEnd.Tile removed.");
        } else {
            System.out.println("No tile to remove at (" + row + ", " + col + ")");
        }
    }

    public void selectTile(Tile tile) {
        this.selectedTile = tile;
        System.out.println(tile);
    }

    public void move() {
    }

 */
}//class
