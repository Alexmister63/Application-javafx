package manager.movement.moveBehavior;

import entity.view_entity.GameVisualElement;
import javafx.scene.Node;
import manager.collide.CollideManager;
import manager.movement.direction.Direction;

public abstract class MoveBehavior {



    public abstract void move(Direction direction, GameVisualElement element);
}
