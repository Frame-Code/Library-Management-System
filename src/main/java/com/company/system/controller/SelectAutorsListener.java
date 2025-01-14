package com.company.system.controller;

import com.company.system.model.Author;
import com.company.system.service.AuthorService;
import com.company.system.view.RegisterBook;
import com.company.system.view.SelectAutors;
import com.company.system.view.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author artist-code Daniel Mora Cantillo
 */
public class SelectAutorsListener implements ActionListener, TableModelListener, TableModel {

    private SelectAutors pnlSelectAutors;
    private final AuthorService authorService;
    private final RegisterBook registerBook;
    private Long idAuthor;

    public SelectAutorsListener(SelectAutors pnlSelectAutors, RegisterBook registerBook) {
        this.pnlSelectAutors = pnlSelectAutors;
        this.registerBook = registerBook;
        this.authorService = new AuthorService();
        uploadTable();
        addListeners();
    }

    private void addListeners() {
        this.pnlSelectAutors.getTblAuthors().getModel().addTableModelListener(this);
        this.pnlSelectAutors.getBtnSearchName().addActionListener(this);
        this.pnlSelectAutors.getBtnSave().addActionListener(this);
    }

    public void uploadTable() {
        pnlSelectAutors.getTblAuthors().setModel(
                getTableModelAuthors(pnlSelectAutors.getColumnNames(), authorService.getAuthors()));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlSelectAutors.getBtnSearchName()) {
            if (!pnlSelectAutors.getTxtNames().getText().isEmpty()) {
                List<Author> authors = authorService.findByName(pnlSelectAutors.getTxtNames().getText());
                if (!authors.isEmpty()) {
                    pnlSelectAutors.getTblAuthors().setModel(
                            getTableModelAuthors(pnlSelectAutors.getColumnNames(), authors));
                } else {
                    pnlSelectAutors.showMessage("No se ha encontrado un autor con ese nombre", "Error", JOptionPane.INFORMATION_MESSAGE);
                    uploadTable();
                }
            } else {
                pnlSelectAutors.showMessage("No pueden haber campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
                uploadTable();
            }

        } else if (e.getSource() == pnlSelectAutors.getBtnSave()) {
            if(!pnlSelectAutors.getIdAuthors().isEmpty()) {
                registerBook.setAuthors(authorService.getAuthors(pnlSelectAutors.getIdAuthors()));
                registerBook.getAuthors().forEach(author -> {
                    registerBook.getTxtAuthors().setText(registerBook.getTxtAuthors().getText() + author.getFullNames() + ", ");
                });
                pnlSelectAutors.showMessage("Autores guardados correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(registerBook.getAuthors());
                pnlSelectAutors.dispose();
            }
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 0) {
                boolean value = (boolean) pnlSelectAutors.getTblAuthors().getValueAt(row, column);
                if (value) {
                    pnlSelectAutors.getIdAuthors().add(Long.parseLong(String.valueOf(pnlSelectAutors.getTblAuthors().getValueAt(row, 1))));
                    pnlSelectAutors.getTxtAreaAuthors().append(String.valueOf(pnlSelectAutors.getTblAuthors().getValueAt(row, 2)) + "\n");
                }
            }
        }
    }

}
