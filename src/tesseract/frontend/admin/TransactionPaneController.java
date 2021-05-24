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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tesseract.backend.loadTransactions;
import tesseract.backend.transactions;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class TransactionPaneController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextArea search;
    @FXML
    private TableColumn<transactions, String> cashName;
    @FXML
    private TableColumn<transactions, String> custFname;
    @FXML
    private TableColumn<transactions, String> custLname;
    @FXML
    private TableColumn<transactions, String> date;
    @FXML
    private TableColumn<transactions, String> itemName;
    @FXML
    private TableColumn<transactions, Integer> itemQuant;
    @FXML
    private TableColumn<transactions, Integer> total;
    @FXML
    private TableView<transactions> transactions;
    @FXML
    private TableColumn<transactions, Integer> itemPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<transactions> transData = loadTransactions.loadData();
        cashName.setCellValueFactory(new PropertyValueFactory<>("cashName"));
        custFname.setCellValueFactory(new PropertyValueFactory<>("custFname"));
        custLname.setCellValueFactory(new PropertyValueFactory<>("custLname"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemQuant.setCellValueFactory(new PropertyValueFactory<>("itemQuant"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        itemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));

        transactions.setItems(transData);
        
        FilteredList<transactions> filteredData = new FilteredList<>(transData, b-> true);
        
        search.textProperty().addListener((observable, oldValue, newValue)->{
            filteredData.setPredicate(transacts -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(transacts.getCashName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(transacts.getCustFname().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(transacts.getCustLname().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(transacts.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(transacts.getItemName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
                
            });
        });
        
        SortedList<transactions> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(transactions.comparatorProperty());
        transactions.setItems(sortedData);
        
        
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminMain.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    
}
