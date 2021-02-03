package entity.view_entity;

import entity.PlayerCharactere;
import handler.GameKey;
import handler.GameKeyState;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.IntegerStringConverter;
import manager.ElementManager;
import manager.collide.CollideType;
import manager.movement.direction.PlayerKeyDirection;
import manager.movement.moveBehavior.PlayerMoveBehavior;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ViewPlayerCharactere extends GameVisualElement implements PropertyChangeListener {
    private PlayerCharactere player;

    private StringProperty lifeStringFormat;
    private IntegerProperty lifeIntFormat;
    public int getLife(){return lifeIntFormat.get();}

    public IntegerProperty lifeIntFormat(){return lifeIntFormat;}
    public StringProperty lifeStringFormat(){return lifeStringFormat;}

    public void setLifeStringFormat(int life){this.lifeStringFormat.set(new IntegerStringConverter().toString(life));}
    public void setLifeIntFormat(int life){this.lifeIntFormat.set(life);}


    public ViewPlayerCharactere(PlayerCharactere player){
        super(new PlayerMoveBehavior());

       ImageView iv = new ImageView(new Image(String.valueOf(getClass().getResource("/image/B-26b.png"))));
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        setN(iv);
        setHitbox(createHitbox());
        this.player = player;
        this.lifeStringFormat = new SimpleStringProperty((new IntegerStringConverter().toString(player.getLife())));
        this.lifeIntFormat = new SimpleIntegerProperty(player.getLife());

        this.player.addListener(this);

        lifeStringFormat.addListener((observable,oldValue,newValue)->{
            this.player.setLife((new IntegerStringConverter().fromString(newValue)));
        });

        lifeIntFormat.addListener((observable,oldValue,newValue)->{
            this.player.setLife((int) newValue);
        });
    }
    private Node createHitbox(){
        Rectangle hitbox = new Rectangle();
        hitbox.setWidth(15);
        hitbox.setHeight(15);
        hitbox.setFill(Color.BLANCHEDALMOND);
        hitbox.layoutXProperty().bindBidirectional(getN().layoutXProperty());
        hitbox.layoutYProperty().bindBidirectional(getN().layoutYProperty());
        return hitbox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()){
            case PlayerCharactere.PROP_LIFE:
                setLifeIntFormat((int) evt.getNewValue());
                setLifeStringFormat((int)evt.getNewValue());
                break;
        }
    }



    @Override
    public void whenCollide(CollideType type) {
        switch (type){
            case DAMAGE:break;
            default:break;
        }
    }

    @Override
    public CollideType onTouch() {
        return CollideType.DISAPPEAR;
    }

    @Override
    public void move() {

        ImageView iw = (ImageView) getN();
        iw.setImage(new Image(String.valueOf(getClass().getResource("/image/B-26b.png"))));
        if(GameKeyState.getKeyState(GameKey.PLAYER_LEFT)){
            iw.setImage(new Image(String.valueOf(getClass().getResource("/image/A-20g.png"))));
        }
        else if(GameKeyState.getKeyState(GameKey.PLAYER_RIGHT)){
            iw.setImage(new Image(String.valueOf(getClass().getResource("/image/A-20g.png"))));
        }
        getMoveBehavior().move(new PlayerKeyDirection(),this);
    }

    public List<GameVisualElement> shoot()  {
        ImageView iw = (ImageView) getN();
        double x = iw.getLayoutX()+iw.getFitWidth()/2;
        double y=iw.getLayoutY()+iw.getFitHeight()/2;
        List<GameVisualElement> l = new ArrayList<>();
        l.add( new Projectil(x,y,0,-10));
        l.add( new Projectil(x,y,5,-10));
        l.add( new Projectil(x,y,-5,-10));
        return l;
    }
}
