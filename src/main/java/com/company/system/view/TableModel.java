package com.company.system.view;

import com.company.system.model.Fine;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public interface TableModel {

    default DefaultTableModel model() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    default DefaultTableModel deleteRows(TableModel tableModel) {
        DefaultTableModel model = (DefaultTableModel) tableModel;
        model.setRowCount(0);
        return model;
    }

    default DefaultTableModel getBasicTableModel(String columnNames[]) {
        DefaultTableModel tableModel = model();
        tableModel.setColumnIdentifiers(columnNames);
        return tableModel;

    }

    default DefaultTableModel getTableModelFines(String columnNames[], List<Fine> fines) {
        DefaultTableModel tableModel = model();
        tableModel.setColumnIdentifiers(columnNames);
        fines.forEach(fine -> {
            Object obj[] = {fine.getIdFine(), fine.getRegistrationDate().toString(), fine.getMessage(), fine.getDeadline().toString()};
            tableModel.addRow(obj);
        });
        
        return tableModel;

    }

}
