package GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmABMsocios extends JDialog{
    private FrmABMsocios self;
    private JButton nuevoSocioButton;
    private JPanel panelSocios;
    private JPanel panelTituloSocios;
    private JPanel panelTablaSocios;
    private JTable sociosTable;


    public FrmABMsocios(Window owner) {
        super(owner, "Socios");

        this.setContentPane(panelSocios);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.eventos();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("CUIT");
        model.addColumn("Razon Social");

        model.addRow(new Object[] { "20400067385", "Rodrigo Sosa"});

        sociosTable.setModel(model);

        this.self = this;
    }

    private void eventos()
    {
        nuevoSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleSocio frame = new FrmDetalleSocio(self);
                frame.setVisible(true);
            }
        });
    }
}

