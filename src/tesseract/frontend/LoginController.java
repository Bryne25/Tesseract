package tesseract.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tesseract.backend.session;
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
    void clickedLoginBtn(ActionEvent event) throws IOException {
        Boolean isValid = userLogin.account(this.getUsername(), this.getPassword());
        if(!isValid){
            loginErrorText.setVisible(true);
            loginErrorText.setText("Incorrect Username or Password");
            loginErrorText.setFill(Color.RED);
        }else{
            String activeUser = getUsername();
            
            if(activeUser.equals("admin")){
                session.acceptSession(activeUser);
                Parent root = FXMLLoader.load(getClass().getResource("admin/adminMain.fxml"));
                Stage window = (Stage) loginBtn.getScene().getWindow();
                window.setScene(new Scene(root,950,600));
                //scene load admin here
            }else{
                session.acceptSession(activeUser);
                System.out.println(session.getUsername());
            }
        }
    }

    
    void initialize() {
<<<<<<< HEAD
        loginErrorText.setText("");
=======
>>>>>>> 6377b1abd9e3fbb2a97e8800c56e23271fbd1f45
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
