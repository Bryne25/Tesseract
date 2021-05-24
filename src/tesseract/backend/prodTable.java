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
    
    Button edit;
    
    
    
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
    
    
    
}
