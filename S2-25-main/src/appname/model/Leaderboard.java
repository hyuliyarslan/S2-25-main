package appname.model;

public class Leaderboard {
    String name;
    int move;
    int time;
    int amount_players;
    public Leaderboard(String name, int move, int time, int amount_players) {
        this.name = name;
        this.move = move;
        this.time = time;
        this.amount_players = amount_players;
    }
    public Leaderboard()
    {

    }

    // USER game PASS '7sur7' port: 5432

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAmount_players() {
        return amount_players;
    }

    public void setAmount_players(int amount_players) {
        this.amount_players = amount_players;
    }

    public void showLeaderboard(){

    }


}
