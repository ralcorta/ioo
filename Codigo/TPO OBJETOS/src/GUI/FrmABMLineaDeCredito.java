package GUI;

import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmABMLineaDeCredito extends JDialog {
    private FrmABMLineaDeCredito self;
    private JPanel frmLineaDeCredito;
    private JTable tblSociosPartPlenos;
    private JPanel pnlTabla;
    private JButton renovarLineaDeCreditoButton;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmABMLineaDeCredito(Window owner, SociosController cSocios, OperacionController cOperacion) {
        super(owner, "Lineas de Credito");

        this.setContentPane(frmLineaDeCredito);
        this.setSize(400, 600);

        model.addColumn("CUIT");
        model.addColumn("Razon Social");
        model.addColumn("¿Posee LdC?");

        for (SocioParticipe socio : cSocios.listaDeSociosParticipes) {
            if(socio.isEsPleno()) {
                if(socio.getLinea() == null) {
                    model.addRow(new Object[]{socio.getCuit(), socio.getRazonSocial(), "No"});
                } else {
                    model.addRow(new Object[]{socio.getCuit(), socio.getRazonSocial(), "Si"});
                }
            }
        }

        model.fireTableDataChanged();

        tblSociosPartPlenos.setModel(model);

        this.eventos(cSocios, cOperacion);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.self = this;
    }

    private void eventos(SociosController cSocios, OperacionController cOperacion)
    {
        tblSociosPartPlenos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int filaSeleccionada = tblSociosPartPlenos.getSelectedRow();
                System.out.println(filaSeleccionada);
                String cuitSocioSel = tblSociosPartPlenos.getValueAt(filaSeleccionada,0).toString();
                SocioParticipe socioAux = null;

                for(SocioParticipe s : cSocios.listaDeSociosParticipes){
                    if(s.getCuit().equals(cuitSocioSel)){
                        socioAux = s;
                    }
                }

                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    FrmDetalleLineaDeCredito frame = new FrmDetalleLineaDeCredito(self, cOperacion, socioAux);
                    frame.setVisible(true);
                }
            }
        });
    }
}
