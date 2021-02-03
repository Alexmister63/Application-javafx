package entity.view_entity;

import Main.GameEnvironement;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import manager.ElementManager;
import manager.collide.CollideType;
import manager.movement.direction.Direction;
import manager.movement.direction.VectorDirection;
import manager.movement.moveBehavior.LineMovement;
import manager.movement.moveBehavior.MoveBehavior;





public class Projectil extends GameVisualElement {
    private VectorDirection vector;
    protected Projectil(double x,double y,double ax,double ay) {
        super(new LineMovement());
        vector= new VectorDirection(ax,ay);
        Ellipse e = new Ellipse();
        e.setRadiusX(2);
        e.setRadiusY(6);
        e.setFill(Color.RED);
        setN(e);
        getN().setLayoutX(x);
        getN().setLayoutY(y);
        Rectangle rec = new Rectangle();
        rec.setHeight(5);
        rec.setWidth(5);
        rec.layoutYProperty().bindBidirectional(getN().layoutXProperty());
        rec.layoutXProperty().bindBidirectional(getN().layoutXProperty());
        rec.setFill(Color.AQUA);
        setHitbox(rec);

    }

    @Override
    public void whenCollide(CollideType type) {
        switch (type){
            case DISAPPEAR:new ElementManager().removeElement(getN());
                GameEnvironement.getGameEnvironement().getRunningGameStage().addToRemove(this);
                break;
        }
    }

    @Override
    public CollideType onTouch() {
        return CollideType.DAMAGE;
    }

    @Override
    public void move() {
        getMoveBehavior().move(vector,this);
    }
}
