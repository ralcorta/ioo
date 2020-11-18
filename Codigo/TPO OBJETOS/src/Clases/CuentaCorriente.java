package Clases;

import java.util.Date;

public class CuentaCorriente {
    private String nombreEmpresa;
    private Date fechaDeVencimiento;
    private Operacion operacion;
    private float importe;


    public CuentaCorriente(String nombreEmpresa, Date fechaDeVencimiento, float importe) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.importe = importe;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
