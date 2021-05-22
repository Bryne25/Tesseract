/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.frontend.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tesseract.backend.cashier;
import tesseract.backend.loadCashier;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class CashierPaneController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button newBtn;
    @FXML
    private TableColumn<cashier, String> lastname;
    @FXML
    private TableColumn<cashier, String> firstname;
    @FXML
    private TableColumn<cashier, String> username;
    @FXML
    private TableColumn<cashier, String> btn;
    @FXML
    private TableView<cashier> cashierTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<cashier> cashData = loadCashier.loadData();
        lastname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        btn.setCellValueFactory(new PropertyValueFactory<>("edit"));
        
        
        cashierTable.setItems(cashData);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminMain.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void newCashier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newCashier.fxml"));
        Stage window = (Stage) newBtn.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    
}
