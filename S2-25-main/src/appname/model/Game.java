package appname.model;

public class Game {
    private Player player = new Player();
    private Board board = new Board();
    private Leaderboard leaderboard = new Leaderboard();
    private Graphic graphic = new Graphic();



    public Game (){

    }

    public void playGame()
    {
      //  board.createBoard();
        initializeVisuals();
        showLeaderboard();

    }
    public void initializeVisuals()
    {
        graphic.ShowGraphics();
    }
    public void showLeaderboard(){
        leaderboard.showLeaderboard();
    }

}
