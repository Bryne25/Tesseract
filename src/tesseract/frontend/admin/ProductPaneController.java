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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import tesseract.backend.delProd;
import tesseract.backend.loadProduct;
import tesseract.backend.updateProd;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class ProductPaneController implements Initializable {

    private static int id;
    @FXML
    private Button back;
    @FXML
    private Button del;
    @FXML
    private TextArea prodName;
    @FXML
    private TextArea prodPrice;
    @FXML
    private TextArea prodDesc;
    @FXML
    private Button update;
    @FXML
    private Text title;
    @FXML
    private Text error;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setup(id);
    }    
    
    public void setup(int Id){
        title.setText(loadProduct.getProdName(Id));
        prodName.setText(loadProduct.getProdName(Id));
        prodPrice.setText(String.valueOf(loadProduct.getProdPrice(Id)));
        prodDesc.setText(loadProduct.getProdDesc(Id));
    }

    public static void getProdId(int Id){
        id = Id;
    }
    
    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void delBtn(ActionEvent event) throws IOException {
        delProd.delete(id);
        Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void updateBtn(ActionEvent event) throws IOException {
        //data validation
        
        if(isNumeric(prodPrice.getText())){
            updateProd.updateProduct(id, prodName.getText(),Integer.parseInt(prodPrice.getText()) , prodDesc.getText());
            Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root,950,600));
        }else{
            error.setText("Data Entered is Invalid");
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
