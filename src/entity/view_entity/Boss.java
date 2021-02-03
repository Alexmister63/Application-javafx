package entity.view_entity;

import manager.collide.CollideType;
import manager.movement.moveBehavior.MoveBehavior;

public class Boss extends GameVisualElement {
    protected Boss(MoveBehavior moveBehavior) {
        super(moveBehavior);
    }

    @Override
    public void whenCollide(CollideType type) {

    }

    @Override
    public CollideType onTouch() {
        return null;
    }

    @Override
    public void move() {

    }
}
