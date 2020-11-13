package GUI;

import javax.swing.*;
import java.awt.*;

public class FrmDetalleSocio extends JDialog{
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

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);

    }
}
