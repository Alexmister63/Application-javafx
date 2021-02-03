package manager.movement.direction;

import handler.GameKey;
import handler.GameKeyState;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.Map;
import java.util.TreeMap;

public class PlayerKeyDirection implements Direction {

    private Map<GameKey, BooleanProperty> directions;
    public PlayerKeyDirection(){
    }

    public boolean getLeft(){return GameKeyState.getKeyState(GameKey.PLAYER_LEFT);}
    public boolean getRight(){return GameKeyState.getKeyState(GameKey.PLAYER_RIGHT);}
    public boolean getUp(){return GameKeyState.getKeyState(GameKey.PLAYER_UP);}
    public boolean getDown(){return GameKeyState.getKeyState(GameKey.PLAYER_DOWN);}
}