/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author dj steve
 */
public class Javaconnect {
    public static Connection connectDB(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","");
           
            return con;
    }
    catch(Exception ex){
    return null;
    }
    
}
    public static Connection createDb(){
       try{
          //String Databasename="";
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
          Statement stm=con.createStatement();
          
          String sql="CREATE DATABASE IF NOT EXISTS Employee";
          stm.executeUpdate(sql);
          
          return con;
          
      }   catch(Exception ex){
          return null;
      }
    }
     public static void main(String[] args) {
        // TODO code application logic here
       
    }
    
}
