 
package employee.management.system;
import java.sql.*;
public class Conn {
    
    Connection con;
    Statement st;

public Conn(){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","shubhamdobhal@1");
st=con.createStatement();
}
catch(Exception e){
    e.printStackTrace();
}
}
    
}


