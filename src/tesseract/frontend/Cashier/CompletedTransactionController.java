package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CompletedTransactionController implements Initializable{


    @FXML
    private Button clickedNewCustomer;

    private void clickedNewCustomer(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) clickedNewCustomer.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
}
