package controller;
import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;

public class TopUpAccountController extends Controller <Kiosk> {
    
    @FXML private TextField customerIDtf;
    @FXML private TextField topUpAmountTf;
    @FXML private Text feedback;
    @FXML private Button topUpAmountBtn;
    
    @FXML public void initialize() {
       customerIDtf.textProperty().addListener(
                (observable, oldText, newText) -> topUpAmountBtn.setDisable(!(customerIDtf.getText().matches("[0-9]+") && !topUpAmountTf.getText().isEmpty())));
                      
       
        topUpAmountTf.textProperty().addListener(
                (observable, oldText, newText) -> topUpAmountBtn.setDisable(!(customerIDtf.getText().matches("[0-9]+") && !topUpAmountTf.getText().isEmpty())));
                     
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public int getID() {
        return Integer.parseInt(customerIDtf.getText());
    }
    
    public int getTopUpAmount() {
        return Integer.parseInt(topUpAmountTf.getText());
    }
    
  
    @FXML public void handleTopUpAccount(ActionEvent event) throws Exception {
        int id = getID();
        
        Customer c = getKiosk().getCustomer(id);
        if(c != null && getTopUpAmount() > 0 ) {
            c.topUpAccount(getTopUpAmount());
            feedback.setText("Transaction Complete.");
        } else if (c != null && getTopUpAmount() <= 0) {
            feedback.setText("Topup amount must be larger than 0.");
        }
        else {
            feedback.setText("Customer does not exist.");
        }
    }
    
     @FXML 
    public void handleClose(ActionEvent event) throws Exception{
        stage.close();
    }

}
