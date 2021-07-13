package controller;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FavouriteGamesController extends Controller <Kiosk>  {
    
    @FXML private TextField customerIDtf;
    @FXML private Text feedback;
    @FXML private TableView favouriteGamesTv;
    @FXML private Button selectCustomerBtn;

     
    @FXML public void initialize() {
        customerIDtf.textProperty().addListener(
        (observable, oldText, newText) -> selectCustomerBtn.setDisable(!customerIDtf.getText().matches("[0-9]+")));
        
    }
    
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public int getID() {
    return Integer.parseInt(customerIDtf.getText());
    }
    
    
    @FXML public void handleShowFavouriteGames(ActionEvent event) {
        int id = getID();
        
        Customer c = getKiosk().getCustomer(id);
        if(c != null) {
            feedback.setText(c.toString());
            favouriteGamesTv.setItems(c.favouriteGames());
        } else {
            feedback.setText("Customer does not exist.");
        }
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    

}

