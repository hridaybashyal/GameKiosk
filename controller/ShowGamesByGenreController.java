package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import model.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;

public class ShowGamesByGenreController extends Controller <Kiosk> {
    
    @FXML private Button displayGamesBtn;
    @FXML private ListView <Genre> genresLv;
    @FXML private TableView <Game> gamesTv;
    
    @FXML public void initialize() {
        genresLv.getSelectionModel().selectedItemProperty().addListener((genre) -> displayGamesBtn.setDisable(genre == null));
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public Genre getGenre() {
        return genresLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void handleDisplayGames(ActionEvent event) throws Exception {
        Genre g = getGenre();
        
        if(g != null) {
            gamesTv.setItems(getKiosk().getCatalogue().getGamesInGenre(g));
        }
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
