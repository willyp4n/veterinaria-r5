/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author WILLY
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class PropietarioForm extends JFrame {

    public PropietarioForm() {
        initComponents();
    }

    private void initComponents() {
        // Establece el titulo de la ventana
        setTitle(" Owner management system ");

        // Crea un panel para alojar la tabla*/
        PanelPropietarios panelPropietarios = new PanelPropietarios();
        // Sirve de panel principal de la ventana
        setContentPane(panelPropietarios);
        // Ajusta el tamaño de la ventana para que quepan todos los componentes
        pack();
        //setSize(800, 600);
        // Permite ubicar la ventana en el centro de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        // Hace que la ventana de la aplicación sea visible
        setVisible(true);
        setResizable(false); //deshabilita que se pueda maximizar
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
     public static void main(String[] args) {
        new PropietarioForm();
    }
}
