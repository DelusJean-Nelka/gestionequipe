package Com.GestionEquipe.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.jdbc.Connection;

public class Mysqlconnect {
	static Connection conn = null;
	 public static Connection connectDB()
	 {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dbgestionEquipe", "root", "rootpasswordgiven");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
                        System.out.println("Hello"+e.getMessage());
		}
	 return conn;
	 }

}
