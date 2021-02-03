package manager.movement.moveBehavior;

import Main.GameEnvironement;
import entity.Faces;
import entity.view_entity.GameVisualElement;
import manager.collide.CollideManager;
import manager.collide.CollideType;
import manager.movement.direction.Direction;
import manager.movement.direction.VectorDirection;

import java.util.List;

public class LineMovement extends MoveBehavior {
    @Override
    public void move(Direction direction, GameVisualElement element) {
        VectorDirection vd = (VectorDirection) direction;
        List<Faces> faces = (new CollideManager()).testAreaCollide(element);
        element.getN().setLayoutY(element.getN().getLayoutY()+vd.getY());
        element.getN().setLayoutX(element.getN().getLayoutX()+vd.getX());
        if(faces.contains(Faces.UP))element.whenCollide(CollideType.DISAPPEAR);
    }
}
