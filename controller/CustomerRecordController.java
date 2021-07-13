package controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;
import javafx.scene.control.Button;


public class CustomerRecordController extends Controller <Kiosk> {
    
    @FXML private TextField customerIDtf;
    @FXML private Text feedback;
    @FXML private TableView <Game> rentedGamesTv;
    @FXML private TableView <Game> rentingHistoryTv;
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
    
    @FXML public void handleShowCustomerRecord(ActionEvent event) {
        int id = getID();
        Customer c = getKiosk().getCustomer(id);
        
        if(c != null) {
            feedback.setText(c.toString());
            rentedGamesTv.setItems(c.currentlyRented());
            rentingHistoryTv.setItems(c.rentingHistory());
        } else {
            feedback.setText("Customer does not exist.");
        }
    }
    
    @FXML public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
   
}
