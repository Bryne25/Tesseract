package tesseract.frontend;

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
    private PasswordField pass;
    
    @FXML
    private Text loginErrorText;
    
    @FXML
    private TextField userName;

    @FXML
    void clickedLoginBtn(ActionEvent event) {
        Boolean isValid = userLogin.account(this.getUsername(), this.getPassword());
        if(!isValid){
            loginErrorText.setVisible(true);
            loginErrorText.setText("Incorrect Username or Password");
            loginErrorText.setFill(Color.RED);
        }else{
            String activeUser = getUsername();
            if(activeUser.equals("admin")){
                //scene load admin here
            }else{
                //scene load cashier here
            }
        }
    }

    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'login.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'login.fxml'.";
        loginErrorText.setText("");
    }
    
    public String getUsername(){
        String username = userName.getText(); 
        return username;
    }
    
    public String getPassword(){
        String password = pass.getText();
        return password;
    }
    
}
