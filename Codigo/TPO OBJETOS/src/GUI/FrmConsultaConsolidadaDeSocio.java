package GUI;

import Clases.Operacion;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmConsultaConsolidadaDeSocio extends JDialog {
    private FrmConsultaConsolidadaDeSocio self;
    private JPanel panelTablaSocios;
    private JTable sociosTable;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmConsultaConsolidadaDeSocio(Window owner, ArrayList<Operacion> operaciones) {
        super(owner, "Consultas");

        this.setContentPane(panelTablaSocios);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        model.addColumn("CUIT");

        for (Operacion op : operaciones) {
            model.addRow(new Object[]{op.getCuitCheque()});
        }

        model.fireTableDataChanged();

        sociosTable.setModel(model);

        this.self = this;
    }
}
