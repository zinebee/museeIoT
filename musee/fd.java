/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zineb
 */
public class fd {
    public static void main(String[] args) throws SQLException{
        String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }

         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT cin FROM client");
        while(rs.next()){
          System.out.println(rs.getString("cin"));
    }
        con.close();
    
    }
}
