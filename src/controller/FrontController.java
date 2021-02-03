package controller;

import java.util.*;

/**
 * <b>le FrontController et la class qui repartis les actions entre les different controller a l'apelle du constructeur</b>
 * <p>
 *  Le FrontController permet d'envoyer une action au bon controller et permet de faire des vérification si besoin . elle permet aussi de gerer les Exception
 * </p>
 *
 * @see GameController
 * @see NavigationController
 * @see Action
 *
 * @author Bruyere Lucas
 * @version 0.1
 */

public class FrontController {

    /**
     * dictionnaire des actions par controller
     *
     * @see FrontController#load()
     * @see ControllerType
     * @see FrontController#FrontController(Action)
     * @since 0.1
     */
    private static Map<ControllerType, Set<Action>> controllers = new HashMap<>();

    /**
     * constructeur du FrontController envoie une action au bon controller en fonction du contenu de controllers
     *
     * @param action
     *  Action a effectuer parmi celle disponible
     * @see FrontController#controllers
     * @see ControllerType
     * @see Action
     *
     * @since 0.1
     */
   public FrontController(Action action){

       try{
            if(controllers.get(ControllerType.navigationController).contains(action))
                new NavigationController(action);
            if(controllers.get(ControllerType.gameController).contains(action))
                new GameController(action);
       }
       catch (Exception e){
           System.err.println(e.getMessage());
       }

   }

    /**
     * permet de charger les Actions et les controllers .cette fonction et appeler lors du chargement de l'environement
     *
     * @see FrontController#controllers
     * @see ControllerType
     * @see Main.GameEnvironement
     *
     * @since 0.1
     */
   public static void load(){
        Set<Action> viewAction = new HashSet<>();
        viewAction.add(Action.goToGame);
        viewAction.add(Action.goToMainMenu);
        viewAction.add(Action.close);
        controllers.put(ControllerType.navigationController,viewAction);
       Set<Action> gameAction = new HashSet<>();
       gameAction.add(Action.GameStart);
       controllers.put(ControllerType.gameController,gameAction);

   }

    /**
     * <b>Liste des Controllers</b>
     * <p>
     *     pour le moment elle contient
     *     <ul>
     *         <li>navigationController : Controller qui a pour but de faire la transition entre les interfaces de l'appli</li>
     *         <li>goToMainMenu : Controller qui a pour but de gerer les actions liées au jeu </li>
     *     </ul>
     * </p>
     * <p>
     *     la Liste peux etre etendu si besoin,
     * </p>
     *
     * @see FrontController
     * @see GameController
     * @see NavigationController
     *
     * @version 0.1
     * @author Bruyere Lucas
     *
     */
   private enum ControllerType{
        navigationController,
       gameController
    }
}
