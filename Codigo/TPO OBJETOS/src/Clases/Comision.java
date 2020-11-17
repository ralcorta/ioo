package Clases;

import java.util.*;

public class Comision
{
    private String idComision;
    private String estado;
    private Date fechaCambioEstado;
    private String estadoAnterior;
    private float porcentaje;
    Operacion operacion;
    ArrayList <Factura> facturas = new ArrayList <Factura>();

    public String getIdComision() {
        return idComision;
    }

    public void setIdComision(String idComision) {
        this.idComision = idComision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public Comision(String idComision, String estado, Date fechaCambioEstado, String estadoAnterior, float porcentaje) {
        this.idComision = idComision;
        this.estado = estado;
        this.fechaCambioEstado = fechaCambioEstado;
        this.estadoAnterior = estadoAnterior;
        this.porcentaje = porcentaje;
    }

    public float getPorcentajeComision(){
        return this.porcentaje;
    }

    public int modificarEstado(String estado){ //int o String?
        return 0;
    }

    public String[] emitirFactura(String controladorFiscal, float importe){
        Date fechaDeEmision = new Date();
        Date fechaVencimiento = null;

        Calendar c = Calendar.getInstance();
        c.setTime(fechaDeEmision);
        c.add(Calendar.DAY_OF_YEAR, 20);
        fechaVencimiento = c.getTime();

        int codigoFactura = 100000 + new Random().nextInt(900000);
        String idFactura = controladorFiscal + "-00" + codigoFactura;

        long CAE = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;

        Factura factura = new Factura(idFactura, fechaDeEmision, CAE, importe, fechaVencimiento);
        facturas.add(factura);

        String resultado[] = new String[2];
        resultado[0]= idFactura;
        resultado[1] = String.valueOf(CAE);

        return resultado;
    }

}
