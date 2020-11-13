package GUI;

import javax.swing.*;
import java.awt.*;

public class FrmConsultasGenerales extends JDialog{
    private JButton consultarButton;
    private JButton consultarButton1;
    private JButton consultarButton2;
    private JButton consultarButton3;
    private JButton consultarButton4;
    private JButton consultarButton5;
    private JPanel frmConsultasGenerales;
    private JPanel frmBotones;

    public FrmConsultasGenerales(Window owner) {
        super(owner, "Demo de listas");

        this.setContentPane(frmConsultasGenerales);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
    }
}
