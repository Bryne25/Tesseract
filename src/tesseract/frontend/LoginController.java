/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import tesseract.backend.sdfsdf;

import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author TEST
 */
public class LoginController implements Initializable {

    public Button shitBtn;
    public AnchorPane mainPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void youClickedShit(ActionEvent event) throws IOException{
        System.out.println(sdfsdf.createTable());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ashdjkshd.fxml"));
        mainPane.getChildren().setAll(pane);
    }
    
}
