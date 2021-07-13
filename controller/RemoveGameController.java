package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import model.*;
import javafx.scene.control.TableView;

public class RemoveGameController extends Controller<Kiosk> {

    @FXML private TableView <Game> gamesTv;
    
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public final Game getGame() {
        return gamesTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void handleRemoveGame(ActionEvent event) throws Exception{
        Game g = getGame();
        
        if(g != null)
            getKiosk().getCatalogue().removeGame(g);  
    }
    
     @FXML public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }

}
