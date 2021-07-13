package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.Kiosk;
import javafx.fxml.FXML;
import model.*;
import javafx.scene.control.TableView;

public class RemoveCustomerController extends Controller<Kiosk> {
    
    @FXML private TableView <Customer> customersTv;
    
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Customer getCustomer() {
        return customersTv.getSelectionModel().getSelectedItem();
    }

    
    @FXML public void handleRemoveCustomer(ActionEvent event) throws Exception {
        Customer c = getCustomer();
        if(c != null) {
            getKiosk().removeCustomer(c);
        }
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
        stage.close();
    } 


}
