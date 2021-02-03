package manager;

import Game.GameStage;
import Main.GameEnvironement;
import javafx.animation.AnimationTimer;

public class GameManager extends AnimationTimer {

    private GameStage gameStage;
    private long timer;
    @Override
    public void handle(long l) {
        if( ! gameStage.play(timer))this.stop();
        timer++;
    }

    public void load(){
        gameStage = new GameStage();
        GameEnvironement.getGameEnvironement().setRunningGameStage(gameStage);
        gameStage.load();
        this.start();
    }
}
