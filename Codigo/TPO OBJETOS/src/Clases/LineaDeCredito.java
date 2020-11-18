package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class LineaDeCredito {
    private int idLineaCredito;
    private String importeMaximo;
    private Date fechaDeVigencia;
    private boolean estadoAprobacion;
    private String importeActual;

    private SocioParticipe socio;
    ArrayList<Operacion> operaciones = new ArrayList<Operacion>();


    public SocioParticipe getSocio() {
        return socio;
    }
    public LineaDeCredito(int idLineaCredito, String importeMaximo, Date fechaDeVigencia, boolean estadoAprobacion, SocioParticipe socio) {
        this.idLineaCredito = idLineaCredito;
        this.importeMaximo = importeMaximo;
        this.fechaDeVigencia = fechaDeVigencia;
        this.estadoAprobacion = estadoAprobacion;
        this.importeActual = importeMaximo;

        this.socio = socio;
    }

    public ArrayList<Operacion> getOperaciones(){
        return this.operaciones;
    }

    public int getIdLineaCredito() {
        return idLineaCredito;
    }

    public void agregarOperacion(Operacion o){
        operaciones.add(o);
    }

    public void restarImporteATotal(String importe) {
        this.importeActual = Integer.toString(Integer.parseInt(importeActual) - Integer.parseInt(importe));
    }

    public void setIdLineaCredito(int idLineaCredito) {
        this.idLineaCredito = idLineaCredito;
    }

    public String getImporteMaximo() {
        return this.importeMaximo;
    }

    public String getImporteActual() {
        return this.importeActual;
    }

    public void setImporteMaximo(String importeMaximo) {
        this.importeMaximo = importeMaximo;
    }

    public void setImporteDisponible(String importe) {
        this.importeActual = importe;
    }

    public Date getFechaDeVigencia() {
        return fechaDeVigencia;
    }

    public void setFechaDeVigencia(Date fechaDeVigencia) {
        this.fechaDeVigencia = fechaDeVigencia;
    }

    public boolean isEstadoAprobacion() {
        return estadoAprobacion;
    }

    public void setEstadoAprobacion(boolean estadoAprobacion) {
        this.estadoAprobacion = estadoAprobacion;
    }
}
