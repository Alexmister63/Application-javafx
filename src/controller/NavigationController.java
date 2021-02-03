package controller;

import manager.ViewManager;
import manager.ViewList;

/**
 * <b>controller qui gere les affichages</b>
 * <p>
 *     est apelle par le FrontController
 * </p>
 * @see FrontController
 *
 * @author Bruyere Lucas
 * @version 0.1
 */
public class NavigationController {

    /**
     * gestionnaire des vues
     *
     * @see ViewManager
     * @see ViewList
     */
    ViewManager vm = new ViewManager();

    /**
     * execute l'action recu
     * @param action
     *  action a executer
     * @throws Exception
     *  fait remonter les erreurs liée a l'affichage
     * @see Action
     * @since 0.1
     */
    public NavigationController(Action action)throws Exception{

            switch (action) {
                case goToGame:
                    vm.goToView(ViewList.GameView);
                    break;
                case goToMainMenu:
                    vm.goToView(ViewList.MainMenu);
                    break;
                case close:
                    vm.close();
                    break;
            }
    }


}
