/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp6_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cleos
 */
public class TP6_1 {

    /**
     * @param args the command line arguments
     */
    public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/personnel";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            // Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retourner la connexion
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
    
    
}

