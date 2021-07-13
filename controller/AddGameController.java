package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.*;
import javafx.scene.text.Text;

public class AddGameController extends Controller<Kiosk> {
    @FXML private TextField gameTitleTf;
    @FXML private TextField gameYearTf;
    @FXML private TextField gameGenreTf;
    @FXML private TextField gamePriceTf;
    @FXML private Text feedback;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public String getGameTitle() {
        return gameTitleTf.getText();
    }
    
    public int getGameYear() {
        return Integer.parseInt(gameYearTf.getText());
    }
    
    public String getGameGenre() {
        return gameGenreTf.getText();
    }
    
    public int getGamePrice() {
        return Integer.parseInt(gamePriceTf.getText());
    }
    
    @FXML public void handleAddGame(ActionEvent event) throws Exception {
        String title = getGameTitle();
        int year = getGameYear();
        String genre = getGameGenre();
        int price = getGamePrice();
        
        Catalogue catalogue = getKiosk().getCatalogue();
        
        if(catalogue.hasGame(title, year) == false && gamePriceTf.getText().matches("[0-9]+") && !gameGenreTf.getText().isEmpty()  ) {
            catalogue.addGame(title, year, genre, price);
            feedback.setText("Game added to Catalogue.");
           
        }
        else if(catalogue.hasGame(title, year) == false && !gamePriceTf.getText().matches("[0-9]+")) {
            feedback.setText("Game price cannot be negative.");
        }
        else {
            feedback.setText("That game is already in the Catalogue.");
        }
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }

}

