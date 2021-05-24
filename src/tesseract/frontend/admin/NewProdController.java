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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tesseract.backend.newProd;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class NewProdController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextArea prodName;
    @FXML
    private TextArea prodPrice;
    @FXML
    private TextArea prodDesc;
    @FXML
    private Button add;
    @FXML
    private Text err;
    @FXML
    private TextArea prodStock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void addProd(ActionEvent event) throws IOException {
        if(isNumeric(prodPrice.getText()) && isNumeric(prodStock.getText())){
            newProd.addProd( prodName.getText(),Integer.parseInt(prodPrice.getText()) , prodDesc.getText(), Integer.parseInt(prodStock.getText()));
            Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root,950,600));
        }else{
            err.setText("Data Entered is Invalid");
        }
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
