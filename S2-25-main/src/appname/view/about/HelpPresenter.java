package appname.view.about;

import appname.model.ModelName;
import appname.view.Game.GameView;

public class HelpPresenter {
    private GameView view;
    private ModelName model;

    public HelpPresenter(ModelName model, GameView gameView) {

    }

    public HelpPresenter(GameView view, ModelName model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

//    public GamePresenter(ModelName model, GameView gameView) {
//    }
//
private void addEventHandlers() {
  view.getHomePage().setOnAction(e -> setMyView());
}

    private void setMyView() {



        view.getScene().setRoot(view);

    }

}
