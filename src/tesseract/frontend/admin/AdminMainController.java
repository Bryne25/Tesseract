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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tesseract.backend.session;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class AdminMainController implements Initializable {

    @FXML
    private Button logOut;
    @FXML
    private Button prod;
    @FXML
    private Button trans;
    @FXML
    private Button cashier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void clicked(ActionEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../login.fxml"));
        Stage window = (Stage) logOut.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        session.endSession();
    }

    @FXML
    private void editCashier(ActionEvent event) {
        
    }


    @FXML
    private void revTransactions(ActionEvent event) {
    }

    @FXML
    private void editProducts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ediProduct.fxml"));
        Stage window = (Stage) cashier.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    
}
