package GUI;

import javax.swing.*;
import java.awt.*;

public class FrmLineaDeCredito extends JDialog {
    private JPanel frmLineaDeCredito;
    private JTable tblSociosPartPlenos;

    public FrmLineaDeCredito(Window owner) {
        super(owner, "Demo de listas");

        this.setContentPane(frmLineaDeCredito);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
    }
}
