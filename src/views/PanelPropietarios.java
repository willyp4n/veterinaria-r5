/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.OwnerController;
import dao.OwnerDao;
import dao.OwnerDaoInterface;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import models.OwnerModel;

public class PanelPropietarios extends JPanel {

    private JLabel jLabelTitulo;
    JTable table = new JTable();
    JScrollPane jsp = new JScrollPane(table);
    private boolean editable; // variable bandera, para evitar modificar propId
    OwnerController controller;
    String dbName = "veterinaria";
    
    public PanelPropietarios() {
        OwnerDaoInterface control = new OwnerDao(dbName);
        controller = new OwnerController(control);
        initComponents();
        cargarPropietarios();
    }

    public void cargarPropietarios() {
        table.setModel(controller.readOwners());
        table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
        table.setFont(new java.awt.Font("Tahoma", 0, 12));
        adjustTextToTable();
    }

    public void removeSelectedRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        //int[] rows = table.getSelectedRows();
        //for (int i = 0; i < rows.length; i++) {
        int column = 0;
        int row = table.getSelectedRow();
        String value = model.getValueAt(row, column).toString();
        controller.deleteOwner(Integer.parseInt(value));
        model.removeRow(row);

    }

    private void adjustTextToTable() {
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout()); //bordes
        // Establece el gestor de organización en forma de retícula de tamaño 10x1      
        jLabelTitulo = new JLabel("owner management", SwingConstants.CENTER);
        add(jLabelTitulo, BorderLayout.NORTH); // añade titulo parte norte pantalla
        Font aux = jLabelTitulo.getFont();
        jLabelTitulo.setFont(new Font(aux.getFontName(), aux.getStyle(), 20)); // cambia tamaño fuente
        editable = false;
        table = new JTable() { // creamos tabla
            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 0) {  // la columna cero ya no es editable.
                    return editable; //To change body of generated methods, choose Tools | Templates.
                }
                return true;
            }
        };
        jsp = new JScrollPane(table);
        table.setSelectionModel(new ForcedListSelectionModel());
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete selected row...");
        deleteItem.addActionListener((ActionEvent e) -> {
            removeSelectedRows(table);
            //JOptionPane.showMessageDialog(null, "Right-click performed on table and choose DELETE");
        });
        JMenuItem addItem = new JMenuItem("Add...");
        addItem.addActionListener((ActionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            editable = true;
            //model.addRow(new Object[]{"id", "Usuario", Calendar.getInstance().get(Calendar.YEAR) + "", "precio"});
              model.addRow(new Object[]{"id", "Usuario", "Apellido", "Nombre", "Telefono"});
        });
        popupMenu.add(addItem);
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
        TableCellListener tcl = new TableCellListener(table, action);
        add(jsp, BorderLayout.AFTER_LAST_LINE);
    }

    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener) e.getSource();
            System.out.println("Row   : " + tcl.getRow());
            System.out.println("Column: " + tcl.getColumn());
            System.out.println("Old   : " + tcl.getOldValue());
            System.out.println("New   : " + tcl.getNewValue());
            String oldValue = tcl.getOldValue().toString();
            if (!oldValue.equals("Id") && !oldValue.equals("Usuario") && !oldValue.equals("Apellido") && !oldValue.equals("Nombre")) {
                if (!oldValue.equals("Telefono")) {
                    int propId = Integer.parseInt(table.getModel().getValueAt(tcl.getRow(), 0).toString());
                    String propUuario = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String propApellido = table.getModel().getValueAt(tcl.getRow(), 2).toString();
                    String propNombre = table.getModel().getValueAt(tcl.getRow(), 3).toString();
                    String propTelefono = table.getModel().getValueAt(tcl.getRow(), 4).toString();
                    OwnerModel l = new OwnerModel(propId, propUuario,propApellido, propNombre, propTelefono);
                    controller.updateOwner(l);
                } else {
                   int propId = Integer.parseInt(table.getModel().getValueAt(tcl.getRow(), 0).toString());
                    String propUuario = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String propApellido = table.getModel().getValueAt(tcl.getRow(), 2).toString();
                    String propNombre = table.getModel().getValueAt(tcl.getRow(), 3).toString();
                    String propTelefono = table.getModel().getValueAt(tcl.getRow(), 4).toString();
                    OwnerModel l = new OwnerModel(propId, propUuario,propApellido, propNombre, propTelefono);
                    controller.addOwner(l);
                    editable = false;
                }
            }
        }
    };

}
