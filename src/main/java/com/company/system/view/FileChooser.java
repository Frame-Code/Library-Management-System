package com.company.system.view;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class FileChooser extends JFileChooser{
    private int userSelection;
    public FileChooser() {
        super();
        setDialogTitle("Seleccionar ubicación a guardar el reporte");
        setSelectedFile(new File("reporte.pdf"));
        this.userSelection = showSaveDialog(null);
    }
    
    public String filePath() {
        if(userSelection == APPROVE_OPTION) {
            File fileToSave = getSelectedFile();
            return fileToSave.getAbsolutePath();
        } else {
            return null;
        }
    }

    public boolean checkSelection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
