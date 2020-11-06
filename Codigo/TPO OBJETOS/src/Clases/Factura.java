package Clases;

import java.util.Currency;
import java.util.Date;

public class Factura
{
    private int idFactura;
    private Date fechaDeEmision;
    private Currency importe;
    private String usuarioModificador;
    private Date fechaVencimiento;
    Comision comision;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public Currency getImporte() {
        return importe;
    }

    public void setImporte(Currency importe) {
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

    public Factura(int idFactura, Date fechaDeEmision, Currency importe, String usuarioModificador, Date fechaVencimiento) {
        this.idFactura = idFactura;
        this.fechaDeEmision = fechaDeEmision;
        this.importe = importe;
        this.usuarioModificador = usuarioModificador;
        this.fechaVencimiento = fechaVencimiento;
    }
}
