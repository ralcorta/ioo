package GUI;

import javax.swing.*;
import java.awt.*;

public class FrmABMLineaDeCredito extends JDialog {
    private JPanel frmLineaDeCredito;
    private JTable tblSociosPartPlenos;
    private JPanel pnlTabla;

    public FrmABMLineaDeCredito(Window owner) {
        super(owner, "Lineas de Credito");

        this.setContentPane(frmLineaDeCredito);
        this.setSize(400, 600);


        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
