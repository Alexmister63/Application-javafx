package manager;

import Main.GameEnvironement;
import handler.GameKeyHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
    private Stage currentView;

    public ViewManager(){
        currentView = GameEnvironement.getGameEnvironement().getAppStage();
    }

    public void goToView(ViewList view)throws Exception{
        switch (view){
            case MainMenu:
                currentView.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"))));

                break;
            case GameView:
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/fxml/gameArea.fxml")));
                GameKeyHandler ek =new GameKeyHandler();
                sc.setOnKeyReleased(ek);
                sc.setOnKeyPressed(ek);
                currentView.setScene(sc);
                break;
        }
        if(! currentView.isShowing())currentView.show();
    }

    public void close(){
        currentView.close();
    }

}


