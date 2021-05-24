/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TEST
 */
public class updateCashier {
    public static void updateCashier(int Id, String fname, String lname, String username, String password){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "UPDATE cashier SET First_Name = ?, Last_Name = ?,Username= ?,Password = ? WHERE Cashier_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1,fname);
            stmt.setString(2,lname);
            stmt.setString(3,username);
            stmt.setString(4,password);
            stmt.setInt(5,Id);
            stmt.executeUpdate(); 
   
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            if(res != null){
                try { 
                    res.close(); 
                }catch (SQLException e) { 
                    System.out.println(e.toString());
                }
            }   
            
            if(stmt != null){
                try {
                    stmt.close(); 
                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
            }
        
            if(con != null){
                try { 
                    con.close(); 
                } catch (SQLException e) { 
                    System.out.println(e.toString());
                }
            } 
        }
    }
}
