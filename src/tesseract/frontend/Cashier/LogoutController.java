package tesseract.frontend.Cashier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogoutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clickedYesBtn;

    @FXML
    private Button clickedNoBtn;
    
    @FXML
    private void clickedYesBtn(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("login.fxml"));
        Stage window = (Stage) clickedYesBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }
    
    @FXML
    private void clickedNoBtn(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) clickedNoBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }
    
    @FXML
    void initialize() {
    
    }

    private static class clickedLogout {

        public clickedLogout() {
        }
    }
    
}
