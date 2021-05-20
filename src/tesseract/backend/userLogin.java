/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;
import java.sql.*;
import tesseract.frontend.LoginController;
/**
 *
 * @author oye
 */
public class userLogin {
    Connection con = db.con();
    
    public static void check(String email){
        System.out.println(email);
    }
    
}
