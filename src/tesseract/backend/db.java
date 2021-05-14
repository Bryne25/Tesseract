package tesseract.backend;
// This is where connections are handled. Do not edit

import java.sql.*;

public class db {
    public static Connection con(){
        Connection con = null;
        try{
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/pos?zeroDateTimeBehavior=CONVERT_TO_NULL";
            con = DriverManager.getConnection(url,username,password);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return con;
    }
}
