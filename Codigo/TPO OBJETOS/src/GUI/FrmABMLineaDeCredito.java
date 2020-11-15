package GUI;

import Clases.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmABMLineaDeCredito extends JDialog {
    private FrmABMLineaDeCredito self;
    private JPanel frmLineaDeCredito;
    private JTable tblSociosPartPlenos;
    private JPanel pnlTabla;
    private JButton renovarLineaDeCreditoButton;
    private JButton buscarButton;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMLineaDeCredito(Window owner, SociosController cSocios, OperacionController cOperacion) {
        super(owner, "Lineas de Credito");

        this.setContentPane(frmLineaDeCredito);
        this.setSize(400, 600);

        model.addColumn("CUIT");
        model.addColumn("Razon Social");
        model.addColumn("¿Posee LdC?");

        updateTabla(cSocios);

        model.fireTableDataChanged();

        tblSociosPartPlenos.setModel(model);

        tblSociosPartPlenos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                renovarLineaDeCreditoButton.setEnabled(true);
            }
        });

        this.eventos(cSocios, cOperacion);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.self = this;
    }

    private void eventos(SociosController cSocios, OperacionController cOperacion)
    {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                updateTabla(cSocios);
                renovarLineaDeCreditoButton.setEnabled(false);
            }
        });

        renovarLineaDeCreditoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tblSociosPartPlenos.getSelectedRow();
                String cuitSocioSel = tblSociosPartPlenos.getValueAt(filaSeleccionada,0).toString();
                String hasLDC = tblSociosPartPlenos.getValueAt(filaSeleccionada,2).toString();

                if(hasLDC == "No") {
                    JOptionPane.showMessageDialog(self, "El socio no posee Linea de Credito a ser renovada.", "Operacion generada correctamente", JOptionPane.ERROR_MESSAGE);
                } else {
                    int statusCode = cOperacion.renovarLineaDeCredito(cuitSocioSel);
                    if(statusCode == 0) {
                        JOptionPane.showMessageDialog(self, "La Linea de Credito del socio con CUIT " + cuitSocioSel + " ha sido renovada por 1 año", "Operacion generada correctamente", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (statusCode == 1){
                        JOptionPane.showMessageDialog(self, "La Linea de Credito del socio con CUIT " + cuitSocioSel + " aun no se encuentra vencida, por lo que no se puede renovar", "Operacion generada correctamente", JOptionPane.WARNING_MESSAGE);
                    }


                }
                model.setRowCount(0);
                updateTabla(cSocios);
                renovarLineaDeCreditoButton.setEnabled(false);
            }
        });

        tblSociosPartPlenos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int filaSeleccionada = tblSociosPartPlenos.getSelectedRow();
                String cuitSocioSel = tblSociosPartPlenos.getValueAt(filaSeleccionada,0).toString();
                String hasLDC = tblSociosPartPlenos.getValueAt(filaSeleccionada,2).toString();
                SocioParticipe socioAux = null;

                for(SocioParticipe s : cSocios.listaDeSociosParticipes){
                    if(s.getCuit().equals(cuitSocioSel)){
                        socioAux = s;
                    }
                }

                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    if(hasLDC == "No") {
                        FrmDetalleLineaDeCredito frame = new FrmDetalleLineaDeCredito(self, cOperacion, socioAux, "Create");
                        frame.setVisible(true);
                    } else {
                        FrmDetalleLineaDeCredito frame = new FrmDetalleLineaDeCredito(self, cOperacion, socioAux, "Update");
                        frame.setVisible(true);
                    }
                }
            }
        });
    }

    public void updateTabla(SociosController cSocios){
        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            if (socio.isEsPleno()) {
                if (socio.getLinea() == null) {
                    model.addRow(new Object[]{socio.getCuit(), socio.getRazonSocial(), "No"});
                } else {
                    model.addRow(new Object[]{socio.getCuit(), socio.getRazonSocial(), "Si"});
                }
            }
        }
    }
}
