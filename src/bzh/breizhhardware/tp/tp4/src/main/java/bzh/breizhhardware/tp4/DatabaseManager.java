package bzh.breizhhardware.tp4;

import java.sql.*;
import java.util.ArrayList;

import bzh.breizhhardware.tp4.Product;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
        * Print all products from the database in the console
     */
    public void printProducts() {
        ArrayList<Product> products = fetchProducts();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }

    /*
        * Fetch all products from the database and return them as an ArrayList
        *
        * @return ArrayList<Product> or null if an error occurs
     */
    public ArrayList<Product> fetchProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM articles")) {

            java.sql.ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            int idIndex = -1, nameIndex = -1, quantityIndex = -1;
            for (int i = 1; i <= columnCount; i++) {
                String colName = metaData.getColumnName(i).toLowerCase();
                if (colName.equals("id")) idIndex = i;
                else if (colName.equals("nom") || colName.equals("name")) nameIndex = i;
                else if (colName.equals("quantity") || colName.equals("quantite")) quantityIndex = i;
            }

            while (rs.next()) {
                int id = rs.getInt(idIndex);
                String nom = rs.getString(nameIndex);
                int quantity = rs.getInt(quantityIndex);
                products.add(new Product(id, nom, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return products;
    }

    /*
        * Update the quantity of a product in the database
        *
        * @param id The id of the product to update
        * @param quantity The new quantity of the product
     */
    public void updateProductQuantity(int id, int quantity) {
        String sql = "UPDATE articles SET quantite = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
