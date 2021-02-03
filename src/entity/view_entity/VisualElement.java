package entity.view_entity;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;




public abstract class VisualElement {
    private Node n;

    public VisualElement(){
        Rectangle rec = new Rectangle();
        rec.setHeight(50);
        rec.setWidth(50);
        rec.setFill(Color.BLACK);
        n=rec;
    }

    public VisualElement(Node n){
        this.n = n;
    }

    public Node getN() {
        return n;
    }

    public void setN(Node n) {
        this.n = n;
    }
}
