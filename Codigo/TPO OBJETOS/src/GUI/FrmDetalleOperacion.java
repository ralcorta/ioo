package GUI;

import javax.swing.*;
import java.awt.*;

public class FrmDetalleOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JTextField textTipoOperacion;
    private JTextField textEstado;
    private JTextField textImporte;
    private JTextField textFechaCreacOp;
    private JTextField textFechaVenc;
    private JTextField textBancoCheque;
    private JTextField textNumCheque;
    private JTextField textFechaVencCheque;
    private JTextField textCuitCheque;
    private JTextField textTasaDescuentoCheque;
    private JTextField textEmpresaCheque;
    private JTextField textFechaVencCuenta;
    private JTextField textBancoPrestamo;
    private JTextField textTasaInteresPrestamo;
    private JTextField textFechaAcrdPrestamo;
    private JTextField textCantCuotasPrestamo;
    private JTextField textSistemaBancarioPrestamo;
    private JButton GUARDAROPERACIONButton;
    private JButton CANCELAROPERACIONButton;

    public FrmDetalleOperacion(Window owner) {
        super(owner, "Detalle de Operación");

        this.setContentPane(pnlPrincipal);
        //this.setSize(300, 300);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
