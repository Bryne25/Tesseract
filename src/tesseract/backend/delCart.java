/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;
import java.sql.*;
/**
 *
 * @author TEST
 */
public class delCart {
    public static void delete(int Id){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "DELETE FROM cart WHERE cart_id = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1, Id);
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
