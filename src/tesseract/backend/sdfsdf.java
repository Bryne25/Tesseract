/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;
import java.sql.*;
/**
 *
 * @author SAMSUNG
 */
public class sdfsdf {
    static Connection con = db.con();
    static String name;
    public static String createTable(){
        try{
            String sqlStatement = "SELECT * FROM cashier;";
            PreparedStatement create = con.prepareStatement(sqlStatement);
            //create.executeUpdate();
            
            ResultSet res = create.executeQuery();
            while(res.next()){
                name = res.getString("c_fname");
                System.out.println(name);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return name;
    }
    
}
