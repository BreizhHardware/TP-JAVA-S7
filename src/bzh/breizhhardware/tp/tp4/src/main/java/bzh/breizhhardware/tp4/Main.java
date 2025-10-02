package bzh.breizhhardware.tp4;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://10.30.40.173:3306/inventaire4";
        String user = "guest";
        String password = "%Guest2025";
        DatabaseManager dbManager = new DatabaseManager(url, user, password);
        dbManager.fetchProducts();
        dbManager.printProducts();
        InventoryWindow w = new InventoryWindow();
    }
}
