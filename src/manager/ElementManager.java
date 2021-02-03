package manager;

import Main.GameEnvironement;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ElementManager {

    private Pane gameArea;

    public ElementManager(){
        gameArea = GameEnvironement.getGameEnvironement().getGameArea();
    }

    public void addElement(Node n){ gameArea.getChildren().add(n);}
    public void removeElement(Node n){gameArea.getChildren().remove(n);}
    public boolean containElement(Node n){ return gameArea.getChildren().contains(n);   }
}
