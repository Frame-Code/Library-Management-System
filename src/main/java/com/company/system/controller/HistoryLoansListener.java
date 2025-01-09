package com.company.system.controller;

import com.company.system.model.Devolution;
import com.company.system.model.Fine;
import com.company.system.model.Loan;
import com.company.system.model.User;
import com.company.system.service.DevolutionService;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.HistoryLoans;
import com.company.system.view.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class HistoryLoansListener implements ActionListener, ListSelectionListener, TableModel {

    private final HistoryLoans historyLoans;
    private final UserService userService;
    private final LoanService loanService;
    private final DevolutionService devolutionService;
    private User student;

    public HistoryLoansListener(HistoryLoans historyLoans, UserService userService, LoanService loanService) {
        this.historyLoans = historyLoans;
        this.loanService = loanService;
        this.userService = userService;
        this.devolutionService = new DevolutionService();
        addListeners();
    }

    private void addListeners() {
        historyLoans.getBtnSearchIdCard().addActionListener(this);
        historyLoans.getBtnUpdate().addActionListener(this);
        historyLoans.getBtnGuardar().addActionListener(this);
        historyLoans.getBtnDelete().addActionListener(this);
        historyLoans.getBtnClean().addActionListener(this);
        historyLoans.getModelSelectionOfTable().addListSelectionListener(this);
    }

    // Verifica la existencia y la validez del numero de cedula del estudiante
    // buscado y lo agrega a la instancia student
    private void searchIdCard() {
        Long idCard;
        try {
            idCard = Long.valueOf(historyLoans.getTxtIdCardUser().getText().trim());
            student = userService.getStudentByIdCard(idCard);
            if (student == null) {
                String error = "No se ha encontrado estudiante con el numero de cedula escrito";
                historyLoans.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                historyLoans.getLblNameStudent().setText(error);
                student = null;

            } else {
                historyLoans.showMessage("Estudiante encontrado", "Estudiante encontrado!",
                        JOptionPane.INFORMATION_MESSAGE);
                historyLoans.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());

                uploadTable(student);
            }
        } catch (NumberFormatException e1) {
            historyLoans.showMessage("Escribe un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void uploadTable(User student) {
        historyLoans.cleanTable();
        List<Loan> loansByStudent = loanService.getLoansByUser(student);
        if (!loansByStudent.isEmpty()) {
            historyLoans.getTblLoans().setModel(getTableModelLoans(historyLoans.getColumnNames(),
                    loanService.getLoansByUser(student), devolutionService));
            historyLoans.getTblLoans().setRowHeight(20);
            historyLoans.getTblLoans().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            historyLoans.getTblLoans().getColumnModel().getColumn(0).setPreferredWidth(6);
        } else {
            historyLoans.showMessage("El estudiante no tiene prestamos registrados", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String getInfoTable(int row, int column) {
        return String.valueOf(historyLoans.getTblLoans().getValueAt(row, column));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyLoans.getBtnSearchIdCard()) {
            searchIdCard();
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = historyLoans.getTblLoans().getSelectedRow();
                Loan loan = loanService.getLoanById(Long.valueOf(getInfoTable(selectedRow, 0)));
                Devolution devolution = devolutionService.getDevolutionByLoan(loan);
                
                historyLoans.getTxtIdLoan().setText(getInfoTable(selectedRow, 0));

                historyLoans.getTxtRegisterDay().setText(getInfoTable(selectedRow, 1));
                
                historyLoans.getTxtRequest().setText( (loan.getRegistrationUpdateDate() == null)? "No se ha solicitado prorroga para este libro" : loan.getRegistrationUpdateDate().toString() );
                
                historyLoans.getTxtIsReturned().setText(getInfoTable(selectedRow, 2));

                historyLoans.getTxtReturnDate().setText( (devolution == null)? "El libro no se ha retornado" : devolution.getRegistrationDate().toString());
                
                historyLoans.getTxtYear().setText(getInfoTable(selectedRow, 3));

                historyLoans.getTxtBooName().setText(getInfoTable(selectedRow, 4));
                
                historyLoans.getTxtBookISBN().setText(getInfoTable(selectedRow, 5));
                
                historyLoans.getTxtDay().setText(String.valueOf(loan.getDevolutionDate().getDayOfMonth()));
                
                historyLoans.getCmbMonth().setSelectedIndex(
                        loan.getDevolutionDate().getMonthValue()
                );
                
                historyLoans.getTxtYear().setText(String.valueOf(loan.getDevolutionDate().getDayOfMonth()));

            }
        }
    }

}
