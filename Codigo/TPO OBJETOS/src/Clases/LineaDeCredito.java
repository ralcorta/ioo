package Clases;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class LineaDeCredito {
    private int idLineaCredito;
    private Currency importeMaximo;
    private Date fechaDeVigencia;
    private boolean estadoAprobacion;
    private Date fechaCambioEstado;
    private String estadoAnterior;
    private String usuarioModificador;
    private SocioParticipe socio;
    ArrayList<Operacion> operaciones = new ArrayList<Operacion>();


    public SocioParticipe getSocio() {
        return socio;
    }
    public LineaDeCredito(int idLineaCredito, Currency importeMaximo, Date fechaDeVigencia, boolean estadoAprobacion, Date fechaCambioEstado, String estadoAnterior, String usuarioModificador) {
        this.idLineaCredito = idLineaCredito;
        this.importeMaximo = importeMaximo;
        this.fechaDeVigencia = fechaDeVigencia;
        this.estadoAprobacion = estadoAprobacion;
        this.fechaCambioEstado = fechaCambioEstado;
        this.estadoAnterior = estadoAnterior;
        this.usuarioModificador = usuarioModificador;
    }

    public int getIdLineaCredito() {
        return idLineaCredito;
    }

    public void setIdLineaCredito(int idLineaCredito) {
        this.idLineaCredito = idLineaCredito;
    }

    public Currency getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(Currency importeMaximo) {
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

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }



}
