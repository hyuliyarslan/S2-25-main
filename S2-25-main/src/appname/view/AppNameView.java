package appname.view;

import appname.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;


public class AppNameView extends BorderPane {
	// private Node attributes (controls)
	private Button Start, toLeaderBoard,help,continueGame,quit,back,bti;
	private TextField textArea;
	private Label Exago, welcome,space;

	private Main test = new Main();
	private TextField inputName;
	private Label lblOne;






	public AppNameView() {
		initialiseNodes();
		layoutNodes();
	}

	private void initialiseNodes() {
		// TODO create and configure controls
		// button = new Button("...")
		// label = new Label("...")

		Start = new Button("start");
		toLeaderBoard = new Button("Go to leaderboard");
		help = new Button("help");
		continueGame = new Button("continue");
		quit = new Button("Quit");
		welcome = new Label("Welcome");
		Exago = new Label("EXAGO");
		back = new Button("Go back");
		space = new Label();

		bti = new Button("ter");




		 textArea = new TextField(" Please enter your name");



	}

	private void layoutNodes() {

		lblOne = new Label("Please enter a name");
		lblOne.setStyle("-fx-background-color: lightblue");
		lblOne.setLayoutX(500);
		lblOne.setLayoutY(500);
		inputName = new TextField();
		inputName.setMaxWidth(100);
		inputName.setLayoutX(800);
		inputName.setLayoutY(1200);

		// add/set … methodes
		// Insets, padding, alignment, …
//		add(welcome,300,53);
//		add(Exago,25,300);
//		setAlignment(Pos.TOP_CENTER);
//		quit.setAlignment(Pos.BOTTOM_CENTER);
		HBox hBoxx = new HBox(10);
		VBox vBox = new VBox(10);

		hBoxx.getChildren().addAll(toLeaderBoard);
		vBox.getChildren().addAll(Start,help,quit);
		setTop(welcome);
		setAlignment(welcome,Pos.TOP_CENTER);
//		add(toLeaderBoard, 7, 8);
//		add(Start,41 ,8);
//		add(quit, 400, 800);
//		add(help, 41, 200);
        setCenter(Exago);
		setBottom(vBox);
		setRight(hBoxx);
		setAlignment(vBox,Pos.BOTTOM_LEFT);
		setAlignment(hBoxx,Pos.BOTTOM_RIGHT);

//		gridPane.add(Start,10,0);
//        setTop(welcome);
//		setBottom(Start);
//		setAlignment(Start,Pos.BOTTOM_LEFT);
//		setAlignment(welcome,Pos.TOP_CENTER);
//		setRight(quit);
//		setLeft(toLeaderBoard);
//		setAlignment(toLeaderBoard,Pos.CENTER_LEFT);
//		setAlignment(quit,Pos.BOTTOM_RIGHT);
//		setCenter(hBox);
		bti.setLayoutX(50);
		bti.setLayoutY(50);



		setStyle("-fx-background-color: lightBlue");

		Exago.setFont(Font.font(40));
		welcome.setFont(Font.font(30));
		welcome.setTextFill(Paint.valueOf("white"));
		Exago.setTextFill(Paint.valueOf("white"));
		help.setFont(Font.font(17));
		help.setTextFill(Paint.valueOf("white"));
		toLeaderBoard.setTextFill(Paint.valueOf("white"));
		quit.setTextFill(Paint.valueOf("white"));
		continueGame.setTextFill(Paint.valueOf("white"));
		Start.setTextFill(Paint.valueOf("red"));

		Start.setFont(Font.font(15));
		help.setFont(Font.font(20));
		quit.setFont(Font.font(20));
		toLeaderBoard.setFont(Font.font(20));









	}

	// package-private Getters
	// for controls used by Presenter

	public Button getStart() {
		return Start;
	}

	public Button getToLeaderBoard() {
		return toLeaderBoard;
	}

	public Button getHelp() {
		return help;
	}

	public Button getContinueGame() {
		return continueGame;
	}

	public Button getQuit() {
		return quit;
	}

	public TextField getTextArea() {
		return textArea;
	}

	public Label getExago() {
		return Exago;
	}

	public Label getWelcome() {
		return welcome;
	}


	public Scene getscene() {
		return test.getScene();
	}
}
