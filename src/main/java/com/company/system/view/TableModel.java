package com.company.system.view;

import com.company.system.model.Fine;
import com.company.system.model.Loan;
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

    // Método para crear la tabla de historial de préstamos
    default DefaultTableModel getTableModelLoans(String columnNames[], List<Loan> loans) {
        DefaultTableModel tableModel = model();
        tableModel.setColumnIdentifiers(columnNames);
        loans.forEach(loan -> {
            Object obj[] = { 
                loan.getBook().getTitle(),  // Suponiendo que Book tiene un método getTitle()
                loan.getDevolutionDate().toString(), 
                loan.isReturned() ? "Yes" : "No", 
                loan.getRegistrationDate().toString(),
                loan.getRegistrationUpdateDate() != null ? loan.getRegistrationUpdateDate().toString() : "N/A",
                
            };
            tableModel.addRow(obj);
        });
        return tableModel;
    }
}
