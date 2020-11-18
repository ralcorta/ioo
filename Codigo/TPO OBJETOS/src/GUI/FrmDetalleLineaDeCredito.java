package GUI;

import Clases.LineaDeCredito;
import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.Validator;
import Enums.CommonFormatsDefine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmDetalleLineaDeCredito extends JDialog {
    private FrmDetalleLineaDeCredito self;
    private JPanel panelTituloDetalleLDC;
    private JTextField txtImporte;
    private JTextField txtEstado;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField txtFechaVigencia;
    private JPanel panelDetalleLinea;
    private JLabel txtNombreSocio;
    private JComboBox comboEstado;
    private JTextField inputImporteDisponible;

    private String operation;

    public FrmDetalleLineaDeCredito(Window owner, OperacionController controladorOperaciones, SocioParticipe socio, String operation) {
        super(owner, "Detalle de Operación");

        this.setContentPane(panelTituloDetalleLDC);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        inputImporteDisponible.setEnabled(false);

        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");
        comboEstado.setEnabled(false);

        this.operation = operation;

        if(operation.equals("Update")) {
<<<<<<< HEAD
            controladorOperaciones.modificarEstadoLineaDeCredito(socio.getLinea().getIdLineaCredito());
            if(socio.getLinea().isEstadoAprobacion()){
                comboEstado.setSelectedItem("Activo");
            } else {
                comboEstado.setSelectedItem("Inactivo");
            }
=======
>>>>>>> 5435b9138c90d5657458bd04a94f93807561c4c6
            comboEstado.setEnabled(false);
            txtImporte.setText(socio.getLinea().getImporteMaximo());
            inputImporteDisponible.setText(socio.getLinea().getImporteActual());
            txtFechaVigencia.setText(new SimpleDateFormat("dd/MM/yyyy").format(socio.getLinea().getFechaDeVigencia()));
            txtFechaVigencia.setEnabled(false);
        } else{
            inputImporteDisponible.setEnabled(false);
        }

        txtNombreSocio.setText(socio.getCuit() + " - " + socio.getRazonSocial());

        this.eventos(controladorOperaciones, socio);

        this.self = this;
    }

    private void eventos(OperacionController controladorOperaciones, SocioParticipe socio)
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int auxId = controladorOperaciones.getLineasDeCredito().size()+1;

                if((!Validator.isFloat(txtImporte.getText()) || Float.parseFloat(txtImporte.getText()) < 0)){
                    JOptionPane.showMessageDialog(null, "El importe es invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!Validator.isDate(txtFechaVigencia.getText())) {
                    JOptionPane.showMessageDialog(null, "La fecha de vigencia no tiene el formato deseado (" + CommonFormatsDefine.FULL_DATE + ")", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if(operation.equals("Create")){
<<<<<<< HEAD
                        controladorOperaciones.crearLineaDeCredito(auxId, txtImporte.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVigencia.getText()), true, socio);
                        controladorOperaciones.modificarEstadoLineaDeCredito(socio.getLinea().getIdLineaCredito());
                        comboEstado.setSelectedItem(socio.getLinea().isEstadoAprobacion());
=======
                        controladorOperaciones.crearLineaDeCredito(auxId, txtImporte.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVigencia.getText()), estadoAux, socio);
>>>>>>> 5435b9138c90d5657458bd04a94f93807561c4c6
                        JOptionPane.showMessageDialog(self, "Se creo correctamente la linea de credito con monto " + txtImporte.getText() + "$ para el socio con CUIT " + socio.getCuit(), "Operacion generada correctamente", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        controladorOperaciones.updateLineaDeCredito(txtImporte.getText(), socio);
                        JOptionPane.showMessageDialog(self, "La linea de credito ha sido modificada, su nuevo monto es " + txtImporte.getText() + "$", "Operacion generada correctamente", JOptionPane.INFORMATION_MESSAGE);
                    }
                    dispose();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                    dispose();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
