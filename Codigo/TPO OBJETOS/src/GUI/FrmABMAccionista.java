package GUI;

import Clases.Accionistas;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmABMAccionista extends JDialog {
    private FrmABMAccionista self;
    private JPanel panelAccionistas;
    private JTable tablaDeAccionistas;
    private JButton nuevoAccionistaButton;
    private JButton buscarButton;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMAccionista(Window owner, SociosController cSocios, String cuitSocio) {
        super(owner, "Lista de Accionistas");
        this.setContentPane(panelAccionistas);
        //this.setSize(300, 300);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model.addColumn("CUIT");
        model.addColumn("Razon Social");
        model.addColumn("Porcentaje participacion");
        model.addColumn("CUIT del socio");

        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accionistas accionista : socio.getListaDeAccionistas()) {
                    model.addRow(new Object[]{accionista.getCuit(), accionista.getRazonSocial(), accionista.getPorcentajeDeParticipacion(), cuitSocio});
                }
            }
        }

        for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accionistas accionista : socio.getListaDeAccionistas()) {
                    model.addRow(new Object[]{accionista.getCuit(), accionista.getRazonSocial(), accionista.getPorcentajeDeParticipacion(), cuitSocio});
                }
            }
        }

        this.setLocationRelativeTo(null);

        model.fireTableDataChanged();

        tablaDeAccionistas.setModel(model);

        this.eventos(cSocios, cuitSocio);

        this.self = this;
    }

    private void eventos(SociosController cSocio, String cuitSocio){
        nuevoAccionistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDetalleAccionista frame = new FrmDetalleAccionista(self, cSocio, cuitSocio);
                frame.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                for (SocioParticipe socio : cSocio.listaDeSociosParticipes) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accionistas accionista : socio.getListaDeAccionistas()) {
                            model.addRow(new Object[]{accionista.getCuit(), accionista.getRazonSocial(), accionista.getPorcentajeDeParticipacion(), cuitSocio});
                        }
                    }
                }

                for (SocioProtector socio : cSocio.listaDeSociosProtectores) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accionistas accionista : socio.getListaDeAccionistas()) {
                            model.addRow(new Object[]{accionista.getCuit(), accionista.getRazonSocial(), accionista.getPorcentajeDeParticipacion(), cuitSocio});
                        }
                    }
                }
            }
        });
    }
}
