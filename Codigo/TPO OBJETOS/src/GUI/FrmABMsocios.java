package GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmABMsocios extends JDialog{
    private JButton nuevoSocioButton;
    private JTable tblSocios;
    private JPanel panelSocios;

    public FrmABMsocios(Window owner) {
        super(owner, "Demo de listas");

        this.setContentPane(panelSocios);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
    }
}

