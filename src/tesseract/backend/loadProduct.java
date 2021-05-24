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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author TEST
 */
public class loadProduct {
    
    static String prodName,prodDesc;
    static int prodId, prodPrice, prodStock;
    
    public static ObservableList loadData(){
        ObservableList<prodTable> data = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM product";
            stmt = con.prepareStatement(queryString);
            res = stmt.executeQuery(); 
            
            while(res.next()){
                prodId = res.getInt("Product_Id");
                prodName = res.getString("Product_Name");
                prodDesc = res.getString("Product_Description");
                prodPrice = res.getInt("Product_Price");
                prodStock = res.getInt("Product_Stock");
                
                data.add(new prodTable(prodName,prodDesc,prodId,prodPrice,prodStock));
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
        return data;
    }
    
    public static String getProdName(int Id){
        String name = null;
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
                name = res.getString("Product_Name");     
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
        return name;
    
    }
    
    public static int getProdPrice(int Id){
        int price = 0;
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
                price = res.getInt("Product_Price");
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
        return price;
    
    }
    
    public static String getProdDesc(int Id){
        String desc = null;
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
                desc = res.getString("Product_Description");
               
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
        return desc;
    }
    
    public static String getProdStock(int Id){
        String desc = null;
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
                desc = res.getString("Product_Stock");
               
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
        return desc;
    }
}
