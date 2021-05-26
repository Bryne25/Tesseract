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
public class makeTransaction {
    public static void makeTransaction(String fname,String lname,String address,String contact, int money, int change, int grandTotal,int quantity, int prodId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            if(checkCustomer(fname,lname)){
                int customId = getCustomerId(fname,lname);
                int cashierId = session.cash_id;
                String queryString = "INSERT INTO `transaction`(`Change`, `Grand_Total`, `Customer_Id`, `Cashier_Id`, `Product_Id`, `Quantity_Purchased`) VALUES (?,?,?,?,?,?)";
                stmt = con.prepareStatement(queryString);
                stmt.setInt(1, change);
                stmt.setInt(2, grandTotal);
                stmt.setInt(3, customId);
                stmt.setInt(4, cashierId);
                stmt.setInt(5, prodId);
                stmt.setInt(6, quantity);
                stmt.executeUpdate(); 
                dropCart();
            }else{
                createCustomer(fname,lname,address,contact,money);
                int customId = getCustomerId(fname,lname);
                int cashierId = session.cash_id;
                String queryString = "INSERT INTO `transaction`(`Change`, `Grand_Total`, `Customer_Id`, `Cashier_Id`, `Product_Id`,`Quantity_Purchased`) VALUES (?,?,?,?,?,?)";
                stmt = con.prepareStatement(queryString);
                stmt.setInt(1, change);
                stmt.setInt(2, grandTotal);
                stmt.setInt(3, customId);
                stmt.setInt(4, cashierId);
                stmt.setInt(5, prodId);
                stmt.setInt(6, quantity);
                stmt.executeUpdate();
                dropCart();
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
    }
    
    public static Boolean checkCustomer(String fname, String lname){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM customer WHERE First_Name = ? AND Last_Name = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1, fname);
            stmt.setString(2, lname);;
            res = stmt.executeQuery();
            
            return res.next();
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
        return false;
    }
    
    public static int getCustomerId(String fname, String lname){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int id = 0;
        try{
            
            con = db.con();
            String queryString = "SELECT * FROM customer WHERE First_Name = ? AND Last_Name = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1, fname);
            stmt.setString(2, lname);;
            res = stmt.executeQuery();
            
            if(res.next()){
                id = res.getInt("Customer_Id");
                return id;
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
        return id;
    }   
    
    public static void createCustomer(String fname,String lname,String address,String contact, int money){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "INSERT INTO `customer`( `Last_Name`, `First_Name`, `Address`, `Contact_No`, `Money`) VALUES(?,?,?,?,?)";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1, lname);
            stmt.setString(2, fname);
            stmt.setString(3, address);
            stmt.setString(4, contact);
            stmt.setInt(5, money);
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
    
    public static void dropCart(){
         Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "DELETE FROM cart";
            stmt = con.prepareStatement(queryString);

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
