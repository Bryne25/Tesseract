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
public class newProd {
    public static void addProd(String name, int price, String desc, int stock){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "INSERT INTO product(`Product_Name`,`Product_Price`,`Product_Description`,`Product_Stock`) VALUES(?,?,?,?)";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setString(3, desc);
            stmt.setInt(4, stock);
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
    
        public static void addToCart(int Id){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "INSERT INTO cart(`product_id`) VALUES(?)";
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
