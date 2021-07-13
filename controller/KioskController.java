package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.*;

public class KioskController extends Controller<Kiosk> {
   
  Catalogue catalogue;
    
  @FXML 
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }
  
  @FXML public void adminWindow(ActionEvent event) throws Exception {
      ViewLoader.showStage(model, "/view/Admin.fxml", "Administration Menu", new Stage());
  }
  
  @FXML public void exploreCatalogueWindow(ActionEvent event) throws Exception {
      ViewLoader.showStage(model, "/view/Catalogue.fxml", "Catalogue", new Stage());
  }
  
  @FXML public void customerRecordWindow(ActionEvent event) throws Exception {
      ViewLoader.showStage(model, "/view/CustomerRecord.fxml", "Customer Record", new Stage());
  }
  
  @FXML public void topUpAccountWindow(ActionEvent event) throws Exception {
      ViewLoader.showStage(model, "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
  }
  
  @FXML public void favouriteGamesWindow(ActionEvent event) throws Exception {
      ViewLoader.showStage(model, "/view/FavouriteGames.fxml", "Favourite Games", new Stage());
  }
  
  
  @FXML public void handleKioskExit(ActionEvent event) throws Exception {
      System.exit(0);
  }
  

}
