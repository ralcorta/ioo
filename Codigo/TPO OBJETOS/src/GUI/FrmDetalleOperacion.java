package GUI;

import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmDetalleOperacion extends JDialog{
    private FrmDetalleOperacion self;
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
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JButton buttonLupa;
    private JPanel panelDetalle;
    private ArrayList<SocioParticipe> sociosParticipes;

    public FrmDetalleOperacion(Window owner, SociosController controladorSocios, OperacionController controladorOperacion) {
        super(owner, "Detalle de Operación");

        this.setContentPane(pnlPrincipal);
        //this.setSize(300, 300);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(controladorSocios, controladorOperacion);
        this.self = this;
    }

    private void eventos(SociosController controladorSocios, OperacionController controladorOperacion)
    {
        buttonLupa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuit = JOptionPane.showInputDialog(self,"Ingrese el CUIT del Socio:");
                if(!cuit.matches("[0-9]+")){
                    //JOptionPane.showMessageDialog(null,"","",JOptionPane.ERROR_MESSAGE);
                }
                for (SocioParticipe s : sociosParticipes) {
                    if (s.getCuit().equals(cuit)){

                    }
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
