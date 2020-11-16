package GUI;

import Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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
        model.addColumn("¿Accion suscripta?");
        this.setLocationRelativeTo(null);
        model.fireTableDataChanged();
        tablaDeAcciones.setModel(model);

        drawAccionesTable(cSocios, cuitSocio);

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
                drawAccionesTable(cSocios, cuitSocio);
            }
        });

        suscribirAccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaDeAcciones.getSelectedRow();
                String idAccionSel = tablaDeAcciones.getValueAt(filaSeleccionada,0).toString();
                Accion auxAccion = null;
                String response = null;

                for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accion a : socio.getListaDeAcciones()) {
                            if (a.getIdAccion().equals(idAccionSel)){
                                auxAccion = a;
                            }
                        }
                    }
                }

                for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
                    if(socio.getCuit().equals(cuitSocio)) {
                        for(Accion a : socio.getListaDeAcciones()) {
                            if (a.getIdAccion().equals(idAccionSel)){
                                auxAccion = a;
                            }
                        }
                    }
                }

                if(auxAccion != null) {
                    response = cSocios.suscribirAccion(cuitSocio, auxAccion);
                    JOptionPane.showMessageDialog(null, response, "Accion creada con exito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void drawAccionesTable(SociosController cSocios, String cuitSocio){
        model.setRowCount(0);
        boolean aSus = false;

        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accion a : socio.getListaDeAcciones()) {
                    for(Accion aSusc : socio.getAccionesSuscritas()) {
                        aSus = false;
                        if(a.getIdAccion().equals(aSusc.getIdAccion())) {
                            aSus = true;
                        }
                    }
                    if(aSus) {
                        model.addRow(new Object[]{a.getIdAccion(), a.getTipo(), "Si"});
                    } else {
                        model.addRow(new Object[]{a.getIdAccion(), a.getTipo(), "No"});
                    };
                }
            }
        }

        for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
            if(socio.getCuit().equals(cuitSocio)) {
                for(Accion a : socio.getListaDeAcciones()) {
                    aSus = false;
                    for(Accion aSusc : socio.getAccionesSuscritas()) {
                        if(a.getIdAccion().equals(aSusc.getIdAccion())) {
                            aSus = true;
                        }
                    }
                    if(aSus) {
                        model.addRow(new Object[]{a.getIdAccion(), a.getTipo(), "Si"});
                    } else {
                        model.addRow(new Object[]{a.getIdAccion(), a.getTipo(), "No"});
                    };
                }
            }
        }
    }
}
