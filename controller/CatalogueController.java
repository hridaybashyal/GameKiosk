package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import javafx.stage.Stage;


public class CatalogueController extends Controller<Kiosk> {
    
    @FXML public void initialize() {

    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML public void showAllGamesWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAllGames.fxml", "All Games", new Stage());
    }
    
    @FXML public void showAvailableGamesWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowAvailableGames.fxml", "Available Games", new Stage());
    }
    
    @FXML public void showGamesByGenreWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowGamesByGenre.fxml", "Games By Genre", new Stage());
    }
    
    @FXML public void showGamesByYearWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ShowGamesByYear.fxml", "Games By Year", new Stage());
    }
    
    @FXML public void rentGameWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/RentGame.fxml", "Rent a Game", new Stage());
    }
    
    @FXML public void returnGameWindow(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/ReturnGame.fxml", "Return a Game", new Stage());
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}
