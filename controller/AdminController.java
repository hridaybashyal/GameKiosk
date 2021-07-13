package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AdminController extends Controller<Kiosk>{
    
     @FXML public void initialize() {

    }
     
      public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML public void showAllCustomersWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/ShowAllCustomers.fxml", "All Customers", new Stage());
    }
    
    @FXML public void addCustomerWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    
    @FXML public void removeCustomerWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }
    
    @FXML public void showAllGamesWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/ShowAllGames.fxml", "All Games", new Stage());
    }
    
    @FXML public void addGameWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/AddGame.fxml", "Add Game", new Stage());
    }
    
    @FXML public void removeGameWindow(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/RemoveGame.fxml", "Remove Game", new Stage());
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
    
    
    
    
}
