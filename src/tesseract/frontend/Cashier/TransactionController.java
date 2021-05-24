package tesseract.frontend.Cashier;

import java.io.IOException;
import static java.lang.reflect.Array.get;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TransactionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    //Left Bar Navigation Panel
    @FXML
    private VBox clickedProducts;

    @FXML
    private VBox clickedLogout;
    
    //Text Fields for Customer Information
    @FXML
    private TextField customerFName;

    @FXML
    private TextField customerLName;

    @FXML
    private TextField CustomerAddress;

    @FXML
    private TextField CustomerContact;
    
    //Blank Data in Payment Section
    
    @FXML
    private Label grandTotal;

    @FXML
    private Label change;

    @FXML
    private Button completeTransaction;

    private void clickedProducts(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) clickedProducts.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }
    
    @FXML
    private void clickedLogout(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) clickedLogout.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }
    private void completeTransaction(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("CompletedTransaction.fxml"));
        Stage window = (Stage) completeTransaction.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }
    @FXML
    void initialize() {

    }
}
