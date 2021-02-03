package view_controller;

import controller.Action;
import controller.FrontController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainViewController {
    @FXML
    private GridPane menuArea;


    @FXML
    public void initialize(){
        menuArea.getStylesheets().add(getClass().getResource("/css/mainMenu.css").toExternalForm());
    }


    public void play(ActionEvent actionEvent) {
        new FrontController(Action.goToGame);
    }

    public void quit(ActionEvent actionEvent) {
        new FrontController(Action.close);
    }
}

