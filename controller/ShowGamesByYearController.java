package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import model.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;

public class ShowGamesByYearController extends Controller <Kiosk> {
    
    @FXML private Button displayGamesBtn;
    @FXML private ListView <Integer> yearsLv;
    @FXML private TableView <Game> gamesTv;
    
    @FXML public void initialize() {
        yearsLv.setItems(getKiosk().getCatalogue().getYears());
        yearsLv.getSelectionModel().selectedItemProperty().addListener((year) -> displayGamesBtn.setDisable(year == null));
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public int getYear() {
        return yearsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void handleDisplayGames(ActionEvent event) throws Exception {
        int year = getYear();
        
        gamesTv.setItems(getKiosk().getCatalogue().getGamesByYear(year));
        
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}