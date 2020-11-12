package Clases;

import java.util.ArrayList;
import java.util.Date;

public class SociosController
{
    ArrayList <SocioProtector> listaDeSociosProtectores = new ArrayList<SocioProtector>();
    ArrayList <SocioParticipe> listaDeSociosParticipes = new ArrayList <SocioParticipe>();
    ArrayList <Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    OperacionController controladorOperaciones;

    /*
    public boolean aprobarSocio(int cuit){
        return true;
    }

    public void registrarAporte(float monto){

    }

    public void calcularComisionSocio(String tipoOperacion, int cuit){

    }

    public void calcularMoraSocio(int cuit) {

    }

    public void consultarRiesgo(int cuit) {

    }*/

    public String aprobarSocio(int cuit){
        boolean encontrado = false;
        SocioProtector auxProtector = null;
        SocioParticipe auxParticipe = null;
        for (SocioProtector s : listaDeSociosProtectores) {
            if (s.getCuit() == cuit){
                encontrado = true;
                auxProtector = s;
            }
        }
        if (encontrado == true){
            if (auxProtector.getEstadoDocumentacion() == true && accionesSuscritasSuficientes(cuit)){
                auxProtector.setEsPleno(true);
                return "socio aprobado con exito";
            }
            else{
                return "el socio protector no cumple las condiciones de aprobacion";
            }
        }
        else{
            for (SocioParticipe s : listaDeSociosParticipes) {
                if(s.getCuit() == cuit){
                    encontrado = true;
                    auxParticipe = s;
                }
            }
            if (encontrado == true){
                if (auxParticipe.getEstadoDocumentacion() == true && accionesSuscritasSuficientes(cuit)){
                    auxParticipe.setEsPleno(true);
                    return "socio aprobado con exito";
                }
                else{
                    return "el socio participe no cumple las condiciones de aprobacion";
                }
            }
        }
        return "socio no encontrado";
    }

    public boolean accionesSuscritasSuficientes(int cuit){
        boolean encontrado = false;
        SocioProtector auxProtector = null;
        SocioParticipe auxParticipe = null;
        for (SocioProtector s : listaDeSociosProtectores) {
            if (s.getCuit() == cuit){
                encontrado = true;
                auxProtector = s;
            }
        }
        if (encontrado == true){
            int contadorAccionesSuscritas = 0;
            for (Accion a : auxProtector.getAccionesSuscritas()){
                contadorAccionesSuscritas++;
            }
            int contadorAcciones = 0;
            for (Accion a : auxProtector.getListaDeAcciones()){
                contadorAcciones++;
            }
            if (contadorAccionesSuscritas >= (0.05*contadorAcciones)){ //segun nuestro criterio, las acciones suscritas deben ser un 5% o mas de las acciones que posee
                return true;
            }
        }
        else{
            for (SocioParticipe s : listaDeSociosParticipes) {
                if(s.getCuit() == cuit){
                    encontrado = true;
                    auxParticipe = s;
                }
            }
            if (encontrado == true){
                int contadorAccionesSuscritas = 0;
                for (Accion a : auxParticipe.getAccionesSuscritas()){
                    contadorAccionesSuscritas++;
                }
                int contadorAcciones = 0;
                for (Accion a : auxParticipe.getListaDeAcciones()){
                    contadorAcciones++;
                }
                if (contadorAccionesSuscritas >= (0.05*contadorAcciones)){ //segun nuestro criterio, las acciones suscritas deben ser un 5% o mas de las acciones que posee
                    return true;
                }
            }
        }
        return false;
    }

    public void cambiarEstadoDocumentacion(int cuit, Boolean estado){
        boolean encontrado = false;
        SocioProtector auxProtector = null;
        SocioParticipe auxParticipe = null;
        for (SocioProtector s : listaDeSociosProtectores) {
            if (s.getCuit() == cuit){
                encontrado = true;
                auxProtector = s;
            }
        }
        if (encontrado == true){
            auxProtector.setEstadoDocumentacion(estado);
        }
        else{
            for (SocioParticipe s : listaDeSociosParticipes) {
                if(s.getCuit() == cuit){
                    encontrado = true;
                    auxParticipe = s;
                }
            }
            if (encontrado == true){
                auxParticipe.setEstadoDocumentacion(estado);
            }
        }
    }

    public String crearSocioParticipe(int cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit() == cuit){
                return "el socio ya existe";
            }
        }
        SocioParticipe nuevoSocioParticipe = new SocioParticipe(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosParticipes.add(nuevoSocioParticipe);
        return "socio creado con exito";
    }

    public String crearSocioProtector(int cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, String fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for (SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit() == cuit){
                return "el socio ya existe";
            }
        }
        SocioProtector nuevoSocioProtector = new SocioProtector(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosProtectores.add(nuevoSocioProtector);
        return "socio creado con exito";
    }

    public String crearAccionista(int cuit, int porcentajeDeParticipacion, String razonSocial){
        for (Accionistas a : listaDeAccionistas) {
            if (a.getCuit() == cuit){
                return "el accionista ya existe";
            }
        }
        Accionistas nuevoAccionista = new Accionistas(cuit, porcentajeDeParticipacion, razonSocial);
        listaDeAccionistas.add(nuevoAccionista);
        return "accionista creado con exito";
    }
}
