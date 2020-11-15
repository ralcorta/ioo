package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class LineaDeCredito {
    private int idLineaCredito;
    private String importeMaximo;
    private Date fechaDeVigencia;
    private boolean estadoAprobacion;

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

        this.socio = socio;
    }

    public int getIdLineaCredito() {
        return idLineaCredito;
    }

    public void setIdLineaCredito(int idLineaCredito) {
        this.idLineaCredito = idLineaCredito;
    }

    public String getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(String importeMaximo) {
        this.importeMaximo = importeMaximo;
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
