/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframes;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author mohit
 */
public class DBConnection {
        
    static Connection con =null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/libdata","mohit","Mohit0918");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }
            
    
}
