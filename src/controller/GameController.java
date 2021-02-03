package controller;

import Main.GameEnvironement;
import entity.view_entity.GameVisualElement;
import entity.view_entity.ViewPlayerCharactere;
import manager.GameManager;
import manager.ViewList;
import manager.ViewManager;

import java.util.List;

/**
 * <b>controller qui gere les foncionnalité du jeux</b>
 * <p>
 *     est apelle par le FrontController
 * </p>
 * @see FrontController
 *
 * @author Bruyere Lucas
 * @version 0.1
 */
public class GameController {

    /**
     * gestionnaire de jeu
     *
     * @see GameManager
     */
    private static GameManager gm = new GameManager();

    /**
     * execute l'action recu
     * @param action
     *  action a executer
     * @throws Exception
     *  fait remonter les erreurs liée au jeu
     * @see Action
     * @since 0.1
     */
    public GameController(Action action)throws Exception{
        switch (action){
            case GameStart:
               gm.load();
                break;
        }
    }

}
