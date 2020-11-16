package Clases;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class SocioProtector{
    private String cuit;
    private String razonSocial;
    private Date fechaInicioActividades;
    private String tipo;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private boolean esPleno;
    private String documentacion;
    private Date fechaDocumentacion;
    private Boolean estadoDocumentacion;
    private String usuarioDocumentacion;
    ArrayList<Aportes> listaDeAportes = new ArrayList<Aportes>();
    ArrayList<Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    ArrayList<Accion> listaDeAcciones = new ArrayList<Accion>();
    ArrayList<Accion> accionesSuscritas = new ArrayList<Accion>();
    SociosController controlador;

    public ArrayList<Aportes> getListaDeAportes() {
        return listaDeAportes;
    }

    public ArrayList<Accionistas> getListaDeAccionistas() {
        return listaDeAccionistas;
    }

    public ArrayList<Accion> getListaDeAcciones() {
        return listaDeAcciones;
    }

    public ArrayList<Accion> getAccionesSuscritas() {
        return accionesSuscritas;
    }

    public void agregarAccionista(Accionistas accionista){
        listaDeAccionistas.add(accionista);
    }

    public SocioProtector(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion) {
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
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

    public Date getFechaDocumentacion() {
        return fechaDocumentacion;
    }

    public void setFechaDocumentacion(Date fechaDocumentacion) {
        this.fechaDocumentacion = fechaDocumentacion;
    }

    public Boolean getEstadoDocumentacion() {
        return estadoDocumentacion;
    }

    public void setEstadoDocumentacion(Boolean estadoDocumentacion) {
        this.estadoDocumentacion = estadoDocumentacion;
    }

    public String getUsuarioDocumentacion() {
        return usuarioDocumentacion;
    }

    public void setUsuarioDocumentacion(String usuarioDocumentacion) {
        this.usuarioDocumentacion = usuarioDocumentacion;
    }

    public void realizarAporte(Currency monto, Date fechaActual, int idAporte){
        Aportes aporte = new Aportes (monto, fechaActual, idAporte);
        listaDeAportes.add(aporte);
    }

    public String reclamarAporte(int idAporte){
        for (Aportes a : listaDeAportes) {
            if(a.getIdAporte() == idAporte){
                listaDeAportes.remove(a);
                return "aporte removido con exito";
            }
        }
        return"aporte no encontrado";
    }

    public String suscribirAccion(String idAccion){
        for (Accion a: listaDeAcciones) {
            if (a.getIdAccion().equals(idAccion) && a.getTipo() == "B"){
                accionesSuscritas.add(a);
                return "accion suscrita con exito";
            }
            else{
                return "los socios protectores solamente suscriben acciones tipo B";
            }
        }
        return "accion no encontrada";
    }

    public String crearAccion (String idAccion, String tipo){
        for (Accion a : listaDeAcciones){
            if(a.getIdAccion().equals(idAccion)){
                return "la accion ya existe";
            }
        }
        Accion nuevaAccion = new Accion(idAccion, tipo);
        listaDeAcciones.add(nuevaAccion);
        return "accion creada con exito";
    }
}
