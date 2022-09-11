
package hotelmanagement;

import java.sql.*;

public class Conn {
        Connection c;//connection is a interface
        Statement s;//statement is a interface
        
        public Conn(){
        try{
        Class.forName("com.mysql.jdbc.Driver");//Loading driver
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","@123");
          
        s = c.createStatement();//s=c.prepareStatement()
        
        }//catch(ClassNotFoundException | SQLException e)
        catch(Exception e)
        {
        System.out.println(e);
}
        
}
}

