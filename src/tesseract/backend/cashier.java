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
import tesseract.frontend.admin.EditCashierController;

/**
 *
 * @author TEST
 */
public class cashier {
    String fname,lname,username,password;
    int id;
    Button edit;

    public cashier(String fname, String lname, String username, String password,int id) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.edit = new Button("Edit Cashier");
        Font font = Font.font("ArialBlack", FontWeight.BOLD, FontPosture.REGULAR, 12);
        this.edit.setStyle("-fx-background-color: #1c1c1c; -fx-text-fill: white;");
        this.edit.setFont(font);
        
        bindButton(this.edit);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        EditCashierController.getCashierId(getId());
        System.out.println("You clicked " + getUsername());
        Parent root = FXMLLoader.load(getClass().getResource("../frontend/admin/editCashier.fxml"));
        Stage window = (Stage) edit.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
        
    }
    
}
