package GUI;

import Clases.SociosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JPanel pnlPrincipal;


    public FrmDetalleAccionista(Window owner, SociosController cSocios, String cuitSocio) {
        super(owner, "Detalle de Accionista");
        this.setContentPane(pnlPrincipal);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        textCUITSocio.setText(cuitSocio);
        textCUITSocio.setEnabled(false);

        this.eventos(cSocios, cuitSocio);

        this.self = this;
    }

    private void eventos(SociosController cSocios, String cuitSocio)
    {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String resultado = cSocios.crearAccionista(textCUITAccionista.getText(),Integer.parseInt(textPorcentajeParticipacion.getText()), textRazonSocial.getText(), cuitSocio);
                JOptionPane.showMessageDialog(null, resultado, "Operacion creada correctamente", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }
}
