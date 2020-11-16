package GUI;

import Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmABMOperaciones extends JDialog{
    private FrmABMOperaciones self;
    private JPanel panelOperaciones;
    private JPanel panelTituloOperaciones;
    private JPanel panelBotonesOperaciones;
    private JTable tablaDeCuits;
    private JButton nuevaOperaciónButton;
    private JButton btnRefresh;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMOperaciones(Window owner, SociosController controladorSocios, OperacionController controladorOperacion) {
        super(owner, "Operaciones");

        this.setContentPane(panelOperaciones);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        model.addColumn("ID Operacion");
        model.addColumn("CUIT");
        model.addColumn("Razon Social");
        model.addColumn("Importe");
        model.addColumn("Tipo Operacion");


        for(Operacion o : controladorOperacion.getOperaciones()){
            model.addRow(new Object[]{ o.getIdOperacion(), o.getLinea().getSocio().getCuit(), o.getLinea().getSocio().getRazonSocial(), o.getImporte(), o.getTipoDeOperacion()});
        }

        tablaDeCuits.setModel(model);

        this.eventos(controladorSocios, controladorOperacion);

        this.self = this;

    }

    private void eventos(SociosController controladorSocios, OperacionController controladorOperacion) {
        nuevaOperaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleOperacion frame = new FrmDetalleOperacion(self, controladorSocios, controladorOperacion);
                frame.setVisible(true);
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.setRowCount(0);
                for(Operacion o : controladorOperacion.getOperaciones()){
                    model.addRow(new Object[]{ o.getIdOperacion(), o.getLinea().getSocio().getCuit(), o.getLinea().getSocio().getRazonSocial(), o.getImporte(), o.getTipoDeOperacion()});
                }
            }
        });

        tablaDeCuits.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int filaSeleccionada = tablaDeCuits.getSelectedRow();
                int idOperacion = Integer.parseInt(tablaDeCuits.getValueAt(filaSeleccionada,0).toString());
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    for(Operacion o : controladorOperacion.getOperaciones()) {
                        if (o.getIdOperacion() == idOperacion) {
                            FrmDetalleOperacion frame = new FrmDetalleOperacion(self, controladorSocios, controladorOperacion, o);
                            frame.setVisible(true);
                        }
                    }
                }
            }
        });
    }
}
