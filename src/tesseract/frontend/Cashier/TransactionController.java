package tesseract.frontend.Cashier;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tesseract.backend.cart;
import tesseract.backend.loadCart;
import tesseract.backend.makeTransaction;

public class TransactionController implements Initializable{

    
    //Left Bar Navigation Panel
    @FXML
    private VBox Products;

    @FXML
    private VBox Logout;
    
    //Text Fields for Customer Information
    @FXML
    private TextField customerFName;

    @FXML
    private TextField customerLName;

    @FXML
    private TextField CustomerAddress;

    @FXML
    private TextField CustomerContact;
    
    //Blank Data in Payment Section
    
    @FXML
    private Label grandTotal;

    @FXML
    private Label change;

    @FXML
    private Button completeTransaction;
    @FXML
    private TableView<cart> prodView;
    @FXML
    private TableColumn<cart, String> prodName;
    @FXML
    private TableColumn<cart, Integer> prodPrice;

    @FXML
    private TableColumn<cart, Button> prodDel;
    @FXML
    private TextField cashValue;
    @FXML
    private Text grandTotalValue;
    @FXML
    private Text changeValue;

    int totalCounter;
    
    Boolean canTransact;
    
    @FXML
    public void clickedComplete(ActionEvent event)throws IOException{
        compTransact();
        if(canTransact){
            Parent root = FXMLLoader.load(getClass().getResource("CompletedTransaction.fxml"));
            Stage window = (Stage) completeTransaction.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        
        
        
        
    }
    @FXML
    public void clickedProducts(MouseEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CashierUI.fxml"));
        Stage window = (Stage) Products.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void clickedLogout(MouseEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        Stage window = (Stage) Logout.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    
    private void compTransact(){
        
        for(cart item : prodView.getItems()){
            int id = item.getProdId();
            if(item.getSkip() != true){
                if(Integer.signum(Integer.parseInt(changeValue.getText())) > 0){
                    canTransact = true;
                    int counter = countDuplicates(id);
                    makeTransaction.makeTransaction(customerFName.getText(), customerLName.getText(), CustomerAddress.getText(), CustomerContact.getText(), Integer.parseInt(cashValue.getText()), Integer.parseInt(changeValue.getText()), Integer.parseInt(grandTotalValue.getText()), counter,id);
                }else{
                    canTransact = false;
                }
                
            }
            
        }
    }
   
    private int countDuplicates(int id){
        int dupli = 0;
        for(cart item : prodView.getItems()){
            if(id == item.getProdId() && !(item.getCount())){
                dupli++;
                item.setCount(true);
                item.setSkip(true);
            }
        }
        
        
        return dupli;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<cart> data = loadCart.loadData();
        prodName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        prodPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
        prodDel.setCellValueFactory(new PropertyValueFactory<>("del"));
        

        
        prodView.setItems(data);
        
        for(cart item : prodView.getItems()){
            totalCounter += item.getProdPrice();
        }
        
        grandTotalValue.setText(Integer.toString(totalCounter));
    }
    
    @FXML
    public void textChange(){
        if(isNumeric(cashValue.getText())){
            int theChange =  Integer.parseInt(cashValue.getText()) - Integer.parseInt(grandTotalValue.getText());
            changeValue.setText(Integer.toString(theChange));
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
