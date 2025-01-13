    package com.company.system.app;

import com.company.system.controller.InitialWindowListener;
import com.company.system.controller.LibraryHomeListener;
import com.company.system.service.UserService;
import com.company.system.view.InitialWindow;
import com.company.system.view.LibraryHome;

/**
 * Clase principal de la aplicación. Contiene el método main que es el punto de entrada
 * de la aplicación y es responsable de inicializar la interfaz de usuario y los controladores.
 */
public class Main {
    
    /**
     * Método principal de la aplicación. Inicializa la ventana principal de la biblioteca y
     * asigna el controlador correspondiente a la ventana.
     * 
     * @param args Argumentos pasados a la aplicación (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Inicialización comentada de la ventana inicial y su controlador.
        //InitialWindow frmInitial = new InitialWindow();
        //new InitialWindowListener(frmInitial, new UserService());
        //frmInitial.setVisible(true);

        // Inicializa la ventana principal de la biblioteca.
        LibraryHome frm = new LibraryHome(null);

        // Asocia el controlador LibraryHomeListener a la ventana de la biblioteca.
        new LibraryHomeListener(frm, new UserService());

        // Hace visible la ventana principal.
        frm.setVisible(true);
    }
}
