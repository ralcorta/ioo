package GUI;

import Clases.LineaDeCredito;
import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public FrmDetalleLineaDeCredito(Window owner, OperacionController controladorOperaciones, SocioParticipe socio) {
        super(owner, "Detalle de Operación");

        this.setContentPane(panelTituloDetalleLDC);
        //this.setSize(300, 300);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");


        txtNombreSocio.setText(socio.getCuit() + " - " + socio.getRazonSocial());

        this.eventos(controladorOperaciones, socio);

        this.self = this;
    }

    private void eventos(OperacionController controladorOperaciones, SocioParticipe socio)
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int auxId = 0;
                for (LineaDeCredito lc : controladorOperaciones.getLineasDeCredito()) {
                    auxId++;
                }
                try {
                    boolean estadoAux;
                    if (comboEstado.getSelectedItem().toString().equals("Activo")) {
                        estadoAux = true;
                    } else {
                        estadoAux = false;
                    }

                    controladorOperaciones.crearLineaDeCredito(auxId, txtImporte.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaVigencia.getText()), estadoAux, socio);
                    JOptionPane.showMessageDialog(self, "Se creo correctamente la linea de credito con monto " + txtImporte.getText() + " para el socio con CUIT " + socio.getCuit());
                    dispose();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                    dispose();
                }
            }
        });
    }
}
