package handler;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GameKeyState {
    private static Map<GameKey, BooleanProperty> keysState = new TreeMap<>();

    public static void bindGameKeyValue(BooleanProperty bp,GameKey key){
        keysState.get(key).bindBidirectional(bp);
    }

    public static void bindGameKeyValue(Map<GameKey,BooleanProperty> lp){
        for (GameKey key : GameKey.values())
            if(lp.containsKey(key))bindGameKeyValue(lp.get(key),key);
    }
    public static boolean getKeyState(GameKey key){return keysState.get(key).get();}

    public static void load(){
        GameKey[] keys = GameKey.values();
        for(GameKey key : keys)
            keysState.put(key,new SimpleBooleanProperty(false));
    }
}
