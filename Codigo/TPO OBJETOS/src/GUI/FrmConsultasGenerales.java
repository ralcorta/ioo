package GUI;

import Clases.Operacion;
import Clases.OperacionController;
import Clases.SociosController;
import Clases.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

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
                String fecha = JOptionPane.showInputDialog(self,"Ingrese la fecha (DD/MM/YYYY) para calcular la comisión de operaciones monetizadas con Cheque:");
                if(!Validator.isDate(fecha)){
                    JOptionPane.showMessageDialog(self,"La fecha ingresada NO cumple con el formato DD/MM/YYYY", "ERROR: Fecha vacia", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    try {
                        totalComision = cOperacion.totalComisionConChequeDia(new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "El total de comisiones en el dia " + fecha + " es " + totalComision + "$", "Reporte comisiones con cheques", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnOperacionesASocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cuit = JOptionPane.showInputDialog(self, "Ingrese el CUIT del Socio:");

                if(cuit==null || cuit.length() == 0 || !Validator.isCuit(cuit)){
                    JOptionPane.showMessageDialog(self, "El CUIT debe ser numerico y tener entre 1 y 11 caracteres", "ERROR: Fecha invalida", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String fechaDesde = JOptionPane.showInputDialog(self,"Ingrese la fecha desde la que desea buscar:");
                String fechaHasta = JOptionPane.showInputDialog(self,"Ingrese la fecha hasta la que desea buscar:");
                ArrayList <Operacion> operaciones = new ArrayList<Operacion>();
                try {
                    operaciones = cOperacion.operacionesDeSocioEnUnPeriodo(cuit, new SimpleDateFormat("dd/MM/yyyy").parse(fechaDesde), new SimpleDateFormat("dd/MM/yyyy").parse(fechaHasta));
                    if(operaciones.size() == 0){
                        JOptionPane.showMessageDialog(self, "No se encontraron operaciones para el cliente indicado en las fechas indicadas: ");
                        } else {
                        JOptionPane.showMessageDialog(self, "Entre la fecha " + fechaDesde + " y la fecha " + fechaHasta + " se encontraron las siguientes operaciones: ");
                        for (Operacion opAux : operaciones) {
                            JOptionPane.showMessageDialog(self, "Id operacion: " + opAux.getIdOperacion());
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(self, "La fecha ingresada NO cumple con el formato DD/MM/YYYY", "ERROR: Fecha invalida", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnValorPromedioEnTiempo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String tipoEmpresa=JOptionPane.showInputDialog(self,"Por favor ingrese el tipo de empresa: ");

                    if(tipoEmpresa == null){
                        return;
                    }
                    if(tipoEmpresa == "") {
                        JOptionPane.showMessageDialog(self, "el tipo de empresa no puede estar vacio", "ERROR: El campo tipo empresa esta vacio", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String fechaDesde=JOptionPane.showInputDialog(self,"Ingrese la fecha desde la que desea buscar:");
                    Date fechaDesdeObj = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDesde);

<<<<<<< HEAD
=======
                    if(fechaDesde == null){
                        return;
                    }
>>>>>>> 338d1e6797aa41a31479bbcb50e85af6f466f04c
                    if(!Validator.isDate(fechaDesde)){
                        JOptionPane.showMessageDialog(self, "El campo fecha no puede ser vacio", "ERROR: campo fecha vacio", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String fechaHasta=JOptionPane.showInputDialog(self,"Ingrese la fecha hasta la que desea buscar:");

                    if(fechaHasta == null){
                        return;
                    }

                    Date fechaHastaObj = new SimpleDateFormat("dd/MM/yyyy").parse(fechaHasta);
                    if(!Validator.isDate(fechaHasta)){
                        JOptionPane.showMessageDialog(self, "La fecha hasta no es valida", "ERROR: campo fecha incorrecto", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(!fechaHastaObj.after(fechaDesdeObj)) {
                        JOptionPane.showMessageDialog(self, "La fecha 'hasta' es menor que la de 'desde'", "ERROR: campo fecha incorrecto", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String mensaje = cOperacion.valorPromedioTasaDescuento(tipoEmpresa, fechaDesdeObj, fechaHastaObj);
                    JOptionPane.showMessageDialog(self, mensaje);
                } catch (ParseException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(self, "La fecha ingresada NO cumple con el formato DD/MM/YYYY", "ERROR: Fecha invalida", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnPorcentajeComision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cuit = JOptionPane.showInputDialog(self,"Ingrese el CUIT del Socio:");
                if(cuit == null){
                    return;
                }
                if(!Validator.isCuit(cuit)){
                    JOptionPane.showMessageDialog(self, "El cuit es invalido", "ERROR: cuit invalido", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String tipoDeOperacion = JOptionPane.showInputDialog(self,"Ingrese el Tipo de Operación a consultar:");
                if(tipoDeOperacion == null){
                    return;
                }
                if(tipoDeOperacion == ""){
                    JOptionPane.showMessageDialog(self, "El tipo de operacion es invalida", "ERROR: operacion invalido", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(cuit.length() == 0 && tipoDeOperacion.length() == 0){
                    JOptionPane.showMessageDialog(self, "Debe ingresarse un CUIT o el tipo de operacion.", "ERROR: Se ingreso un campo vacio", JOptionPane.ERROR_MESSAGE);
                }

                float totalComisiones = cSocios.calcularComisionSocio(tipoDeOperacion, cuit);
                JOptionPane.showMessageDialog(self, "El total de comisiones del socio es: " + totalComisiones + "$", "Total de comisiones", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnConsultaConsolidada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cuitSocio = JOptionPane.showInputDialog(self,"Cuit del socio:");
                ArrayList<Operacion> opFiltered = new ArrayList<Operacion>();
                ArrayList<Operacion> ops = cOperacion.getOperaciones();

                for (Operacion op : ops) {
                    if(op.getCuitCheque().equals(cuitSocio) && op.esRiesgoVivo())
                        opFiltered.add(op);
                }

                FrmConsultaConsolidadaDeSocio frame = new FrmConsultaConsolidadaDeSocio(self, opFiltered);
                frame.setVisible(true);
            }

        });
    }
}
