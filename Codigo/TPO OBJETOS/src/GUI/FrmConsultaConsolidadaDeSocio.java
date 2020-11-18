package GUI;

import Clases.Operacion;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import Enums.EstadosDefine;
import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FrmConsultaConsolidadaDeSocio extends JDialog {
    private FrmConsultaConsolidadaDeSocio self;
    private JPanel panelTablaSocios;
    private JTable sociosTable;
    private JLabel totalLabel;
    private DefaultTableModel model = new DefaultTableModel();

    public FrmConsultaConsolidadaDeSocio(Window owner, ArrayList<Operacion> operacionesMonetizadas, ArrayList<Operacion> operacionesEmitidas) {
        super(owner, "Consultas");

        this.setContentPane(panelTablaSocios);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

        model.addColumn("ID");
        model.addColumn("Tipo");
        model.addColumn("Importe");

        ArrayList<Operacion> todas = new ArrayList<Operacion>();
        for (Operacion op : operacionesEmitidas) {
            todas.add(op);
        }

        for (Operacion op : operacionesMonetizadas) {
            model.addRow(new Object[]{op.getCuitCheque(), op.getTipoDeOperacion(), op.getImporte()});
            todas.add(op);
        }

        model.fireTableDataChanged();

        sociosTable.setModel(model);

        this.self = this;

        //riesgo vivo + todos los importes de todas las ops con cert (estado) emitido
        Double total = 0.0;
        for (Operacion op : todas) {
            total += Double.parseDouble(op.getImporte());
        }

        totalLabel.setText(total.toString());
    }
}
