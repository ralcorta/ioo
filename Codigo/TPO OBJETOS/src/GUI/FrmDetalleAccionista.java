package GUI;

import Clases.SociosController;
import Clases.Validator;

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
                if (!Validator.isCuit(textCUITAccionista.getText())){
                    JOptionPane.showMessageDialog(null, "el CUIT ingresado es incorrecto o el campo esta vacio", "CUIT incorrecto", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!Validator.isNumeric(textPorcentajeParticipacion.getText())){
                    JOptionPane.showMessageDialog(null, "el porcentaje de participacion es incorrecto", "Porcentaje de participacion incorrecto", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (textRazonSocial == null){
                    JOptionPane.showMessageDialog(null, "el campo razon social esta vacio", "Razon social vacio", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String resultado = cSocios.crearAccionista(textCUITAccionista.getText(),Integer.parseInt(textPorcentajeParticipacion.getText()), textRazonSocial.getText(), cuitSocio);
                JOptionPane.showMessageDialog(null, resultado, "Operacion creada correctamente", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }
}
