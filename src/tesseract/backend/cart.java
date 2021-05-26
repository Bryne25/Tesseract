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

/**
 *
 * @author TEST
 */
public class cart {

    String prodName;
    int prodPrice, prodQuant, prodTotal, cartId,prodId;
    Boolean count = false, skip = false;
    Button del;

    public cart(String prodName, int prodPrice, int prodQuant,int cartId, int prodId) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuant = prodQuant;
        this.prodTotal = this.prodPrice * this.prodQuant;
        this.prodId = prodId;
        this.del = new Button("Delete");
        Font font = Font.font("ArialBlack", FontWeight.BOLD, FontPosture.REGULAR, 12);
        this.del.setStyle("-fx-background-color: #a64452; -fx-text-fill: white;");
        this.del.setFont(font);
        
        del(this.del);
        this.cartId = cartId;
    }

    public Boolean getSkip() {
        return skip;
    }

    public void setSkip(Boolean skip) {
        this.skip = skip;
    }

    public int getCartId() {
        return cartId;
    }

    public Boolean getCount() {
        return count;
    }

    public void setCount(Boolean count) {
        this.count = count;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdQuant() {
        return prodQuant;
    }

    public void setProdQuant(int prodQuant) {
        this.prodQuant = prodQuant;
    }

    public int getProdTotal() {
        return prodTotal;
    }

    public void setProdTotal(int prodTotal) {
        this.prodTotal = prodTotal;
    }

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }
    
     private void del(Button btn){
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
        delCart.delete(getCartId());
        productStockMani.increaseProduct(prodId);
        Parent root = FXMLLoader.load(getClass().getResource("../frontend/Cashier/Transaction.fxml"));
        Stage window = (Stage) this.del.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }
    
}
