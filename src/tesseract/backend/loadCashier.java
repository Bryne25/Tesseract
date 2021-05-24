/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author TEST
 */
public class loadCashier {
    
    static String lname,fname,username,password;
    static int id;
    
    public static ObservableList loadData(){
        
        ObservableList<cashier> data = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier";
            stmt = con.prepareStatement(queryString);
            res = stmt.executeQuery(); 
            
            while(res.next()){
                id = res.getInt("Cashier_Id");
                lname = res.getString("Last_Name");
                fname = res.getString("First_Name");
                username = res.getString("Username");
                password = res.getString("Password");
                
                data.add(new cashier(fname,lname,username,password,id));
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
    
    public static String getFname(int Id){
        String name = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier WHERE Cashier_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,Id);
            res = stmt.executeQuery(); 
            
            if(res.next()){
                name = res.getString("First_Name");     
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
    
    public static String getLname(int Id){
        String name = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier WHERE Cashier_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,Id);
            res = stmt.executeQuery(); 
            
            if(res.next()){
                name = res.getString("Last_Name");     
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
    
    public static String getUn(int Id){
        String name = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier WHERE Cashier_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,Id);
            res = stmt.executeQuery(); 
            
            if(res.next()){
                name = res.getString("Username");     
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
    
    public static String getPass(int Id){
        String name = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier WHERE Cashier_ID = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setInt(1,Id);
            res = stmt.executeQuery(); 
            
            if(res.next()){
                name = res.getString("Password");     
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
    
    
    
    
    
    
    
    
    
    
}
