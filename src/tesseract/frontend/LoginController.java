package tesseract.frontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tesseract.backend.userLogin;

public class LoginController {


    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button loginBtn;
    
    @FXML
    private TextField emailAd;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    private Text loginErrorText;

    @FXML
    void clickedLoginBtn(ActionEvent event) {
        Boolean isValid = userLogin.account(this.getEmail(), this.getPassword());
        if(!isValid){
            loginErrorText.setVisible(true);
            loginErrorText.setText("Incorrect Username or Password");
            loginErrorText.setFill(Color.RED);
        }
    }

    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'login.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'login.fxml'.";
        loginErrorText.setText("");
    }
    
    public String getEmail(){
        String username = emailAd.getText(); 
        return username;
    }
    
    public String getPassword(){
        String password = pass.getText();
        return password;
    }
}
