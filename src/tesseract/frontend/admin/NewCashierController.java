/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.frontend.admin;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tesseract.backend.newCashier;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class NewCashierController implements Initializable {

    @FXML
    private TextField fname;
    private TextArea lname;
    @FXML
    private PasswordField pword;
    @FXML
    private PasswordField pwordConfirm;
    @FXML
    private Button update;
    @FXML
    private Button back;
    @FXML
    private Text err;
    @FXML
    private TextField username;
    @FXML
    private TextField lname1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        if(pword.getText().equals(pwordConfirm.getText())){
            newCashier.addCashier(fname.getText(),lname.getText(),username.getText(),pword.getText());
            Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root,950,600));
        }else{
            err.setText("Data Entered is Invalid");
        }
    }
    
}
