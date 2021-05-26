/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tesseract.frontend.admin.ProductPaneController;

/**
 *
 * @author TEST
 */
public class prodTable{
    String prodName,prodDesc;
    int prodId, prodPrice, prodStock;
    
    Button edit,addProd;
    
    
    
    public prodTable(String prodName, String prodDesc, int prodId, int prodPrice, int prodStock){
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodId = prodId;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
        this.edit = new Button("Edit Product");
        Font font = Font.font("ArialBlack", FontWeight.BOLD, FontPosture.REGULAR, 12);
        this.edit.setStyle("-fx-background-color: #1c1c1c; -fx-text-fill: white;");
        this.edit.setFont(font);
        
        bindButton(this.edit);
        
    }

    public prodTable(String prodName, String prodDesc, int prodId, int prodPrice, int prodStock, int sep) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodId = prodId;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
        if(productStockMani.getProdQuanti(prodId) != 0){
            this.addProd = new Button("Add Product");
            Font font = Font.font("ArialBlack", FontWeight.BOLD, FontPosture.REGULAR, 12);
            this.addProd.setStyle("-fx-background-color: #1c1c1c; -fx-text-fill: white;");
            this.addProd.setFont(font);

            addButton(this.addProd);
        }else{
            this.addProd = new Button("Add Product");
            Font font = Font.font("ArialBlack", FontWeight.BOLD, FontPosture.REGULAR, 12);
            this.addProd.setStyle("-fx-background-color: #1c1c1c; -fx-text-fill: white;");
            this.addProd.setFont(font);
            this.addProd.setDisable(true);

            addButton(this.addProd);
        }
        
    }
    
    

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public int getProdStock() {
        return prodStock;
    }

    public void setProdStock(int prodStock) {
        this.prodStock = prodStock;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }   

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getAddProd() {
        return addProd;
    }

    public void setAddProd(Button addProd) {
        this.addProd = addProd;
    }
    
    
    
    private void bindButton(Button btn){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                try {
                    buttonClick();
                } catch (IOException ex) {
                    Logger.getLogger(prodTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void buttonClick() throws IOException{
        ProductPaneController.getProdId(getProdId());
        System.out.println("You clicked " + getProdName());
        Parent root = FXMLLoader.load(getClass().getResource("../frontend/admin/productPane.fxml"));
        Stage window = (Stage) edit.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        
    }
    
    private void addButton(Button btn){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                try {
                    addButtonClick();
                } catch (IOException ex) {
                    Logger.getLogger(prodTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void addButtonClick() throws IOException{
        if(canAdd()){
            newProd.addToCart(getProdId());
            productStockMani.decreaseProduct(prodId);
            Parent root = FXMLLoader.load(getClass().getResource("../frontend/Cashier/CashierUI.fxml"));
            Stage window = (Stage) this.addProd.getScene().getWindow();
            window.setScene(new Scene(root,950,600));
        }
        
    }
    
    private Boolean canAdd(){
        int stock = productStockMani.getProdQuanti(prodId);
        stock = stock - 1;
        return stock != -1;
        
        
    }
    
}
