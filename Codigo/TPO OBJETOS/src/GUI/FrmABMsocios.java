package GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        this.setSize(300, 300);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.eventos();

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

