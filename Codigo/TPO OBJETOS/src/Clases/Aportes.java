package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class Aportes
{
    private Currency monto;
    private Date fechaDeCreacion;
    ArrayList <SocioProtector> listaDeSociosAportantes = new ArrayList <SocioProtector>();

    public Currency getMonto() {
        return monto;
    }

    public void setMonto(Currency monto) {
        this.monto = monto;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Aportes(Currency monto, Date fechaDeCreacion) {
        this.monto = monto;
        this.fechaDeCreacion = fechaDeCreacion;
    }
}
