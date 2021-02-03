package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * <b>class representant un jour</b>
 * <p>
 *     il contient comme attribut :
 *     <ul>
 *         <li>life : nombre de vie du joueur</li>
 *     </ul>
 * </p>
 *
 * @author Bruyere Lucas
 * @version 0.1
 *
 */
public class PlayerCharactere {
    /**
     * nombre de point de vie du joueur
     * @since 0.1
     */
    private int life;

    /**
     * class qui permet de gerer des evenement lors d'un changement dans une Property
     * @see PropertyChangeSupport
     * @since 0.1
     */
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * String qui permettra d'identifier la proprieter lors de l'evenement
     * @since 0.1
     */
    public static final String PROP_LIFE = "prop_life";

    /**
     * constructeur qui creer un joueur avec 3 vie
     *
     * @since 0.1
     */
    public PlayerCharactere(){
        this.life = 3;
    }

    /**
     * constructeur qui creer un joueur avec un nombre de vie donner
     * @param life
     * nombre de vie
     * @since 0.1
     */
    public PlayerCharactere(int life){
        this.life = life;
    }

    /**
     * retourne le nombre de vie actuelle du joueur
     * @return
     * nombre de vie du joueuer
     * @since 0.1
     */
    public int getLife() {
        return life;
    }

    /**
     * change le nombre de point de vie du joueuer et declenche un evenement
     * @param life
     *  nombre de point de vie
     * @since 0.1
     */
    public void setLife(int life) {
        int old = this.life;
        this.life = life;
        support.firePropertyChange(PROP_LIFE,old,this.life);
    }

    public  void addListener(PropertyChangeListener listener){support.addPropertyChangeListener(listener);}
    public void removeListener(PropertyChangeListener listener){support.removePropertyChangeListener(listener);}

}
