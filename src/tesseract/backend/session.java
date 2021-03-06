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
public class session {
    //Creates sessions for user
    static String userName = null;
    public static String fname = null;
    public static String lname = null;
    static Boolean isSessionActive = false;
    public static int cash_id;
    
    public static Boolean checkSession(){
        System.out.println(isSessionActive);
        return isSessionActive;
    }
    
    public static void endSession(){
        userName = null;
        fname = null;
        lname = null;
        cash_id = 0;
        isSessionActive = false;
    }
    
    public static void acceptSession(String activeUser){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        System.out.println("Session");
        try{
            con = db.con();
            String queryString = "SELECT * FROM cashier WHERE Username = ?";
            stmt = con.prepareStatement(queryString);
            stmt.setString(1, activeUser);
            
            res = stmt.executeQuery(); 
            
            if(res.next()){
                userName = res.getString("username");
                fname = res.getString("First_Name");
                lname = res.getString("Last_Name");
                cash_id = res.getInt("Cashier_Id");
                isSessionActive = true;
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
    
    public static String getUsername(){
        return userName;
    }
    
}
