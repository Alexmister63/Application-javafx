package Main;

import Game.GameStage;
import controller.FrontController;
import entity.view_entity.ViewPlayerCharactere;
import handler.GameKeyState;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view_controller.GameAreaController;


/**
 *<b>GameEnvironement est la classe l'environement de l'application</b>
 * <p>
 *     l'environement contient les info suivantes :
 *     <ul>
 *         <li>l'instance de lui-même pour le récupérer de n'import-ou dans l'application</li>
 *         <li>si l'Environement est charger</li>
 *         <li>le stage(fenêtre) de l'application</li>
 *         <li>la zone de jeu</li>
 *         <li>stage du jeu en cours</li>
 *     </ul>
 * </p>
 *
 * @see Stage
 * @see Pane
 * @see GameStage
 *
 * @author Bruyere Lucas
 * @version 0.1
 */
public class GameEnvironement {
    /**
     * variable contenant l'instance de l'anvironement de l'application
     *
     * @see GameEnvironement#getGameEnvironement()
     * @since 0.1
     */
    private static GameEnvironement INSTANCE;

    /**
     * booleen permettant de savoir si l'environement à était charger
     *
     * @see GameEnvironement#loadGame(Stage)
     * @since 0.1
     */
    private boolean isLoaded;

    /**
     * stage(fenêtre) de l'application
     *
     * @see GameEnvironement#loadGame(Stage)
     * @see GameEnvironement#getAppStage()
     * @since 0.1
     */
    private Stage appStage;


    /**
     * Zone de jeu ou disposer les éléments
     *
     * @see GameEnvironement#getGameArea()
     * @see GameEnvironement#setGameArea(Pane)
     * @since 0.1
     */
    private Pane gameArea;

    /**
     *Donne une zone de jeu a l'application
     *
     * @param gameArea
     *          la nouvelle zone de jeu de l'appli
     * @see GameEnvironement#gameArea
     * @since 0.1
     */
    public void setGameArea(Pane gameArea) {
        this.gameArea = gameArea;
    }


    /**
     * niveau du jeu actuellement charger
     * 
     * @see GameStage
     * @see GameEnvironement#getRunningGameStage() 
     * @see GameEnvironement#setRunningGameStage(GameStage)
     * @since 0.1
     */
    private GameStage runningGameStage;

    /**
     * Retourne le niveau  actuellement charger
     *
     * @return le GameStage courant
     * @see GameStage
     * @since 0.1
     */
    public GameStage getRunningGameStage() {
        return runningGameStage;
    }

    /**
     * charger le niveau dans l'environement
     * @param runningGameStage
     *  le niveau a charger
     * @see GameStage
     * @since 0.1
     */
    public void setRunningGameStage(GameStage runningGameStage) {
        this.runningGameStage = runningGameStage;
    }
    private GameEnvironement(){}

    /**
     * Retourne l'environement de l'appli et l'a creer si elle n'existe pas
     * @return
     * l'instance de l'environement
     * @since 0.1
     */
    public static GameEnvironement getGameEnvironement(){
        if(INSTANCE == null ) INSTANCE= new GameEnvironement();
        return INSTANCE;
    }

    /**
     * charge les instances necessaire pour le demarage de l'appli , methode a appeler des le lancement de l'appli
     * @param stage
     *      le stage a charger
     * @throws RuntimeException
     *      l'environement ne peut pas etre charger 2 fois
     * @see Stage
     * @since 0.1
     */
    public void loadGame(Stage stage)throws RuntimeException{
        if (isLoaded){
            throw new RuntimeException("l'environement ne peut pas etre charger 2 fois");
        }
        appStage = stage;
        FrontController.load();
        GameKeyState.load();
        isLoaded = true;

    }

    /**
     * retourne la fenetre de l'appli
     * @return
     *  le stage de l'appli
     * @since 0.1
     */
    public Stage getAppStage() {
        return appStage;
    }

    /**
     * retourne la zone de jeu de l'appli
     * @return
     * le pane de l'appli
     * @since 0.1
     */
    public Pane getGameArea() {
        return gameArea;
    }


}
