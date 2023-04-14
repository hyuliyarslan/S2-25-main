package appname;

import appname.model.ModelName;
import appname.view.AppNamePresenter;
import appname.view.AppNameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public Scene getScene() {
		return scene;
	}

	private Scene scene;

	@Override
	public void start(Stage primaryStage) {
		ModelName model = new ModelName();
		AppNameView view = new AppNameView();
		AppNameView view2 = new AppNameView();
		AppNamePresenter presenter = new AppNamePresenter(model, view);

		scene = new Scene(view);

		String  style= getClass().getResource("javafx.css").toExternalForm();
		scene.getStylesheets().add(style);

		primaryStage.setTitle("Exago");
		primaryStage.setHeight(500);
		primaryStage.setWidth(750);
		primaryStage.getIcons().add(new Image("/images/exago.jpg"));


		primaryStage.setScene(scene);
		// window event handlers are added in MVP V2 (module 4)
		presenter.addWindowEventHandlers();
		primaryStage.show();
	}



}