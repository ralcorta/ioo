package GUI;

import Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmABMAcciones extends JDialog{
    private FrmABMAcciones self;
    private JPanel panelPrincipal;
    private JButton suscribirAccionButton;
    private JButton agregarAccionButton;
    private JTable tablaDeAcciones;
    private JButton buttonRefresh;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMAcciones(Window owner, SociosController cSocios, String cuitSocio) {
        super(owner, "Lista de Accionistas");
        this.setContentPane(panelPrincipal);
        //this.setSize(300, 300);
        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model.addColumn("ID accion");
        model.addColumn("Tipo");
        this.setLocationRelativeTo(null);
        model.fireTableDataChanged();
        tablaDeAcciones.setModel(model);

        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accion a : socio.getListaDeAcciones()) {
                    model.addRow(new Object[]{a.getIdAccion(), a.getTipo()});
                }
            }
        }

        for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accion a : socio.getListaDeAcciones()) {
                    model.addRow(new Object[]{a.getIdAccion(), a.getTipo()});
                }
            }
        }

        this.self = this;
        this.eventos(cSocios, cuitSocio);

    }

    private void eventos(SociosController cSocios, String cuitSocio){
        agregarAccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDetalleAcciones frame = new FrmDetalleAcciones(self, cSocios, cuitSocio);
                frame.setVisible(true);
            }
        });

        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accion a : socio.getListaDeAcciones()) {
                            model.addRow(new Object[]{a.getIdAccion(), a.getTipo()});
                        }
                    }
                }

                for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accion a : socio.getListaDeAcciones()) {
                            model.addRow(new Object[]{a.getIdAccion(), a.getTipo()});
                        }
                    }
                }
            }
        });
    }
}
