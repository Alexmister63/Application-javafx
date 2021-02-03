package Main;

import controller.Action;
import controller.FrontController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        GameEnvironement.getGameEnvironement().loadGame(stage);
        stage.setTitle("space shooter");
       new FrontController(Action.goToMainMenu);
    }

}
