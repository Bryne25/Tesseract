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

public class LogoutController implements Initializable{


    @FXML
    private Button yesBtn;

    @FXML
    private Button noBtn;
    
    @FXML
    public void clickedNoBtn(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) noBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    @FXML
    public void clickedYesBtn(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../login.fxml"));
        Stage window = (Stage) yesBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
