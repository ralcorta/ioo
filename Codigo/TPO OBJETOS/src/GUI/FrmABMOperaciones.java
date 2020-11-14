package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmABMOperaciones extends JDialog{
    private FrmABMOperaciones self;
    private JPanel panelOperaciones;
    private JPanel panelTituloOperaciones;
    private JPanel panelBotonesOperaciones;
    private JTable tablaDeCuits;
    private JButton nuevaOperaciónButton;

    public FrmABMOperaciones(Window owner) {
        super(owner, "Operaciones");

        this.setContentPane(panelOperaciones);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos();

        this.self = this;

    }

    private void eventos() {
        nuevaOperaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleOperacion frame = new FrmDetalleOperacion(self);
                frame.setVisible(true);
            }
        });
    }
}
