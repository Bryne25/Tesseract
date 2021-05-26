package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tesseract.backend.loadProduct;
import tesseract.backend.prodTable;
import tesseract.backend.session;

public class CashierUIController implements Initializable{


    @FXML
    private VBox Transaction;

    @FXML
    private VBox Logout;

    @FXML
    private Label cashierfname;

    @FXML
    private Label cashierlname;

    @FXML
    private TableView<prodTable> Product;

    @FXML
    private TableColumn<prodTable, String> productName;

    @FXML
    private TableColumn<prodTable, String> productDescription;

    @FXML
    private TableColumn<prodTable, Integer> numStocks;

    @FXML
    private TableColumn<prodTable, Button> addAction;
    @FXML
    private TableColumn<prodTable, Integer> productPrice;

    @FXML
    void clickLogout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) Logout.getScene().getWindow();
        window.setScene(new Scene(root));
        session.endSession();
    }

    @FXML
    void clickTransaction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        Stage window = (Stage) Transaction.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<prodTable> data = loadProduct.loadDataClient();
        productName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        productDescription.setCellValueFactory(new PropertyValueFactory<>("prodDesc"));
        numStocks.setCellValueFactory(new PropertyValueFactory<>("prodStock"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
        addAction.setCellValueFactory(new PropertyValueFactory<>("addProd"));
        
        Product.setItems(data);
        
        cashierfname.setText(session.fname);
        cashierlname.setText(session.lname);
    }
}