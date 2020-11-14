package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultasGenerales extends JDialog{
    private JButton btnTotalComisiones;
    private JButton btnOperacionesASocio;
    private JButton btnValorPromedioEnTiempo;
    private JButton btnPorcentajeComision;
    private JButton btnSaldoMora;
    private JButton btnConsultaConsolidada;
    private JPanel frmConsultasGenerales;
    private JPanel frmBotones;
    private JPanel pnlTitle;

    public FrmConsultasGenerales(Window owner) {
        super(owner, "Consultas");

        this.setContentPane(frmConsultasGenerales);
        //this.setSize(300, 300);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //this.eventos();
    }
/*
    private void eventos() {
        nuevaOperaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDetalleOperacion frame = new FrmDetalleOperacion(self);
                frame.setVisible(true);
            }
        });
    }*/
}
