package appname.view;


import appname.model.Game;
import appname.model.Leaderboard;
import appname.model.ModelName;
import appname.view.Game.GamePresenter;
import appname.view.Game.GameView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.text.Text;
import javafx.stage.Window;

import java.io.Closeable;

public class AppNamePresenter {
  final private ModelName model;
  final private AppNameView view;
  private Parent HelpView;
  private String inputName;
  private GameView gameView = new GameView();

  public AppNamePresenter(ModelName model, AppNameView view) {
    this.model = model;
    this.view = view;
    addEventHandlers();
    updateView();

  }

  private void addEventHandlers() {
    view.getQuit().setOnAction(e -> {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You are about to quit the game!");
        alert.setContentText("Do you really want to leave?");
        alert.setTitle("Quit Exago backEnd.Game!");
        alert.getButtonTypes().clear();
        ButtonType no = new ButtonType("NO");
        ButtonType yes = new ButtonType("YES");
        alert.getButtonTypes().addAll(no, yes);
        alert.showAndWait();
        if (alert.getResult() == null || alert.getResult().equals(no)) {
//          event.consume();
        } view.getScene().getWindow().hide();

    });
    view.getStart().setOnAction(e ->{
            askName();
  });
//   view.getHelp().setOnAction(e -> setHelpView());
//    view.getScene().getWindow().setOnCloseRequest(event -> closeApplication(event));
//    view.getToLeaderBoard().setOnAction(e -> setLeaderBoarView);




   // });


    /* event handlers that change the underlying data
    first update the model
    and then call updateView()

     */

//    Stage AlertBox = new Stage();
//    AlertBox.initOwner(view.getScene().getWindow());
//    AlertBox.initModality(Modality.APPLICATION_MODAL);
//        addWindowEventHandlers();

  }


  private void setGameView(){
    GameView gameView = new GameView();
    GamePresenter gamePresenter = new GamePresenter(model,gameView);
    view.getScene().setRoot(gameView);
    gameView.getScene().getWindow().setWidth(500);



  }

//  private void setHelpView(){
//    HelpView helpView = new HelpView();
//    HelpPresenter HelpPresenter = new HelpPresenter(model,helpView);
//    view.getScene().setRoot(HelpView);
//    HelpView.getScene().getWindow().setHeight(500);




  private void updateView() {
    // TODO fill the view with model data
  }

  public void addWindowEventHandlers() {
    Window window = view.getScene().getWindow();
    //TODO  add  event handlers to window
    view.getScene().getWindow().setOnCloseRequest(event -> closeApplication(event));

  }

  public void quitApplication(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("You are about to quit the game!");
    alert.setContentText("Do you really want to leave?");
    alert.setTitle("Quit Oware backEnd.Game!");
    alert.getButtonTypes().clear();
    ButtonType no = new ButtonType("NO");
    ButtonType yes = new ButtonType("YES");
    alert.getButtonTypes().addAll(no, yes);
    alert.showAndWait();
    if (alert.getResult() == null || alert.getResult().equals(no)) {
      event.consume();
    } view.getScene().getWindow().hide();
  }

  public void closeApplication(Event event) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setHeaderText("You are about to quit the game!");
    alert.setContentText("Do you really want to go back. your progress may be lost!!");
    alert.setTitle("warning!");
    alert.getButtonTypes().clear();
    ButtonType no = new ButtonType("NO");
    ButtonType yes = new ButtonType("YES");
    alert.getButtonTypes().addAll(no, yes);
    alert.showAndWait();
    if (alert.getResult() == null || alert.getResult().equals(no)) {
      event.consume();
    }
  }

  public void askName()
  {
    TextInputDialog name = new TextInputDialog("Please enter your name:");
    name.setHeaderText("Please enter your name down below");
    name.showAndWait();
    inputName = name.getEditor().getText();
    gameView.setName(inputName);
    setGameView();

  }



}
