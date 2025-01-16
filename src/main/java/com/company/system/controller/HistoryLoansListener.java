package com.company.system.controller;

import static com.company.system.controller.UtilsController.btnDeleteEntered;
import static com.company.system.controller.UtilsController.btnDeleteExited;
import static com.company.system.controller.UtilsController.btnEntered;
import static com.company.system.controller.UtilsController.btnExited;
import com.company.system.model.Loan;
import com.company.system.model.User;
import com.company.system.service.LoanService;
import com.company.system.service.UserService;
import com.company.system.view.HistoryLoans;
import com.company.system.view.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class HistoryLoansListener implements ActionListener, ListSelectionListener, MouseListener, TableModel {

    private final HistoryLoans historyLoans;
    private final UserService userService;
    private final LoanService loanService;
    private User student;

    public HistoryLoansListener(HistoryLoans historyLoans, UserService userService, LoanService loanService) {
        this.historyLoans = historyLoans;
        this.loanService = loanService;
        this.userService = userService;
        addListeners();
    }

    private void addListeners() {
        historyLoans.getBtnSearchIdCard().addActionListener(this);
        historyLoans.getBtnUpdate().addActionListener(this);
        historyLoans.getBtnDelete().addActionListener(this);
        historyLoans.getBtnClean().addActionListener(this);
        historyLoans.getModelSelectionOfTable().addListSelectionListener(this);

        historyLoans.getBtnSearchIdCard().addMouseListener(this);
        historyLoans.getBtnClean().addMouseListener(this);
        historyLoans.getBtnClean().addMouseListener(this);
        historyLoans.getBtnDelete().addMouseListener(this);
        historyLoans.getBtnUpdate().addMouseListener(this);
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
            historyLoans.getTblLoans().setModel(getTableModelLoansLibrarian(historyLoans.getColumnNames(),
                    loanService.getLoansByUser(student)));
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

    private void cleanFields() {
        historyLoans.getTxtIdCardUser().setText("");
        historyLoans.getLblNameStudent().setText("");
        historyLoans.getTxtIdLoan().setText("");
        historyLoans.getTxtRegisterDay().setText("");
        historyLoans.getTxtRequest().setText("");
        historyLoans.getTxtReturnDate().setText("");
        historyLoans.getTxtBooName().setText("");
        historyLoans.getTxtBookISBN().setText("");
        historyLoans.getTxtDevolutionDate().setText("");
        historyLoans.cleanTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyLoans.getBtnSearchIdCard()) {
            searchIdCard();

        } else if (e.getSource() == historyLoans.getBtnUpdate()) {
            uploadTable(student);

        } else if (e.getSource() == historyLoans.getBtnClean()) {
            cleanFields();

        } else if (e.getSource() == historyLoans.getBtnDelete()) {
            if (historyLoans.getTblLoans().getRowCount() > 0 && historyLoans.getTblLoans().getSelectedRow() != -1) {
                int selectedRow = historyLoans.getTblLoans().getSelectedRow();
                Long idLoan = Long.valueOf(String.valueOf(historyLoans.getTblLoans().getValueAt(selectedRow, 0)));
                loanService.deleteLoan(idLoan);
                historyLoans.showMessage("Prestamo eliminado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(student);
                if (student != null) {
                    uploadTable(student);
                }
            } else {
                historyLoans.showMessage("Selecciona un elemento de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = historyLoans.getTblLoans().getSelectedRow();
                Loan loan = loanService.getLoanById(Long.valueOf(getInfoTable(selectedRow, 0)));
//                Devolution devolution = devolutionService.getDevolutionByLoan(loan); //eliminar

                historyLoans.getTxtIdLoan().setText(getInfoTable(selectedRow, 0));

                historyLoans.getTxtRegisterDay().setText(getInfoTable(selectedRow, 1));

                historyLoans.getTxtRequest().setText((loan.getRegistrationUpdateDate() == null) ? "No se ha solicitado prorroga para este libro" : loan.getRegistrationUpdateDate().toString());

                historyLoans.getTxtIsReturned().setText(getInfoTable(selectedRow, 2));

                historyLoans.getTxtReturnDate().setText((loan.getDevolution() == null) ? "El libro no se ha retornado" : loan.getDevolution().getRegistrationDate().toString());

                historyLoans.getTxtBooName().setText(getInfoTable(selectedRow, 4));

                historyLoans.getTxtBookISBN().setText(getInfoTable(selectedRow, 5));

                historyLoans.getTxtDevolutionDate().setText(loan.getDevolutionDate().toString());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == historyLoans.getBtnSearchIdCard()) {
            historyLoans.getBtnSearchIdCard().setBackground(btnEntered);
            historyLoans.getBtnUpdate().setBackground(btnExited);
            historyLoans.getBtnClean().setBackground(btnExited);
            historyLoans.getBtnDelete().setBackground(btnDeleteExited);
        } else if (e.getSource() == historyLoans.getBtnUpdate()) {
            historyLoans.getBtnSearchIdCard().setBackground(btnExited);
            historyLoans.getBtnUpdate().setBackground(btnEntered);
            historyLoans.getBtnClean().setBackground(btnExited);
            historyLoans.getBtnDelete().setBackground(btnDeleteExited);
        } else if (e.getSource() == historyLoans.getBtnDelete()) {
            historyLoans.getBtnSearchIdCard().setBackground(btnExited);
            historyLoans.getBtnUpdate().setBackground(btnExited);
            historyLoans.getBtnClean().setBackground(btnExited);
            historyLoans.getBtnDelete().setBackground(btnDeleteEntered);
        } else if (e.getSource() == historyLoans.getBtnClean()) {
            historyLoans.getBtnSearchIdCard().setBackground(btnExited);
            historyLoans.getBtnUpdate().setBackground(btnExited);
            historyLoans.getBtnClean().setBackground(btnEntered);
            historyLoans.getBtnDelete().setBackground(btnDeleteExited);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == historyLoans.getBtnSearchIdCard()) {
            historyLoans.getBtnSearchIdCard().setBackground(btnExited);
        } else if (e.getSource() == historyLoans.getBtnUpdate()) {
            historyLoans.getBtnUpdate().setBackground(btnExited);
        } else if (e.getSource() == historyLoans.getBtnDelete()) {
            historyLoans.getBtnDelete().setBackground(btnDeleteExited);
        } else if (e.getSource() == historyLoans.getBtnClean()) {
            historyLoans.getBtnClean().setBackground(btnExited);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
