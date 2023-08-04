import java.sql.*;
import javax.swing.JOptionPane;
public class DBConnect {
 public Connection con;
 public Statement st;
 public ResultSet rs;
  
  DBConnect(){
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st = con.createStatement();
            }
            catch(Exception e){
            System.out.println("Error" + e);
        }
    }
}