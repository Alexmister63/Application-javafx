package entity.view_entity;

import javafx.scene.Node;
import manager.collide.CanCollide;
import manager.movement.CanMove;
import manager.movement.moveBehavior.MoveBehavior;

public abstract class GameVisualElement extends VisualElement implements CanCollide, CanMove {
    private Node hitbox;
    private MoveBehavior moveBehavior;

    protected GameVisualElement(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public Node getHitbox() {
        return hitbox;
    }

    @Override
    public void setHitbox(Node hitbox) {
        this.hitbox = hitbox;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }
}
