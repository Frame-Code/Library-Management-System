package com.company.system.view;

import com.company.system.model.Author;
import com.company.system.model.Devolution;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.service.DevolutionService;
import com.company.system.service.LoanService;

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

    default DefaultTableModel selectionTableModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                // La primera columna tendrá CheckBoxes, por lo tanto tipo Boolean
                if (column == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
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

    default DefaultTableModel getTableModelLoans(String columnNames[], List<Loan> loans) {
        DefaultTableModel tableModel = model();
        tableModel.setColumnIdentifiers(columnNames);
        loans.forEach(loan -> {
            Devolution devolution = loan.getDevolution();
            Object obj[] = {loan.getIdLoan(), loan.getRegistrationDate().toString(), (loan.isReturned()) ? "Si" : "No",
                (devolution != null) ? devolution.getRegistrationDate().toString() : "----", loan.getBook().getTitle(), loan.getBook().getIsbn()};
            tableModel.addRow(obj);
        });

        return tableModel;

    }

    default DefaultTableModel getTableModelAuthors(String columnNames[], List<Author> authors) {
        DefaultTableModel tableModel = selectionTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        authors.forEach(author -> {
            Object obj[] = {false, author.getIdAuthor(), author.getFullNames()};
            tableModel.addRow(obj);
        });

        return tableModel;
    }

}
