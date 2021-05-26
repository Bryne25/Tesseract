package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CashierUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox Transaction;

    @FXML
    private VBox Logout;

    @FXML
    private Label cashierfname;

    @FXML
    private Label cashierlname;

    @FXML
    private TableView<?> Product;

    @FXML
    private TableColumn<?, ?> productName;

    @FXML
    private TableColumn<?, ?> productDescription;

    @FXML
    private TableColumn<?, ?> numStocks;

    @FXML
    private TableColumn<?, ?> addAction;

    @FXML
    void clickLogout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) Logout.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    void clickTransaction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        Stage window = (Stage) Transaction.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }
}