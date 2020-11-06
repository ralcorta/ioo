package Clases;

import java.util.Date;

public class CuentaCorriente {
    private String nombreEmpresa;
    private Date fechaDeVencimiento;
    private Operacion operacion;

    public CuentaCorriente(String nombreEmpresa, Date fechaDeVencimiento) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaDeVencimiento = fechaDeVencimiento;
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
}
