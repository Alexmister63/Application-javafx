package view_controller;

import Main.GameEnvironement;
import controller.Action;
import controller.FrontController;
import entity.PlayerCharactere;
import entity.view_entity.GameVisualElement;
import entity.view_entity.ViewPlayerCharactere;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.ArrayList;
import java.util.List;


public class GameAreaController {
    @FXML
    private AnchorPane gameArea;
    @FXML
    private GridPane grilleDeJeu;
    @FXML
    private Label life;
    private ViewPlayerCharactere player;



    @FXML
    public void initialize(){

        GameEnvironement.getGameEnvironement().setGameArea(gameArea);


        new FrontController(Action.GameStart);

    }



}
