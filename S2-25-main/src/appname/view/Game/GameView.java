package appname.view.Game;


import appname.model.Colors;
import appname.model.ModelName;
import appname.view.AppNamePresenter;
import appname.view.AppNameView;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.control.Button;
import javafx.scene.shape.StrokeType;


public class GameView extends BorderPane {
    private Button homePage;
    private Button addPlayer1;
    private Button addPlayer2;
    private Button addPlayer3;
    private Button addPlayer4;
    private Button addPlayer5;
    private Button addPlayer6;
    private Button nameOne;
    private Button nameTwo;
    private Button nameThree;
    private Button nameFour;
    private Button nameFive;
    private Button nameSix;
    private boolean allowPopup = false;
    private Button currentColor;
    private final int MAX_ROWS = 5;
    private int columns = 5,counter = 0;
    private double ver = 35,addX = 17.5,startY = 200,startX = 650;
    private static int switcher = 1;
    private Button start;
    private TextField textField = new TextField("0/6 players have joined");
    private int players = 0;
    private Polygon[] polygon = new Polygon[97];


    public GameView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {

        homePage = new Button("Home Page");
        currentColor = new Button("RED's turn");
        currentColor.setVisible(false);
        addPlayer1 = new Button("add a player");
        addPlayer2 = new Button("add a player");
        addPlayer3 = new Button("add a player");
        addPlayer4 = new Button("add a player");
        addPlayer5 = new Button("add a player");
        addPlayer6 = new Button("add a player");
        addPlayer1.setId("allbtn");
        addPlayer2.setId("allbtn");
        addPlayer3.setId("allbtn");
        addPlayer4.setId("allbtn");
        addPlayer5.setId("allbtn");
        addPlayer6.setId("allbtn");
        start = new Button("Start game");
        start.setId("allbtn");
        addPlayer2.setDisable(true);
        addPlayer3.setDisable(true);
        addPlayer4.setDisable(true);
        addPlayer5.setDisable(true);
        addPlayer6.setDisable(true);
        nameOne = new Button("Player one");
        nameTwo = new Button("Player six");
        nameThree = new Button("Player two");
        nameFour = new Button("Player five");
        nameFive = new Button("Player three");
        nameSix = new Button("Player four");
        nameOne.setVisible(false);
        nameTwo.setVisible(false);
        nameThree.setVisible(false);
        nameFour.setVisible(false);
        nameFive.setVisible(false);
        nameSix.setVisible(false);
        makeHexagon(20,Color.WHITESMOKE);


    }


    private void layoutNodes() {
        addPlayer1.setStyle("-fx-background-color: White;");
        addPlayer2.setStyle("-fx-background-color: White");
        addPlayer3.setStyle("-fx-background-color: White");
        addPlayer4.setStyle("-fx-background-color: White");
        addPlayer5.setStyle("-fx-background-color: White");
        addPlayer6.setStyle("-fx-background-color: White");
        nameOne.setStyle("-fx-background-color: lightBlue;");
        nameFive.setStyle("-fx-background-color: lightBlue;");
        nameThree.setStyle("-fx-background-color: lightBlue;");
        nameTwo.setStyle("-fx-background-color: lightBlue;");
        nameFour.setStyle("-fx-background-color: lightBlue;");
        nameSix.setStyle("-fx-background-color: lightBlue;");
        currentColor.setStyle("-fx-background-color: lightBlue; -fx-font-size: 24px");




        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(homePage);
        setTop(hBox1);
        setStyle("-fx-background-color: lightBlue");
        counter = 0;
       for (int x = 0; x<= MAX_ROWS;x++)
        {
            for (int y = 0; y<= columns;y++ )
            {
                polygon[counter].setLayoutX(startX + (ver * y));
                polygon[counter].setLayoutY(startY);
                counter++;
            }
            columns++;
            startX = startX - addX;
            startY = startY + 30;
        }

        columns = 9;
        startX = startX + 2 * addX;


        for (int x = 0; x<= MAX_ROWS - 1;x++)
        {
            for (int y = 0; y <= columns; y++)
            {
                polygon[counter].setLayoutX(startX + (ver * y));
                polygon[counter].setLayoutY(startY);
                counter++;
            }
            startX = startX + addX;
            startY = startY + 30;
            columns--;

        }

        // BUTTONS FOR PLAYERS TO ADD

        polygon[91].setLayoutX(495);
        polygon[91].setLayoutY(230);
        addPlayer1.setLayoutX(460);
        addPlayer1.setLayoutY(275);
        nameOne.setLayoutX(460);
        nameOne.setLayoutY(275);


        polygon[92].setLayoutX(495);
        polygon[92].setLayoutY(450);
        addPlayer2.setLayoutX(460);
        addPlayer2.setLayoutY(495);
        nameTwo.setLayoutX(460);
        nameTwo.setLayoutY(495);


        polygon[93].setLayoutX(735);
        polygon[93].setLayoutY(90);
        addPlayer3.setLayoutX(700);
        addPlayer3.setLayoutY(135);
        nameThree.setLayoutX(700);
        nameThree.setLayoutY(135);

        currentColor.setLayoutY(5);
        currentColor.setLayoutX(650);

        polygon[94].setLayoutX(735);
        polygon[94].setLayoutY(550);
        addPlayer4.setLayoutX(700);
        addPlayer4.setLayoutY(595);
        nameFour.setLayoutX(700);
        nameFour.setLayoutY(595);

        polygon[95].setLayoutX(950);
        polygon[95].setLayoutY(230);
        addPlayer5.setLayoutX(915);
        addPlayer5.setLayoutY(275);
        nameFive.setLayoutX(915);
        nameFive.setLayoutY(275);



        polygon[96].setLayoutX(950);
        polygon[96].setLayoutY(450);
        addPlayer6.setLayoutX(915);
        addPlayer6.setLayoutY(495);
        nameSix.setLayoutX(915);
        nameSix.setLayoutY(495);



        textField.setLayoutX(1200);
        textField.setLayoutY(5);
        textField.setEditable(false);
        textField.setStyle("-fx-background-color: lightBlue; -fx-font-size: 20px");

        start.setLayoutY(700);
        start.setLayoutX(700);
        start.setStyle("-fx-font-size: 16px");

        for (int x = 0; x<=90;x++) {
            polygon[x].setDisable(true);
        }


        Pane pane = new Pane();
        pane.getChildren().addAll(polygon);
        pane.getChildren().addAll(currentColor,addPlayer1,addPlayer2,addPlayer3,addPlayer4,addPlayer5,addPlayer6,textField,start,nameOne,nameFive,nameThree,nameTwo,nameFour,nameSix);
        setCenter(pane);






    }

//
//    place for the getters
//


    public Button getHomePage() {
        return homePage;
    }

    public Button getAddPlayer1() {
        return addPlayer1;
    }

    public Button getAddPlayer2() {
        return addPlayer2;
    }

    public Button getAddPlayer3() {
        return addPlayer3;
    }

    public Button getAddPlayer4() {
        return addPlayer4;
    }

    public Button getAddPlayer5() {
        return addPlayer5;
    }
    public int getSwitcher() {
        return switcher;
    }

    public void setSwitcher(int switcher) {
        GameView.switcher = switcher;
    }

    public Button getAddPlayer6() {
        return addPlayer6;
    }


        private double radianStep = (2 * Math.PI) / 6;


        private void makeHexagon(double radius, Paint color) {
           for (int x = 0; x<= 96;x++)
            {
                polygon[x] = new Polygon();
                this.getChildren().add(polygon[x]);
                polygon[x].setFill(color);
                polygon[x].setStroke(Color.DIMGRAY);
                polygon[x].setStrokeWidth(1);
                polygon[x].setStrokeType(StrokeType.INSIDE);


                for (int i = 0; i < 6; i++) {
                    double angle = radianStep * i;
                    polygon[x].getPoints().add(Math.sin(angle) * radius / 1.1);
                    polygon[x].getPoints().add(Math.cos(angle) * radius / 1.1);
                }
            }
            polygon[91].setFill(Color.RED);
            polygon[92].setFill(Color.GREEN);
            polygon[93].setFill(Color.PURPLE);
            polygon[94].setFill(Color.ORANGE);
            polygon[95].setFill(Color.YELLOW);
            polygon[96].setFill(Color.BLUE);

        }
    public Polygon getPolygon(int x) {
        return polygon[x];
    }
    public void setColor(int y,Colors x)
    {
        Color color = Color.WHITESMOKE;

        if (x == Colors.GREEN)
        {
            color = Color.GREEN;
        }
        if (x == Colors.RED)
        {
            color = Color.RED;
        }
        if (x == Colors.YELLOW)
        {
            color = Color.YELLOW;
        }
        if (x == Colors.PURPLE)
        {
            color = Color.PURPLE;
        }
        if (x == Colors.BLUE)
        {
            color = Color.BLUE;
        }
        if (x == Colors.ORANGE)
        {
            color = Color.ORANGE;
        }


        polygon[y].setFill(color);
    }
    public Colors switchTiles(int amount)
    {
        Colors color = Colors.NONE;
        showColor(amount,switcher);
        players = amount;
        switch (switcher) {
                    case 1:
                        color = Colors.RED;
                        break;
                    case 2:
                        color = Colors.PURPLE;
                        break;
                    case 3:
                        color = Colors.YELLOW;
                        break;
                    case 4:
                        color = Colors.BLUE;
                        break;
                    case 5:
                        color = Colors.ORANGE;
                        break;
                    case 6:
                        color = Colors.GREEN;
                        break;
                }
                if (switcher == players)
                {
                        switcher = 1;
                }
                else {
                    switcher++;
                }


            return color;
        }

        public void showColor(int players,int switcher)
        {
            String color = "";

            if (switcher == 1)
            {
                color = "PURPLE's turn";
            }

                switch (players)
                {
                    case 2:
                              if (switcher == 2)
                              {
                                  color = "RED's turn";
                              }
                              break;
                    case 3:
                        if (switcher == 2)
                        {
                            color = "YELLOW's turn";
                        }
                        if (switcher == 3)
                        {
                            color = "RED's turn";
                        }
                        break;
                    case 4:
                        if (switcher == 2)
                        {
                            color = "YELLOW's turn";
                        }
                        if (switcher == 3)
                        {
                            color = "BLUE's turn";
                        }
                        if (switcher == 4)
                        {
                            color = "RED's turn";
                        }
                        break;
                    case 5:
                        if (switcher == 2)
                        {
                             color = "YELLOW's turn";
                        }
                        if (switcher == 3)
                        {
                           color = "BLUE's turn";
                        }
                        if (switcher == 4)
                        {
                            color = "ORANGE's turn";
                        }
                        if (switcher == 5)
                        {
                            color = "RED's turn";
                        }
                        break;
                    case 6:
                        if (switcher == 2)
                        {
                            color = "YELLOW's turn";
                        }
                        if (switcher == 3)
                        {
                            color = "BLUE's turn";
                        }
                        if (switcher == 4)
                        {
                            color = "ORANGE's turn";
                        }
                        if (switcher == 5)
                        {
                             color  = "GREEN's turn";
                        }
                        if (switcher == 6)
                        {
                            color = "RED's turn";
                        }
                        break;
                }
            currentColor.setText(color);
        }



    public TextField getTextField() {
        return textField;
    }
    public void popUp()
    {
        int test= 0;
        if (switcher == 1)
        {
            switcher = players;
            test = 1;
        }
        else {
            switcher--;
            test = switcher++;
        }



        showColor(players,test);
        allowPopup = true;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You're making an illegal move!");
        alert.setContentText("Try to place the tile on an empty square AND make sure it's connected");
        alert.setTitle("Warning!");
        alert.showAndWait();
    }
    public Button getStart() {
        return start;
    }
    public boolean checkPlayers(int amountPlayers)
    {
        if (amountPlayers <= 1)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("You need atleast 2 players to play the game!");
            alert.setContentText("Play with atleast 2 players in order to play!");
            alert.setTitle("Warning!");
            alert.showAndWait();
            return true;
        }
        else
        {
            return false;
        }
    }
    public Button getNameOne() {
        return nameOne;
    }

    public Button getNameTwo() {
        return nameTwo;
    }

    public Button getNameThree() {
        return nameThree;
    }

    public Button getNameFour() {
        return nameFour;
    }

    public Button getNameFive() {
        return nameFive;
    }

    public Button getNameSix() {
        return nameSix;
    }

    public Button getCurrentColor() {
        return currentColor;
    }
    public boolean isAllowPopup() {
        return allowPopup;
    }

    public void setAllowPopup(boolean allowPopup) {
        this.allowPopup = allowPopup;
    }
    public void setName(String name)
    {

    }





}






