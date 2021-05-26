/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesseract.backend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

/**
 *
 * @author TEST
 */
public class loadCart {
    static String prodName;
    static int cartId, prodPrice, prodQuant,prodId;
    
    public static ObservableList loadData(){
        ObservableList<cart> data = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = db.con();
            String queryString = "SELECT * FROM cart "
                    + "INNER JOIN product p ON  cart.product_id = p.Product_Id ";
            stmt = con.prepareStatement(queryString);
            res = stmt.executeQuery(); 
            
            while(res.next()){
                cartId = res.getInt("cart_id");
                prodId = res.getInt("Product_Id");
                prodName = res.getString("Product_Name");
                prodPrice = res.getInt("Product_Price");
                prodQuant = 0;
                
                data.add(new cart(prodName,prodPrice,prodQuant,cartId,prodId));
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
