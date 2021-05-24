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
import tesseract.backend.loadProduct;
import tesseract.backend.prodTable;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class EdiProductController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TableView<prodTable> prodTable;
    @FXML
    private TableColumn<prodTable, Integer> prodId;
    @FXML
    private TableColumn<prodTable, String> prodName;
    @FXML
    private TableColumn<prodTable, String> prodPrice;
    @FXML
    private TableColumn<prodTable, String> prodDesc;
    @FXML
    private TableColumn<prodTable, Button> action;
    @FXML
    private Button newProd;
    @FXML
    private TableColumn<prodTable, String> prodStock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<prodTable> prodData = loadProduct.loadData();
        prodId.setCellValueFactory(new PropertyValueFactory<>("prodId"));
        prodName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        prodPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
        prodDesc.setCellValueFactory(new PropertyValueFactory<>("prodDesc"));
        prodStock.setCellValueFactory(new PropertyValueFactory<>("prodStock"));
        action.setCellValueFactory(new PropertyValueFactory<>("edit"));
        
        
        prodTable.setItems(prodData);
    }    

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminMain.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    @FXML
    private void newProd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newProd.fxml"));
        Stage window = (Stage) newProd.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
    
    
    
    
    
}
