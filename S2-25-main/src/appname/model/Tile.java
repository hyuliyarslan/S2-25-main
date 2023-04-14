package appname.model;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private String color;
    private int player;

    public Tile() {
        this.color = color;
        this.player = player;
    }
    private String getColor() {
        return color;
    }
    private int getPlayer() {
        return player;
    }
    private void setColor(String color) {
        this.color = color;
    }
    private void setPlayer(int player) {
        this.player = player;
    }
    private void amountPlayer() {
        int numPlayers = 6;
        //definition of number of players
        int numTiles = (numPlayers == 2) ? 12 : 6;
        // If there are only two players, use 12 tiles, otherwise use 6
        String[] colors = { "red", "green", "blue", "yellow", "orange", "purple" };
        List<Tile> tiles = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            // For each player in the game
            for (int j = 0; j < numTiles / 2; j++) {
                // For each half of the number of tiles (3 or 6)
                Tile tile = new Tile();
                // Create a new backEnd.Tile object using the j-th color and the i-th player number.
                tiles.add(tile);
                // Add the backEnd.Tile to the ArrayList of tiles.
            }
        }
    }//amountPlayer
}//class
