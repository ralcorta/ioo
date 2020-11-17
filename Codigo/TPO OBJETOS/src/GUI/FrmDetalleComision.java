package GUI;

import Clases.Operacion;
import Clases.OperacionController;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDetalleComision extends JDialog {
    private FrmDetalleComision self;
    private JPanel pnlPrincipal;
    private JPanel pnlDetalleComision;
    private JTextField txtIdComision;
    private JButton cerrarButton;
    private JButton facturarComisionButton;
    private JTextField txtPorcComision;
    private JTextField txtEstadoComision;
    private int idOperacionAux;

    public FrmDetalleComision(Window owner, OperacionController controladorOperacion, int idOperacion){
        super(owner, "Detalle de Comisión");
        this.setContentPane(pnlPrincipal);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        for(Operacion auxOperacion : controladorOperacion.getOperaciones()) {
            if (auxOperacion.getIdOperacion() == idOperacion) {
                idOperacionAux = idOperacion;
                txtIdComision.setText(auxOperacion.getIdComision());
                txtPorcComision.setText(Float.toString(auxOperacion.getPorcentajeComision()));
                txtEstadoComision.setText(auxOperacion.getEstadoComision());
            }
        }


        txtIdComision.setEnabled(false);
        txtPorcComision.setEnabled(false);
        txtEstadoComision.setEnabled(false);
        if(txtEstadoComision.getText().equals("Facturada")){
            facturarComisionButton.setEnabled(false);
        }

        this.eventos(controladorOperacion);

        this.self = this;
    }

    private void eventos(OperacionController cOperacion)
    {
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        facturarComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(Operacion o : cOperacion.getOperaciones()){
                    if(o.getIdOperacion() == idOperacionAux){
                        float importe = Float.parseFloat(o.getImporte())* Float.parseFloat(txtPorcComision.getText())/100;
                        String resultado[] = o.getComision().emitirFactura("2116", importe);
                        o.getComision().setEstado("Facturada");
                        JOptionPane.showMessageDialog(null, "Se generó la factura " + resultado[0] + " (CAE " + resultado[1] + ") con monto $" + Float.toString(importe) + " con vencimiento a 20 dias a partir de hoy", "Factura generada correctamente", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                }
            }
        });
    }
}
