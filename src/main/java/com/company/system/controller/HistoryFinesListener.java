package com.company.system.controller;

import com.company.system.model.Fine;
import com.company.system.model.User;
import com.company.system.service.FineService;
import com.company.system.service.UserService;
import com.company.system.view.HistoryFines;
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
public class HistoryFinesListener implements ActionListener, ListSelectionListener, UtilsController, TableModel {

    private final HistoryFines historyFines;
    private final UserService userService;
    private final FineService fineService;
    private final User librarian;
    private User student;

    public HistoryFinesListener(HistoryFines historyFines, UserService userService, User librarian) {
        this.historyFines = historyFines;
        this.userService = userService;
        this.fineService = new FineService();
        this.librarian = librarian;
        addListeners();

    }

    private void addListeners() {
        historyFines.getBtnSearchIdCard().addActionListener(this);
        historyFines.getModelSelectionOfTable().addListSelectionListener(this);
        historyFines.getBtnClean().addActionListener(this);
        historyFines.getBtnGuardar().addActionListener(this);
    }

    private void uploadTable(User student) {
        List<Fine> finesFromUser = fineService.getFinesByStudent(student);
        if (!finesFromUser.isEmpty()) {
            historyFines.getTblFines().setModel(getTableModelFines(historyFines.getColumnNames(), fineService.getFinesByStudent(student)));
            historyFines.getTblFines().setRowHeight(20);
            historyFines.getTblFines().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            System.out.println("cargo aqui");
        } else {
            historyFines.showMessage("El estudiante no tiene multas registradas", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isEmptyFieldsUser() {
        return historyFines.getTxtIdCardUser().getText().isEmpty();
    }

    private void cleanFields() {
        historyFines.getTxtIdCardUser().setText("");
        historyFines.getLblNameStudent().setText("");
        historyFines.getTxtIdFine().setText("");
        historyFines.getTxtRegisterDay().setText("");
        historyFines.getTxtDeadLineDay().setText("");
        historyFines.getTxtYear().setText("");
        historyFines.getCmbMonth().setSelectedIndex(0);
        historyFines.getTxtAreaMessage().setText("");
        historyFines.cleanTable();
    }

    //Verifica la existencia y la validez del numero de cedula del estudiante buscado y lo agrega a la instancia student    
    private void searchIdCard() {
        Long idCard;
        try {
            idCard = Long.valueOf(historyFines.getTxtIdCardUser().getText());
            student = userService.getStudentByIdCard(idCard);
            if (student == null) {
                String error = "No se ha encontrado estudiante con el numero de cedula escrito";
                historyFines.showMessage(error, "error", JOptionPane.ERROR_MESSAGE);
                historyFines.getLblNameStudent().setText(error);
                student = null;

            } else {
                historyFines.showMessage("Estudiante encontrado", "Estudiante encontrado!",
                        JOptionPane.INFORMATION_MESSAGE);
                historyFines.getLblNameStudent().setText(student.getNames() + " " + student.getSurNames());

                uploadTable(student);
            }
        } catch (NumberFormatException e1) {
            historyFines.showMessage("Escribe un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getInfoTable(int row, int column) {
        return String.valueOf(historyFines.getTblFines().getValueAt(row, column));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == historyFines.getBtnSearchIdCard()) {
            if (!isEmptyFieldsUser()) {
                cleanFields();
                searchIdCard();
            } else {
                historyFines.showMessage("Escribe correctamente un numero de cedula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == historyFines.getBtnClean()) {
            cleanFields();
        } else if (e.getSource() == historyFines.getBtnGuardar()) {
            if (historyFines.getTblFines().getSelectedRow() != -1) {
                Long idFine = Long.valueOf(getInfoTable(historyFines.getTblFines().getSelectedRow(), 0));
                LocalDate deadline = getDate(Integer.parseInt(historyFines.getTxtDeadLineDay().getText()),
                        String.valueOf(historyFines.getCmbMonth().getSelectedItem()), Integer.parseInt(historyFines.getTxtYear().getText()));
                String message = historyFines.getTxtAreaMessage().getText();

                if (fineService.updateFine(idFine, deadline, message, librarian)) {
                    historyFines.showMessage("Multa guardada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    uploadTable(student);
                } else {
                    historyFines.showMessage("Error: consulte al de sistemas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                historyFines.showMessage("Error: seleciona un registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                int selectedRow = historyFines.getTblFines().getSelectedRow();

                historyFines.getTxtIdFine().setText(getInfoTable(selectedRow, 0));

                historyFines.getTxtRegisterDay().setText(getInfoTable(selectedRow, 1));

                historyFines.getTxtDeadLineDay().setText(
                        String.valueOf(LocalDate.parse(getInfoTable(selectedRow, 3)).getDayOfMonth())
                );

                historyFines.getTxtYear().setText(
                        String.valueOf(LocalDate.parse(getInfoTable(selectedRow, 3)).getYear())
                );

                historyFines.getCmbMonth().setSelectedIndex(
                        LocalDate.parse(getInfoTable(selectedRow, 3)).getMonthValue() - 1
                );

                historyFines.getTxtAreaMessage().setText(getInfoTable(selectedRow, 2));

            }
        }

    }

}
