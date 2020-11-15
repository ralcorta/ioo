package GUI;

import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmABMsocios extends JDialog{
    private FrmABMsocios self;
    private JButton nuevoSocioButton;
    private JPanel panelSocios;
    private JPanel panelTituloSocios;
    private JPanel panelTablaSocios;
    private JTable sociosTable;
    private JButton buscarButton;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMsocios(Window owner, SociosController cSocios) {
        super(owner, "Socios");

        this.setContentPane(panelSocios);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        model.addColumn("CUIT");
        model.addColumn("Razon Social");

        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            model.addRow(new Object[] {socio.getCuit(), socio.getRazonSocial()});
        }

        for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
            model.addRow(new Object[] {socio.getCuit(), socio.getRazonSocial()});
        }

        model.fireTableDataChanged();

        sociosTable.setModel(model);

        this.eventos(cSocios);

        this.self = this;
    }

    private void eventos(SociosController cSocios)
    {
        nuevoSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleSocio frame = new FrmDetalleSocio(self, cSocios);
                frame.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
                    model.addRow(new Object[] {socio.getCuit(), socio.getRazonSocial()});
                }

                for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
                    model.addRow(new Object[] {socio.getCuit(), socio.getRazonSocial()});
                }
            }
        });

        sociosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int filaSeleccionada = sociosTable.getSelectedRow();
                System.out.println(filaSeleccionada);
                String cuitSocioSel = sociosTable.getValueAt(filaSeleccionada,0).toString();


                for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
                    if(socio.getCuit().equals(cuitSocioSel)){
                        FrmDetalleSocio frame = new FrmDetalleSocio(self, cSocios, socio);
                        frame.setVisible(true);
                    }
                }

                for (SocioProtector socio : cSocios.listaDeSociosProtectores) {
                    if (socio.getCuit().equals(cuitSocioSel)) {
                        if(socio.getCuit().equals(cuitSocioSel)){
                            FrmDetalleSocio frame = new FrmDetalleSocio(self, cSocios, socio);
                            frame.setVisible(true);
                        }
                    }
                }
            }
        });
    }
}
