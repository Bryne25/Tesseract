package tesseract.frontend.Cashier;

import java.io.IOException;
import static java.lang.reflect.Array.get;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TransactionController implements Initializable{

    
    //Left Bar Navigation Panel
    @FXML
    private VBox Products;

    @FXML
    private VBox Logout;
    
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

    public void clickedComplete(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CompletedTransaction.fxml"));
        Stage window = (Stage) completeTransaction.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void clickedProducts(MouseEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) Products.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    public void clickedLogout(MouseEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) Logout.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
