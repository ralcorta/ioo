package GUI;

import Clases.Operacion;
import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SociosController;
import Enums.EstadosDefine;
import Enums.SistemaBancarioDefine;
import Enums.TipoOperacionDefine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private JTextField fieldCertificadoGarantia;
    private JButton comisionAsociadaButton;
    private JLabel lblTxtOperacion;
    private ArrayList<SocioParticipe> sociosParticipes;
    private String auxOperation;
    private String estadoAnterior;
    private int idOperacion;

    public FrmDetalleOperacion(Window owner, SociosController controladorSocios, OperacionController controladorOperacion) {
        super(owner, "Detalle de Operación");
        auxOperation = "Create";

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
        textFechaCreacOp.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        comboEstado.setSelectedItem("Ingresado");
        comboEstado.setEnabled(false);
        comisionAsociadaButton.setVisible(false);
        fieldCertificadoGarantia.setEnabled(false);

        this.sociosParticipes = controladorSocios.getListaDeSociosParticipes();

        this.eventos(controladorSocios, controladorOperacion);
        this.self = this;

        this.pack();
    }

    public FrmDetalleOperacion(Window owner, SociosController controladorSocios, OperacionController controladorOperacion, Operacion o) {
        super(owner, "Detalle de Operación");
        auxOperation = "Update";

        this.setContentPane(pnlPrincipal);
        //this.setSize(300, 300);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        comboTipoOperacion.addItem(TipoOperacionDefine.TIPO_EMPTY);
        comboTipoOperacion.addItem(TipoOperacionDefine.TIPO_1);
        comboTipoOperacion.addItem(TipoOperacionDefine.TIPO_2);
        comboTipoOperacion.addItem(TipoOperacionDefine.TIPO_3);
        comboSistemaBancario.addItem(SistemaBancarioDefine.FRANCES);
        comboSistemaBancario.addItem(SistemaBancarioDefine.AMERICANO);
        comboSistemaBancario.addItem(SistemaBancarioDefine.ALEMAN);
        comboEstado.addItem(EstadosDefine.INGRESADO);
        comboEstado.addItem(EstadosDefine.EMITIDO);
        comboEstado.addItem(EstadosDefine.MONETIZADO);

        this.eventos(controladorSocios, controladorOperacion);

        idOperacion = o.getIdOperacion();
        lblTxtOperacion.setText("ID de Operacion: " + idOperacion);
        comboTipoOperacion.setSelectedItem(o.getTipoDeOperacion());
        showFinancialElements();
        estadoAnterior = o.getEstado();
        comboEstado.setSelectedItem(o.getEstado());
        txtfieldIdLinea.setText(Integer.toString(o.getLinea().getIdLineaCredito()));
        textImporte.setText(o.getImporte());
        textFechaCreacOp.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaCreacionOperacion()));
        textFechaVenc.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVencimiento()));
        comisionAsociadaButton.setVisible(false);
        if(o.getEstado().equals(EstadosDefine.EMITIDO)) {
            comboEstado.removeItem(EstadosDefine.INGRESADO);
            fieldCertificadoGarantia.setText(o.getCertificadoGarantia().getIdCertificadoGarantia());
            fieldCertificadoGarantia.setEnabled(false);
        }
        else if(o.getEstado().equals(EstadosDefine.MONETIZADO)) {
            comboEstado.removeItem(EstadosDefine.INGRESADO);
            comboEstado.removeItem(EstadosDefine.EMITIDO);
            comisionAsociadaButton.setVisible(true);
            fieldCertificadoGarantia.setText(o.getCertificadoGarantia().getIdCertificadoGarantia());
            fieldCertificadoGarantia.setEnabled(false);
        }

        textBancoCheque.setText(o.getNombreBancoCheque());
        textNumCheque.setText(o.getNumeroCheque());
        textFechaVencCheque.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVencCheque()));
        textCuitCheque.setText(o.getCuitCheque());
        textTasaDescuentoCheque.setText(Float.toString(o.getTasaDeDescuento()));
        textEmpresaCuenta.setText(o.getCuentaCorriente());
        textFechaVencCuenta.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVencimientoCuentaCorriente()));
        textBancoPrestamo.setText(o.getNombreBancoPrestamo());
        textTasaInteresPrestamo.setText(Float.toString(o.getTasaDeInteres()));
        textFechaAcrdPrestamo.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaDeAcreditacionPrestamo()));
        textCantCuotasPrestamo.setText(Integer.toString(o.getCantidadDeCuotas()));
        comboSistemaBancario.setSelectedItem(o.getSistemaBancario().toString());

        // Todos los tipos
        comboTipoOperacion.setEnabled(false);
        txtfieldIdLinea.setEnabled(false);
        buttonLupa.setEnabled(false);
        textFechaVenc.setEnabled(false);
        fieldCertificadoGarantia.setEnabled(false);
        // Tipo 1
        textBancoCheque.setEnabled(false);
        textNumCheque.setEnabled(false);
        textFechaVencCheque.setEnabled(false);
        textCuitCheque.setEnabled(false);
        textTasaDescuentoCheque.setEnabled(false);
        // Tipo 2
        textEmpresaCuenta.setEnabled(false);
        textFechaVencCuenta.setEnabled(false);
        // Tipo 3
        textBancoPrestamo.setEnabled(false);
        textTasaInteresPrestamo.setEnabled(false);
        textFechaAcrdPrestamo.setEnabled(false);
        textCantCuotasPrestamo.setEnabled(false);
        comboSistemaBancario.setEnabled(false);

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
                    if(auxOperation.equals("Create")) {
                        String resultado = null;
                        try{
                        if (comboTipoOperacion.getSelectedItem().toString().equals(TipoOperacionDefine.TIPO_1)) {
                                resultado = controladorOperacion.crearOperacion(Integer.parseInt(txtfieldIdLinea.getText()),
                                        TipoOperacionDefine.TIPO_1,
                                        comboEstado.getSelectedItem().toString(),
                                        null,
                                        textImporte.getText(),
                                        new Date(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaVenc.getText()),
                                        0,
                                        0.0f,
                                        //TIPO1
                                        textBancoCheque.getText(),
                                        textNumCheque.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaVencCheque.getText()),
                                        textCuitCheque.getText(),
                                        Float.parseFloat(textTasaDescuentoCheque.getText()),
                                        //TIPO2
                                        "",
                                        new Date(),
                                        //TIPO3
                                        "",
                                        0.0f,
                                        new Date(),
                                        0,
                                        "");

                        } else if (comboTipoOperacion.getSelectedItem().toString().equals(TipoOperacionDefine.TIPO_2)) {
                                resultado = controladorOperacion.crearOperacion(Integer.parseInt(txtfieldIdLinea.getText()),
                                        TipoOperacionDefine.TIPO_2,
                                        comboEstado.getSelectedItem().toString(),
                                        null,
                                        textImporte.getText(),
                                        new Date(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaVenc.getText()),
                                        0,
                                        0.0f,
                                        //TIPO1
                                        "",
                                        "",
                                        new Date(),
                                        "",
                                        0.0f,
                                        //TIPO2
                                        textEmpresaCuenta.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaVencCuenta.getText()),
                                        //TIPO3
                                        "",
                                        0.0f,
                                        new Date(),
                                        0,
                                        "");
                        } else {
                            resultado = controladorOperacion.crearOperacion(Integer.parseInt(txtfieldIdLinea.getText()),
                                    TipoOperacionDefine.TIPO_3,
                                    comboEstado.getSelectedItem().toString(),
                                    null,
                                    textImporte.getText(),
                                    new Date(),
                                    new SimpleDateFormat("dd/MM/yyyy").parse(textFechaVenc.getText()),
                                    0,
                                    0.0f,
                                    //TIPO1
                                    "",
                                    "",
                                    new Date(),
                                    "",
                                    0.0f,
                                    //TIPO2
                                    "",
                                    new Date(),
                                    //TIPO3
                                    textBancoPrestamo.getText(),
                                    Float.parseFloat(textTasaInteresPrestamo.getText()),
                                    new SimpleDateFormat("dd/MM/yyyy").parse(textFechaAcrdPrestamo.getText()),
                                    Integer.parseInt(textCantCuotasPrestamo.getText()),
                                    comboSistemaBancario.getSelectedItem().toString());
                            }
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null, resultado, "Operacion creada correctamente", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                    else if(auxOperation.equals("Update")){
                        // Llamar a metodo actualizar estado
                        // idOperacion
                        String resultado = controladorOperacion.updateOperacion(idOperacion, comboEstado.getSelectedItem().toString(), textImporte.getText());
                        if(comboEstado.getSelectedItem().toString().equals(EstadosDefine.MONETIZADO) && estadoAnterior.equals(EstadosDefine.EMITIDO)){
                            // Generar comision
                            for(Operacion o : controladorOperacion.getOperaciones()){
                                if(o.getIdOperacion() == idOperacion){
                                    if(o.getTipoDeOperacion().equals(TipoOperacionDefine.TIPO_1)){
                                        o.generarComision("Calculada", new Date(), "", 3.0f);
                                    }
                                    else if(o.getTipoDeOperacion().equals(TipoOperacionDefine.TIPO_2)){
                                        o.generarComision("Calculada", new Date(), "", 3.0f);
                                    } else {
                                        o.generarComision("Calculada", new Date(), "", 4.0f);
                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, resultado, "Operacion modificada correctamente", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                }
        });

        comboTipoOperacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFinancialElements();
            }
        });

        comisionAsociadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Operacion o : controladorOperacion.getOperaciones()) {
                    if (o.getIdOperacion() == idOperacion) {
                        JOptionPane.showMessageDialog(null, "La comisión con ID " + o.getIdComision() + " posee " + o.getPorcentajeComision() + "% de interes. Su estado es: " + o.getEstadoComision(), "", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
    }

    public void showFinancialElements(){
        if(comboTipoOperacion.getSelectedItem().equals("")) {
            hideAllFinancialElements();
            pack();
        }
        else if(comboTipoOperacion.getSelectedItem().equals(TipoOperacionDefine.TIPO_1)){
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
        else if(comboTipoOperacion.getSelectedItem().equals(TipoOperacionDefine.TIPO_2)){
            hideAllFinancialElements();
            textEmpresaCuenta.setVisible(true);
            textFechaVencCuenta.setVisible(true);
            txtEmpresaCC.setVisible(true);
            txtVencCC.setVisible(true);
            pack();
        }
        else if(comboTipoOperacion.getSelectedItem().equals(TipoOperacionDefine.TIPO_3)){
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
