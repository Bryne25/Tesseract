/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.frontend;

import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import tesseract.backend.db;
import tesseract.backend.sdfsdf;

/**
 *
 * @author TEST
 */
public class login extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Tesseract");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = db.con();
        sdfsdf.createTable();
        launch(args);
    }
    
}
