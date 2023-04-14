package appname.view.Game;

import appname.model.Board;
import appname.model.Colors;
import appname.model.ModelName;
import appname.view.AppNamePresenter;
import appname.view.AppNameView;
import appname.view.gameIsFinished.gameIsFinishedPresenter;
import appname.view.gameIsFinished.gameIsFinishedView;
import javafx.scene.control.Button;


public class GamePresenter {
    private GameView view;
    private ModelName model;
    private static int countPlayers = 0;
    private static Board board = new Board();
    private boolean starter = true;
    private int switcher;






//    public GamePresenter(ModelName model, GameView gameView) {
//
//    }

    public  GamePresenter(ModelName model,GameView view ) {
        this.view = view;
        this.model = model;
        addEventHandlers();

    }
        //  public GamePresenter(ModelName model, GameView gameView) {
//    }
//
    private void addEventHandlers () {
         final Button person1 = view.getAddPlayer1();
         final Button person2 = view.getAddPlayer2();
         final Button person3 = view.getAddPlayer3();
         final Button person4 = view.getAddPlayer4();
         final Button person5 = view.getAddPlayer5();
         final Button person6 = view.getAddPlayer6();

        view.getHomePage().setOnAction(event -> {
            AppNameView view1 = new AppNameView();
            AppNamePresenter presenter = new AppNamePresenter(model, view1);
            view.getScene().setRoot(view1);
        });
        person1.setOnAction(actionEvent ->
        {
            person1.setVisible(false);
            countPlayers++;
            amountPlayers();
            person3.setDisable(false);
            view.getNameOne().setVisible(true);

        });
        person2.setOnAction(actionEvent ->
        {
            person2.setVisible(false);
            countPlayers++;
            amountPlayers();
            view.getNameTwo().setVisible(true);

        });
        person3.setOnAction(actionEvent ->
        {
            person3.setVisible(false);
            countPlayers++;
            amountPlayers();
            person5.setDisable(false);
            view.getNameThree().setVisible(true);

        });
        person4.setOnAction(actionEvent ->
        {
            person4.setVisible(false);
            countPlayers++;
            amountPlayers();
            person2.setDisable(false);
            view.getNameFour().setVisible(true);
        });
        person5.setOnAction(actionEvent ->
        {
            person5.setVisible(false);
            countPlayers++;
            amountPlayers();
            person6.setDisable(false);
            view.getNameFive().setVisible(true);
        });
        person6.setOnAction(actionEvent ->
        {
            person6.setVisible(false);
            person4.setDisable(false);
            countPlayers++;
            amountPlayers();
            view.getNameSix().setVisible(true);
        });
         view.getStart().setOnAction(actionEvent -> {
             if (view.checkPlayers(countPlayers))
             {

             }
             else {
                 view.getStart().setVisible(false);
                 view.getCurrentColor().setVisible(true);
                 for (int x = 0; x <= 90; x++) {
                     view.getPolygon(x).setDisable(false);
                 }
                 person1.setVisible(false);
                 person2.setVisible(false);
                 person3.setVisible(false);
                 person4.setVisible(false);
                 person5.setVisible(false);
                 person6.setVisible(false);
                 if (view.checkPlayers(countPlayers)) {

                 } else {
                     board.startGame(countPlayers);
                 }
             }

         });
         int sum = 0;
        int counter = 0;

        for (int y = 0; y <= 5;y++)
        {
            int finalY = y;
            for (int x = 0; x <= 5+y;x++)
            {
                int finalX = x;
                int finalSum = sum;
                view.getPolygon(sum).setOnMouseClicked(mouseEvent ->
                {
                    move(finalY, finalX, finalSum);
                });

                sum++;
            }
        }

        for (int y = 6; y <= 10;y++)
        {
            int finalY = y;
            for (int x = 0; x <= 9 - counter;x++)
            {
                int finalX = x;
                int finalSum1 = sum;
                view.getPolygon(sum).setOnMouseClicked(mouseEvent ->
                {
                    move(finalY, finalX, finalSum1);
                });
                sum++;
            }
            counter++;
        }



    }


    public void updateView()
    {
    }

    public void amountPlayers()
    {
        view.getTextField().setText(countPlayers + "/6 players have joined");
    }
    public void move(int x, int y, int hexagonNR)
    {
        Colors colors = view.switchTiles(countPlayers);


        if (!(board.isPlacedNextToTile(x,y)) || starter) {
            if (board.placeTile(colors, x, y)) {
                view.setColor(hexagonNR, colors);
                view.setAllowPopup(true);
            }
            else {
                view.popUp();
            }
        }
        else
        {
            view.popUp();
        }
        view.setAllowPopup(false);
        starter = false;
        finish();
    }
    public void finish() {
        if (board.isConnected()) {
            gameIsFinishedView gameView = new gameIsFinishedView();
            gameIsFinishedPresenter gamePresenter = new gameIsFinishedPresenter(gameView);
            view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().setWidth(400);
            gameView.getScene().getWindow().setHeight(400);

        }

    }

}
