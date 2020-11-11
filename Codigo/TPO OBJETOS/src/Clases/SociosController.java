package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SociosController
{
    ArrayList <SocioProtector> listaDeSociosProtectores = new ArrayList<SocioProtector>();
    ArrayList <SocioParticipe> listaDeSociosParticipes = new ArrayList <SocioParticipe>();
    ArrayList <Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    OperacionController controlador;

    /*public void registrarDocumentacion(String tipoDoc, Date fechaDeRecepcion, String estado, String usuario){

    }

    public boolean aprobarSocio(int cuit){
        return true;
    }

    public int cambiarEstadoDocumentacion(int cuit, String estado){
        return 0;
    }

    public void registrarAporte(float monto){

    }

    public void calcularComisionSocio(String tipoOperacion, int cuit){

    }

    public void calcularMoraSocio(int cuit) {

    }

    public void consultarRiesgo(int cuit) {

    }*/

    public void crearSocioParticipe(int cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, String estadoDocumentacion, String usuarioDocumentacion){
        SocioParticipe nuevoSocioParticipe = new SocioParticipe(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosParticipes.add(nuevoSocioParticipe);
    }

    public void crearSocioProtector(int cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, String fechaDocumentacion, String estadoDocumentacion, String usuarioDocumentacion){
        SocioProtector nuevoSocioProtector = new SocioProtector(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosProtectores.add(nuevoSocioProtector);
    }

    public void crearAccionista(int cuit, int porcentajeDeParticipacion, String razonSocial){

    }
}
