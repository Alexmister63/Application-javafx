package controller;

/**
 * <b>Liste des actions possible depuis les vues</b>
 * <p>
 *     pour le moment elle contient
 *     <ul>
 *         <li>goToGame : Permet d'afficher la vue du jeu</li>
 *         <li>goToMainMenu : Permet d'afficher le menu principal </li>
 *         <li>close: fermet l'appli</li>
 *         <li>GameStart : lance le jeu</li>
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
public enum Action {
    goToGame,
    goToMainMenu,
    close,
    GameStart
}
