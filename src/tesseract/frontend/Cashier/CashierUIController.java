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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CashierUIController implements Initializable{

    
    //Right Bar Selected Product
    @FXML
    private Label selectedProductName;

    @FXML
    private ImageView selectedProduct;

    @FXML
    private Label selectedProductDescription;

    @FXML
    private Label selectedProductPrice;

    @FXML
    private TextArea selectedProductQuantity;

    @FXML
    private Button addProduct;
    
    //Left Bar Navihation Panel
    
    @FXML
    private VBox clickedTransaction;

    @FXML
    private VBox clickedLogout;
    
    //Name of the Cashier
    
    @FXML
    private Label cashierfname;

    @FXML
    private Label cashierlname;
    
    //Choose Products
    
    @FXML
    private ImageView product1;

    @FXML
    private Label productName1;

    @FXML
    private ImageView product2;

    @FXML
    private Label productName2;

    @FXML
    private ImageView product3;

    @FXML
    private Label productName3;

    @FXML
    private ImageView product4;

    @FXML
    private Label productName4;

    @FXML
    private ImageView product5;

    @FXML
    private Label productName5;

    @FXML
    private ImageView product6;

    @FXML
    private Label productName6;

    @FXML
    private ImageView product7;

    @FXML
    private Label productName7;

    @FXML
    private ImageView product8;

    @FXML
    private Label productName8;

    @FXML
    private ImageView product9;

    @FXML
    private Label productName9;

    @FXML
    private ImageView product10;

    @FXML
    private Label productName10;

    private void clickedTransaction(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("Transaction.fxml"));
        Stage window = (Stage) clickedTransaction.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    private void clickedLogout(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) clickedLogout.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
