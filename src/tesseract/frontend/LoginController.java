package tesseract.frontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tesseract.backend.userLogin;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button loginBtn;
    
    @FXML
    private TextField emailAd;
    
    @FXML
    private PasswordField pass;

    @FXML
    void clickedLoginBtn(ActionEvent event) {
        userLogin.check(this.getEmail());
    }

    @FXML
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'login.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'login.fxml'.";
    }
    
    public String getEmail(){
        String email = emailAd.getText(); 
        return email;
    }
}
