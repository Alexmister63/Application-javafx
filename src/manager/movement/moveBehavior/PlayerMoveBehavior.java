package manager.movement.moveBehavior;

import entity.Faces;
import entity.view_entity.GameVisualElement;
import manager.collide.CollideManager;
import manager.movement.direction.PlayerKeyDirection;
import manager.movement.direction.Direction;

import java.util.List;

public class PlayerMoveBehavior extends MoveBehavior {
    @Override
    public void move(Direction direction, GameVisualElement element) {
        PlayerKeyDirection dir = (PlayerKeyDirection) direction;
        List<Faces> faces = (new CollideManager()).testAreaCollide(element);

        if(dir.getLeft() && !faces.contains(Faces.LEFT))element.getN().setLayoutX(element.getN().getLayoutX()-5);
        if(dir.getRight() && !faces.contains(Faces.RIGHT))element.getN().setLayoutX(element.getN().getLayoutX()+5);
        if(dir.getUp() && !faces.contains(Faces.UP))element.getN().setLayoutY(element.getN().getLayoutY()-5);
        if(dir.getDown() && !faces.contains(Faces.DOWN))element.getN().setLayoutY(element.getN().getLayoutY()+5);
    }
}
