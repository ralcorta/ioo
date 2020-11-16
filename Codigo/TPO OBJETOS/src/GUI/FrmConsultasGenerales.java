package GUI;

import Clases.OperacionController;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public FrmConsultasGenerales(Window owner, SociosController cSocios, OperacionController cOperacion) {
        super(owner, "Consultas");

        this.setContentPane(frmConsultasGenerales);
        //this.setSize(300, 300);

        this.pack();

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(cSocios, cOperacion);

        this.self = this;
    }

    private void eventos(SociosController cSocios, OperacionController cOperacion) {
        btnTotalComisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                float totalComision = 0.0f;
                String fecha = JOptionPane.showInputDialog(self,"Ingrese la fecha (DD/MM/YYYY) para calcular la comisión de operaciones monetizadsa con Cheque:");

                try {
                    totalComision = cOperacion.totalComisionConChequeDia(new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
                    JOptionPane.showMessageDialog(null, "El total de comisiones en el dia " + fecha + "es " + totalComision + "$", "Reporte comisiones con cheques", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(self,"La fecha ingresada NO cumple con el formato DD/MM/YYYY", "ERROR: Fecha invalida", JOptionPane.ERROR_MESSAGE);
                }
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
