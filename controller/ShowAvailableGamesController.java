package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;


public class ShowAvailableGamesController extends Controller <Kiosk> {
    
    public final Kiosk getKiosk() {
        return model;
    }
    
     @FXML public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }

}
