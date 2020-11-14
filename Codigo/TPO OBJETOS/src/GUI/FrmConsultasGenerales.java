package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultasGenerales extends JDialog{
    private FrmConsultasGenerales self;
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

        this.eventos();

        this.self = this;
    }

    private void eventos() {
        btnTotalComisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cuit=JOptionPane.showInputDialog(self,"Ingrese el CUIT del Socio:");
            }
        });

        btnOperacionesASocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cuit=JOptionPane.showInputDialog(self,"Ingrese el CUIT del Socio:");
            }
        });

        btnValorPromedioEnTiempo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fechaDesde=JOptionPane.showInputDialog(self,"Ingrese la fecha desde:");
                String fechaHasta=JOptionPane.showInputDialog(self,"Ingrese la fecha hasta:");
            }
        });

        btnPorcentajeComision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fechaDesde=JOptionPane.showInputDialog(self,"Texto futuro:");
            }
        });

        btnSaldoMora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fechaDesde=JOptionPane.showInputDialog(self,"Texto futuro:");
            }
        });

        btnConsultaConsolidada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fechaDesde=JOptionPane.showInputDialog(self,"Texto futuro:");
            }
        });
    }
}
