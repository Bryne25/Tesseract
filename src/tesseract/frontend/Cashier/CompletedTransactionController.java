package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.stage.Stage;

public class CompletedTransactionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newCustomer;

    @FXML
    public void clickedNewCustomer(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) newCustomer.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void initialize(URL url, ResourceBundle rb) {
    }
}
