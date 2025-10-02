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

    /*
        * Get the value at the specified row and column
        * @param row the row index
        * @param col the column index
        * @return the value at the specified cell
     */
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

    /*
        * Make only the quantity column editable
        * @param row the row index
        * @param col the column index
        * @return true if the cell is editable, false otherwise
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 2; 
    }

    /*
        * Set the value at the specified row and column
        * @param value the new value
        * @param row the row index
        * @param col the column index
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 2) {
            products.get(row).setQuantity(Integer.parseInt(value.toString()));
            fireTableCellUpdated(row, col);
        }
    }

    /*
        * Get the product at the specified row
        * @param row the row index
        * @return the product at the specified row
     */
    public Product getProductAt(int row) {
        return products.get(row);
    }

    /*
        * Set the products list and notify the table that the data has changed
        * @param products the new list of products
     */
    public void setProducts(ArrayList<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        fireTableDataChanged();
    }
}
