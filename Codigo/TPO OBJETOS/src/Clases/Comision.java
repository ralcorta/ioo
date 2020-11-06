package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class Comision
{
    private int idComision;
    private String estado;
    private Date fechaCambioEstado;
    private String estadoAnterior;
    Operacion operacion;
    ArrayList <Factura> facturas = new ArrayList <Factura>();

    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
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

    public Comision(int idComision, String estado, Date fechaCambioEstado, String estadoAnterior) {
        this.idComision = idComision;
        this.estado = estado;
        this.fechaCambioEstado = fechaCambioEstado;
        this.estadoAnterior = estadoAnterior;
    }

    public int modificarEstado(String estado){ //int o String?
        return 0;
    }

    public void emitirFactura(int idFactura, Date fechaDeEmision, Currency importe, String usuarioModificador, Date fechaVencimiento){
        Factura factura = new Factura(idFactura, fechaDeEmision, importe, usuarioModificador, fechaVencimiento);
        facturas.add(factura);
    }
}
