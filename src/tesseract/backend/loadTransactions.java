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
public class loadTransactions {
    
    static String cashName, custFname, custLname,date,itemName;
    static int itemQuant, itemPrice, transactionId;
    
    public static ObservableList loadData(){
        ObservableList<transactions> data = FXCollections.observableArrayList();
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM transaction "
                    + "INNER JOIN cashier c ON  transaction.Customer_Id = c.Cashier_Id "
                    + "INNER JOIN product p ON transaction.Product_Id = p.Product_Id "
                    + "INNER JOIN customer cu ON transaction.Customer_Id = cu.Customer_Id";
            stmt = con.prepareStatement(queryString);
            res = stmt.executeQuery(); 
            
            while(res.next()){
                transactionId = res.getInt("transaction.Transaction_Id");
                cashName = res.getString("c.First_Name") +" "+ res.getString("c.Last_Name");
                custFname = res.getString("cu.First_Name");
                custLname = res.getString("cu.Last_Name");
                date = res.getString("transaction.Date_Of_Purchase");
                itemName = res.getString("p.Product_Name");
                itemQuant = res.getInt("transaction.Quantity_Purchased");
                itemPrice = res.getInt("p.Product_Price");
                
                data.add(new transactions(transactionId, cashName, custFname, custLname,date, itemName, itemQuant,itemPrice));
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
}
