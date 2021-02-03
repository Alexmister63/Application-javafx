package handler;

import Main.GameEnvironement;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import manager.movement.MoveManager;

import java.util.Map;
import java.util.TreeMap;

public class GameKeyHandler implements EventHandler<KeyEvent> {
    private Map<GameKey, BooleanProperty> listKeyState;

    public GameKeyHandler(){
        listKeyState = new TreeMap<>();
        for (GameKey key: GameKey.values()) listKeyState.put(key,new SimpleBooleanProperty(false));
        //System.out.println(listKeyState+"\n");
        GameKeyState.bindGameKeyValue(listKeyState);

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        boolean activeDir;
        switch (keyEvent.getEventType().getName()){
            case "KEY_PRESSED":activeDir = true;break;
            case "KEY_RELEASED":
            default:activeDir = false;break;
        }
        if(keyEvent.getCode() == KeyCode.A) {this.listKeyState.get(GameKey.PLAYER_SHOOT).set(activeDir);}
        if(keyEvent.getCode() == KeyCode.UP){this.listKeyState.get(GameKey.PLAYER_UP).set(activeDir) ;}
        if(keyEvent.getCode() == KeyCode.DOWN) {this.listKeyState.get(GameKey.PLAYER_DOWN).set(activeDir);//System.out.println(activeDir);System.out.println(this.listKeyState.get(GameKey.PLAYER_LEFT));System.out.println(GameKeyState.getKeyState(GameKey.PLAYER_LEFT));
             }
        if(keyEvent.getCode() == KeyCode.LEFT) {this.listKeyState.get(GameKey.PLAYER_LEFT).set(activeDir);}
        if(keyEvent.getCode() == KeyCode.RIGHT) this.listKeyState.get(GameKey.PLAYER_RIGHT).set(activeDir);
        //System.out.println(listKeyState);

    }
}
