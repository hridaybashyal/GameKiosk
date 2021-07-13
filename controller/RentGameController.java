package controller;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RentGameController extends Controller <Kiosk> {
    @FXML private TableView <Game> gamesTv;
    @FXML private TextField customerIDtf;
    @FXML private Text feedback;
    @FXML private Button selectCustomerBtn;
    @FXML private Button rentSelectedGameBtn;
    
    @FXML public void initialize() {
    
        customerIDtf.textProperty().addListener(
        (observable, oldText, newText) -> selectCustomerBtn.setDisable(!customerIDtf.getText().matches("[0-9]+")));
        
        gamesTv.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldGame, newGame) -> rentSelectedGameBtn.setDisable(newGame == null));
                
                
    } 
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public int getID() {
        return Integer.parseInt(customerIDtf.getText());
    }
    
    public Game getGame() {
        return gamesTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void handleSelectCustomer(ActionEvent event) throws Exception {
        int id = getID();
        Customer c = getKiosk().getCustomer(id);
        
        if(c != null) {
            gamesTv.setItems(getKiosk().getCatalogue().getAvailableGames());
            feedback.setText("");
        }
        else {
            feedback.setText("Customer does not exist.");

        }
    }
    
     @FXML public void handleSelectedGame(ActionEvent event) throws Exception {
        Game g = getGame();
        Customer c = getKiosk().getCustomer(getID());

        boolean customerCanRent = getKiosk().getCatalogue().rentGameToCustomer(g, c);

        if(customerCanRent){
            rentSelectedGameBtn.setDisable(true);
            feedback.setText("Game Rented.");
            
           
        } else {
            feedback.setText("You do not have sufficient funds.");
        }
            
    }
     
     @FXML public void handleClose(ActionEvent event) throws Exception{
        stage.close();
     }

}
