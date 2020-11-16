package GUI;

import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDetalleAcciones extends JDialog{
    private JPanel panelPrincipal;
    private JTextField textIDAccion;
    private JPanel panelDetalleAccion;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JComboBox comboBoxTipoAccion;
    private FrmDetalleAcciones self;

    public FrmDetalleAcciones(Window owner, SociosController cSocios, String cuitSocio) {
        super(owner, "Detalle de Accion");
        this.setContentPane(panelPrincipal);
        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.self = this;
        comboBoxTipoAccion.addItem("A");
        comboBoxTipoAccion.addItem("B");
        this.eventos(cSocios,cuitSocio);
    }

    private void eventos(SociosController cSocios, String cuitSocio)
    {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (SocioParticipe s: cSocios.listaDeSociosParticipes) {
                    if(cuitSocio.equals(s.getCuit())){
                        String idAccion = Integer.toString(s.getListaDeAcciones().size()+1);
                        String resultado = s.crearAccion(idAccion, comboBoxTipoAccion.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null, resultado, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                for (SocioProtector s: cSocios.listaDeSociosProtectores) {
                    if(cuitSocio.equals(s.getCuit())){
                        String idAccion = Integer.toString(s.getListaDeAcciones().size()+1);
                        String resultado = s.crearAccion(idAccion, comboBoxTipoAccion.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null, resultado, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                dispose();
            }
        });


    }
}
