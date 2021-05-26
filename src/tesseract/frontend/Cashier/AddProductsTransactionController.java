package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddProductsTransactionController implements Initializable{


    @FXML
    private Button selectNewProduct;

    @FXML
    private Button ProceedToTransaction;
    
    private void selectNewProduct(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) selectNewProduct.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    private void ProceedToTransaction(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        Stage window = (Stage) ProceedToTransaction.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
