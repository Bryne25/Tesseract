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
public class updateProd {
    public static void updateProduct(int Id, String prodName, int prodPrice, String prodDesc){
        String name = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "UPDATE product SET Product_Name = ?, Product_Price = ?,Product_Description= ? WHERE Product_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1,prodName);
            stmt.setInt(2,prodPrice);
            stmt.setString(3,prodDesc);
            stmt.setInt(4,Id);
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
