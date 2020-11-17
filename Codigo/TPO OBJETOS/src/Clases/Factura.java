package Clases;

import java.util.Currency;
import java.util.Date;

public class Factura
{
    private String idFactura;
    private Date fechaDeEmision;
    private float importe;
    private String usuarioModificador;
    private Date fechaVencimiento;
    private long CAE;
    Comision comision;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Factura(String idFactura, Date fechaDeEmision, long CAE, float importe, Date fechaVencimiento) {
        this.idFactura = idFactura;
        this.fechaDeEmision = fechaDeEmision;
        this.CAE = CAE;
        this.importe = importe;
        this.fechaVencimiento = fechaVencimiento;
    }
}
