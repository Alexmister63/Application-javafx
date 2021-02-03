package Game;

import entity.PlayerCharactere;
import entity.view_entity.GameVisualElement;
import entity.view_entity.Projectil;
import entity.view_entity.ViewPlayerCharactere;
import handler.GameKey;
import handler.GameKeyState;
import javafx.animation.AnimationTimer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import manager.ElementManager;
import manager.collide.CanCollide;
import manager.collide.CollideManager;
import manager.movement.CanMove;
import manager.movement.MoveManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class GameStage {
    public ViewPlayerCharactere getPlayer() {
        return player;
    }


    ViewPlayerCharactere player;
    MoveManager pm;
    private List<CanMove> MoveElements;
    private List<CanCollide> CollideElements;
    private  List<GameVisualElement> toRemove;
    private boolean isShooting;
    private boolean isPlaying;
    private boolean canShoot;


    public GameStage(){

    }

    public void load(){
        MoveElements = new ArrayList<>();
        CollideElements = new ArrayList<>();
        toRemove = new ArrayList<>();
        pm = new MoveManager();
        player = new ViewPlayerCharactere(new PlayerCharactere());
        player.getN().setLayoutX(50);
        player.getN().setLayoutY(50);
        CollideElements.add(player);
        MoveElements.add(player);
        canShoot = true;
       new ElementManager().addElement(player.getN());
       isPlaying = true;
    }

    public boolean play(long timer){
        if(!toRemove.isEmpty())remove(toRemove);
        if (player.getLife() == 0)isPlaying = false;
        if(GameKeyState.getKeyState(GameKey.PLAYER_SHOOT) && canShoot){canShoot = false;addElements(player.shoot());}
        if(!MoveElements.isEmpty())pm.move(MoveElements);
        if(!CollideElements.isEmpty())new CollideManager().testCollide(CollideElements);

        if (timer%7 == 0){canShoot=true;}
        timer++;
        return isPlaying;
    }

    private void addElement(GameVisualElement e){
        new ElementManager().addElement(e.getN());
        MoveElements.add(e);
        CollideElements.add(e);
    }

    private void addElements(List<GameVisualElement> elements){
        for(GameVisualElement element : elements)
            addElement(element);
    }

    public void addToRemove(GameVisualElement element){
        toRemove.add(element);
    }
    private void remove(GameVisualElement e){
        new ElementManager().removeElement(e.getN());
        MoveElements.remove(e);
        CollideElements.remove(e);
    }

    private void remove(List<GameVisualElement> elements){
        for(GameVisualElement element : elements)
            remove(element);
        for(int i=0; i<elements.size() ;i++)
            elements.remove(i);
    }


}
