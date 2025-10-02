package bzh.breizhhardware.tp4;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames;
    private final ArrayList<Product> products;

    public ProductTableModel(String[] columnNames, ArrayList<Product> products) {
        this.columnNames = columnNames;
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Product p = products.get(row);
        switch (col) {
            case 0: return p.getId();
            case 1: return p.getName();
            case 2: return p.getQuantity();
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 2; // Seule la colonne quantité est éditable
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 2) {
            products.get(row).setQuantity(Integer.parseInt(value.toString()));
            fireTableCellUpdated(row, col);
        }
    }

    public Product getProductAt(int row) {
        return products.get(row);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        fireTableDataChanged();
    }
}
