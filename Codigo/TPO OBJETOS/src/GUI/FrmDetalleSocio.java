package GUI;

import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDetalleSocio extends JDialog {
    private FrmDetalleSocio self;
    private JPanel panelTituloDetalleSocio;
    private JTextField textCuitSocio;
    private JTextField textRazonSocial;
    private JTextField textFechaInicioAct;
    private JTextField textTipoSocio;
    private JTextField textActPrincipal;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JTextField textEmail;
    private JTextField textDocumentacion;
    private JTextField textFechaDocumentacion;
    private JTextField textEstadoDocumentacion;
    private JTextField textUsuarioDeIngreso;
    private JComboBox comboBoxSocioPleno;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel panelFormularioSocios;

    public FrmDetalleSocio(Window owner) {
        super(owner, "Detalle de Socio");
        this.setContentPane(panelTituloDetalleSocio);
        //this.setSize(300, 300);
        comboBoxSocioPleno.addItem("No");
        comboBoxSocioPleno.addItem("Si");
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
