package bzh.breizhhardware.tp4;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.util.ArrayList;

public class InventoryWindow extends JFrame {
    private DatabaseManager dbManager;
    private ProductTableModel tableModel;

    public InventoryWindow() {
        super("Inventory");

        String[] columnNames = {"id", "name", "quantity"};
        String url = "jdbc:mysql://10.30.40.173:3306/inventaire4";
        String user = "guest";
        String password = "%Guest2025";
        dbManager = new DatabaseManager(url, user, password);
        ArrayList<Product> products = dbManager.fetchProducts();
        ConnectionPanel connectionPanel = new ConnectionPanel();
        connectionPanel.setConnectionListener(new ConnectionPanel.ConnectionListener() {
            @Override
            public void onConnect(String url, String user, String password) {
                dbManager = new DatabaseManager(url, user, password);
                tableModel.setProducts(dbManager.fetchProducts());
                tableModel.fireTableDataChanged();
            }
        });


        tableModel = new ProductTableModel(columnNames, products);
        JTable inventoryTable = new JTable(tableModel);

        // Ajout du listener sur le modèle
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    int row = e.getFirstRow();
                    Product p = tableModel.getProductAt(row);
                    dbManager.updateProductQuantity(p.getId(), p.getQuantity());
                    tableModel.setProducts(dbManager.fetchProducts());
                }
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(connectionPanel);
        topPanel.add(inventoryTable.getTableHeader());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(inventoryTable, BorderLayout.CENTER);

        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new InventoryWindow();
    }
}
