/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;
import java.sql.*;
/**
 *
 * @author oye
 */
public class userLogin {
    
    
    public static Boolean account(String username,String password){
        try{
            Connection con = db.con();
            String queryString = "SELECT * FROM cashier WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(queryString);
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet res = stmt.executeQuery(); 
            
            if(res.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    
}
