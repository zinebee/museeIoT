/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.sql.SQLException;

/**
 *
 * @author zineb
 */
public class vclient {
    public static void main(String[] args) throws SQLException {
        
            // TODO code application logic here
            /*  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]","root","root1234ROOT");
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM client");
            while(rs.next()){
            System.out.println(rs.getString("*"));
            }
           
            con.close();*/
            //login z=new login();
             Acceuil d=new Acceuil();
             MuseeIoT muse=new MuseeIoT();
             Thread m=new Thread(muse);
             m.start();
            
            
          
        
    }
}
