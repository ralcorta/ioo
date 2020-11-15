package Clases;

import java.util.ArrayList;
import java.util.Date;

public class SocioParticipe
{
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
    ArrayList<Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    ArrayList<Accion> listaDeAcciones = new ArrayList<Accion>();
    ArrayList<Accion> accionesSuscritas = new ArrayList<Accion>();
    SociosController controlador;
    LineaDeCredito linea;


    public ArrayList<Accionistas> getListaDeAccionistas() {
        return listaDeAccionistas;
    }

    public ArrayList<Accion> getListaDeAcciones() {
        return listaDeAcciones;
    }

    public ArrayList<Accion> getAccionesSuscritas() {
        return accionesSuscritas;
    }

    public LineaDeCredito getLinea() { return linea; }

    public void setLinea(LineaDeCredito linea) { this.linea = linea; }

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

    public String crearAccion (int idAccion, String tipo){
        for (Accion a : listaDeAcciones){
            if(a.getIdAccion() == idAccion){
                return "la accion ya existe";
            }
        }
        Accion nuevaAccion = new Accion(idAccion, tipo);
        listaDeAcciones.add(nuevaAccion);
        return "accion creada con exito";
    }

    public String suscribirAccion(int idAccion){
        for (Accion a: listaDeAcciones) {
            if (a.getIdAccion() == idAccion && a.getTipo() == "A"){
                accionesSuscritas.add(a);
                return "accion suscrita con exito";
            }
            else{
                return "los socios participes solamente suscriben acciones tipo A";
            }
        }
        return "accion no encontrada";
    }

    public SocioParticipe(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion) {
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

    public void suscribirAcciones(){

    }

    public void extraerInfo(){ //Deberia ser tipo List, pero no se implementarlo

    }
}
