package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class AddCustomerController extends Controller<Kiosk> {
    @FXML private TextField customerIDtf;
    @FXML private TextField customerNametf;
    @FXML private TextField customerBalancetf;
    @FXML private Text feedback;
        
     
     public final Kiosk getKiosk() {
        return model;
    }
      
   
     public int getCustomerID() {
        return Integer.parseInt(customerIDtf.getText());
    }
     
    public String getCustomerName() {
         return customerNametf.getText();
    }
    
    public int getCustomerBalance() {
        return Integer.parseInt(customerBalancetf.getText());
    }
    
    @FXML public void handleAddCustomer(ActionEvent event) throws Exception {
        int ID = getCustomerID();
        String name = getCustomerName();
        int balance = getCustomerBalance();
        
        
        
        if(getKiosk().getCustomer(ID) == null && customerIDtf.getText().matches("[0-9]+") && !customerNametf.getText().isEmpty() && customerBalancetf.getText().matches("[0-9]+") ) {
            getKiosk().addCustomer(ID, name, balance);
            feedback.setText("Customer added to Kiosk.");
            
        }
        
        else if(getKiosk().getCustomer(ID) == null && customerIDtf.getText().matches("[0-9]+") && !customerNametf.getText().isEmpty() && !customerBalancetf.getText().matches("[0-9]+")) {
            feedback.setText("Please enter a non negative balance.");
        }
        
            else { feedback.setText("That Customer is already in the Kiosk.");
              
        }
    }

    
    @FXML
    public void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
     
     

}
