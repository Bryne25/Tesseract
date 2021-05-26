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
public class productStockMani {
    static int quanti;
    public static int getProdQuanti(int Id){
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM product WHERE Product_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,Id);
            res = stmt.executeQuery(); 
            
            if(res.next()){
                quanti = res.getInt("Product_Stock");     
            }
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
        return quanti;
    }
    
    public static void decreaseProduct(int Id){
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "UPDATE product SET Product_Stock = ? WHERE Product_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,getProdQuanti(Id) - 1);
            stmt.setInt(2,Id);
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
    
    public static void increaseProduct(int Id){
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "UPDATE product SET Product_Stock = ? WHERE Product_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,getProdQuanti(Id) +  1);
            stmt.setInt(2,Id);
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
