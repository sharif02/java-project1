
package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Connect {
    static Connection con;

    
    public static  Connection conect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoris","root","");
            
            return con;
        } 
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection Failed");
        }
        return null;
    }
    
}
