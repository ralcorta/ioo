package GUI;

import Clases.OperacionController;
import Clases.SociosController;

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
    private JButton btnRefresh;

    public FrmABMOperaciones(Window owner, SociosController controladorSocios, OperacionController controladorOperacion) {
        super(owner, "Operaciones");

        this.setContentPane(panelOperaciones);
        this.setSize(400, 600);

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(controladorSocios, controladorOperacion);

        this.self = this;

    }

    private void eventos(SociosController controladorSocios, OperacionController controladorOperacion) {
        nuevaOperaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleOperacion frame = new FrmDetalleOperacion(self, controladorSocios, controladorOperacion);
                frame.setVisible(true);
            }
        });
    }
}
