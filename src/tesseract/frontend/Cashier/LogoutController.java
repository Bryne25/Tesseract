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

public class LogoutController implements Initializable{


    @FXML
    private Button clickedYesBtn;

    @FXML
    private Button clickedNoBtn;
    
    private void clickedYesBtn(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("login.fxml"));
        Stage window = (Stage) clickedYesBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    private void clickedNoBtn(ActionEvent event)throws IOException{
        Parent root = FMXLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) clickedNoBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private static class clickedLogout {

        public clickedLogout() {
        }
    }
    
}
