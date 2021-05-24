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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tesseract.backend.deleteCashier;
import tesseract.backend.loadCashier;
import tesseract.backend.updateCashier;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class EditCashierController implements Initializable {

    static int id;
    @FXML
    private Button back;
    @FXML
    private TextArea fname;
    @FXML
    private TextArea lname;
    @FXML
    private TextArea username;
    @FXML
    private Button update;
    @FXML
    private Button del;
    @FXML
    private Text err;
    @FXML
    private PasswordField pword;
    @FXML
    private PasswordField pwordConfirm;
    
    private String adminCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setup(id);
    }    

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void updateBtn(ActionEvent event) throws IOException {
        if(pword.getText().equals(pwordConfirm.getText())){
            if(adminCheck.equals("admin")){
                username.setText("admin");
                updateCashier.updateCashier(id, fname.getText(), lname.getText(), username.getText(), pword.getText());
                Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
                Stage window = (Stage) back.getScene().getWindow();
                window.setScene(new Scene(root,950,600));
            }else{
                updateCashier.updateCashier(id, fname.getText(), lname.getText(), username.getText(), pword.getText());
                Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
                Stage window = (Stage) back.getScene().getWindow();
                window.setScene(new Scene(root,950,600));
            }
            
        }else{
            err.setText("Passwords are not matching");
        }
    }

    @FXML
    private void deleteBtn(ActionEvent event) throws IOException {
        if(id != 99999){
            deleteCashier.delete(id);
            Parent root = FXMLLoader.load(getClass().getResource("cashierPane.fxml"));
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root,950,600));
        }else{
            err.setText("Admin cannot be deleted");
        }
        
    }
    
    public void setup(int Id){
        fname.setText(loadCashier.getFname(Id));
        lname.setText(loadCashier.getLname(Id));
        username.setText(loadCashier.getUn(Id));
        adminCheck = username.getText();
        pword.setText(loadCashier.getPass(Id));
        pwordConfirm.setText(loadCashier.getPass(Id));
    }
    
    public static void getCashierId(int Id){
        id= Id;
        
    }
    
}
