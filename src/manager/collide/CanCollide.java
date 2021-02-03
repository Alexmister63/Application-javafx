package manager.collide;

import javafx.scene.Node;

public abstract interface CanCollide {
    void whenCollide(CollideType type);
    CollideType onTouch();


     Node getHitbox();

     void setHitbox(Node hitbox);
}
