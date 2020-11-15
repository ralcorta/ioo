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
    private JTextField textImporte;
    private JTextField textFechaCreacOp;
    private JTextField textFechaVenc;
    private JTextField textBancoCheque;
    private JTextField textNumCheque;
    private JTextField textFechaVencCheque;
    private JTextField textCuitCheque;
    private JTextField textTasaDescuentoCheque;
    private JTextField textEmpresaCuenta;
    private JTextField textFechaVencCuenta;
    private JTextField textBancoPrestamo;
    private JTextField textTasaInteresPrestamo;
    private JTextField textFechaAcrdPrestamo;
    private JTextField textCantCuotasPrestamo;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtfieldIdLinea;
    private JButton buttonLupa;
    private JPanel panelDetalle;
    private JComboBox comboTipoOperacion;
    private JLabel txtBanco;
    private JLabel txtCheque;
    private JLabel txtVencCheque;
    private JLabel txtCuitCheque;
    private JLabel txtDescCheque;
    private JLabel txtEmpresaCC;
    private JLabel txtVencCC;
    private JLabel txtBancoPrest;
    private JLabel txtIntPrest;
    private JLabel txtFechaPrest;
    private JLabel txtCuotasPrest;
    private JComboBox comboSistemaBancario;
    private JLabel txtSistemaBancarioPrest;
    private JComboBox comboEstado;
    private ArrayList<SocioParticipe> sociosParticipes;

    public FrmDetalleOperacion(Window owner, SociosController controladorSocios, OperacionController controladorOperacion) {
        super(owner, "Detalle de Operación");

        this.setContentPane(pnlPrincipal);
        //this.setSize(300, 300);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        comboTipoOperacion.addItem("");
        comboTipoOperacion.addItem("Tipo 1");
        comboTipoOperacion.addItem("Tipo 2");
        comboTipoOperacion.addItem("Tipo 3");
        comboSistemaBancario.addItem("Frances");
        comboSistemaBancario.addItem("Americano");
        comboSistemaBancario.addItem("Aleman");
        comboEstado.addItem("Ingresado");
        comboEstado.addItem("Con certificado emitido");
        comboEstado.addItem("Monetizado");
        hideAllFinancialElements();

        this.sociosParticipes = controladorSocios.getListaDeSociosParticipes();

        this.eventos(controladorSocios, controladorOperacion);
        this.self = this;

        this.pack();

    }

    private void eventos(SociosController controladorSocios, OperacionController controladorOperacion)
    {
        buttonLupa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuit = JOptionPane.showInputDialog(self,"Ingrese el CUIT del Socio:");
                if(!cuit.matches("[0-9]+")){
                    JOptionPane.showMessageDialog(null,"El CUIT debe ser numerico","Error: Formato CUIT",JOptionPane.ERROR_MESSAGE);
                } else {
                    for (SocioParticipe s : sociosParticipes) {
                        if (s.getCuit().equals(cuit)) {
                            txtfieldIdLinea.setText(Integer.toString(s.getLinea().getIdLineaCredito()));
                        }
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
                    /*controladorOperacion.crearOperacion(txtfieldIdLinea.getText(),
                            "Tipo 1", comboEstado.getSelectedItem().toString(),
                            );*/
            }
        });

        comboTipoOperacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboTipoOperacion.getSelectedItem().equals("")) {
                    hideAllFinancialElements();
                    pack();
                }
                else if(comboTipoOperacion.getSelectedItem().equals("Tipo 1")){
                    hideAllFinancialElements();
                    txtBanco.setVisible(true);
                    txtCheque.setVisible(true);
                    txtVencCheque.setVisible(true);
                    txtCuitCheque.setVisible(true);
                    txtDescCheque.setVisible(true);
                    textBancoCheque.setVisible(true);
                    textNumCheque.setVisible(true);
                    textFechaVencCheque.setVisible(true);
                    textCuitCheque.setVisible(true);
                    textTasaDescuentoCheque.setVisible(true);
                    pack();
                }
                else if(comboTipoOperacion.getSelectedItem().equals("Tipo 2")){
                    hideAllFinancialElements();
                    textEmpresaCuenta.setVisible(true);
                    textFechaVencCuenta.setVisible(true);
                    txtEmpresaCC.setVisible(true);
                    txtVencCC.setVisible(true);
                    pack();
                }
                else if(comboTipoOperacion.getSelectedItem().equals("Tipo 3")){
                    hideAllFinancialElements();
                    textBancoPrestamo.setVisible(true);
                    textTasaInteresPrestamo.setVisible(true);
                    textFechaAcrdPrestamo.setVisible(true);
                    textCantCuotasPrestamo.setVisible(true);
                    txtBancoPrest.setVisible(true);
                    txtIntPrest.setVisible(true);
                    txtFechaPrest.setVisible(true);
                    txtCuotasPrest.setVisible(true);
                    comboSistemaBancario.setVisible(true);
                    txtSistemaBancarioPrest.setVisible(true);
                    pack();
                }
            }
        });
    }

    public void hideAllFinancialElements(){
        textBancoCheque.setVisible(false);
        textNumCheque.setVisible(false);
        textFechaVencCheque.setVisible(false);
        textCuitCheque.setVisible(false);
        textTasaDescuentoCheque.setVisible(false);
        textEmpresaCuenta.setVisible(false);
        textFechaVencCuenta.setVisible(false);
        textBancoPrestamo.setVisible(false);
        textTasaInteresPrestamo.setVisible(false);
        textFechaAcrdPrestamo.setVisible(false);
        textCantCuotasPrestamo.setVisible(false);
        txtBanco.setVisible(false);
        txtCheque.setVisible(false);
        txtVencCheque.setVisible(false);
        txtCuitCheque.setVisible(false);
        txtDescCheque.setVisible(false);
        txtEmpresaCC.setVisible(false);
        txtVencCC.setVisible(false);
        txtBancoPrest.setVisible(false);
        txtIntPrest.setVisible(false);
        txtFechaPrest.setVisible(false);
        txtCuotasPrest.setVisible(false);
        comboSistemaBancario.setVisible(false);
        txtSistemaBancarioPrest.setVisible(false);
    }
}
