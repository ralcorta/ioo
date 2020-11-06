package Clases;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class SocioProtector{
    private int cuit;
    private String razonSocial;
    private Date fechaInicioActividades;
    private String tipo;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private boolean esPleno;
    private String documentacion;
    private String fechaDocumentacion;
    private String estadoDocumentacion;
    private String usuarioDocumentacion;
    ArrayList<Aportes> listaDeAportes = new ArrayList<Aportes>();
    ArrayList<Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    SociosController controlador;

    public SocioProtector(int cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, String fechaDocumentacion, String estadoDocumentacion, String usuarioDocumentacion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaInicioActividades = fechaInicioActividades;
        this.tipo = tipo;
        this.actividadPrincipal = actividadPrincipal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.esPleno = esPleno;
        this.documentacion = documentacion;
        this.fechaDocumentacion = fechaDocumentacion;
        this.estadoDocumentacion = estadoDocumentacion;
        this.usuarioDocumentacion = usuarioDocumentacion;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(Date fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isEsPleno() {
        return esPleno;
    }

    public void setEsPleno(boolean esPleno) {
        this.esPleno = esPleno;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public String getFechaDocumentacion() {
        return fechaDocumentacion;
    }

    public void setFechaDocumentacion(String fechaDocumentacion) {
        this.fechaDocumentacion = fechaDocumentacion;
    }

    public String getEstadoDocumentacion() {
        return estadoDocumentacion;
    }

    public void setEstadoDocumentacion(String estadoDocumentacion) {
        this.estadoDocumentacion = estadoDocumentacion;
    }

    public String getUsuarioDocumentacion() {
        return usuarioDocumentacion;
    }

    public void setUsuarioDocumentacion(String usuarioDocumentacion) {
        this.usuarioDocumentacion = usuarioDocumentacion;
    }

    public void reclamarAporte(Currency monto, Date fechaActual){
        Aportes aporte = new Aportes (monto, fechaActual);
        listaDeAportes.add(aporte);
    }
}
