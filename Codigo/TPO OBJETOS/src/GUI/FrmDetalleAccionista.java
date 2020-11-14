package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDetalleAccionista extends JDialog {
    private FrmDetalleAccionista self;
    private JPanel panelCreacionAccionista;
    private JTextField textCUITAccionista;
    private JTextField textPorcentajeParticipacion;
    private JTextField textRazonSocial;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField textCUITSocio;

    public FrmDetalleAccionista(Window owner) {
        super(owner, "Detalle de Accionista");
        this.setContentPane(panelCreacionAccionista);
        //this.setSize(300, 300);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos();

        this.self = this;
    }

    private void eventos()
    {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}
