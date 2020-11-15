package Clases;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SociosController
{
    public ArrayList <SocioProtector> listaDeSociosProtectores = new ArrayList<SocioProtector>();
    public ArrayList <SocioParticipe> listaDeSociosParticipes = new ArrayList <SocioParticipe>();
    ArrayList <Accionistas> listaDeAccionistas = new ArrayList<Accionistas>();
    OperacionController controladorOperaciones;

    public SociosController(OperacionController controladorOperacion) throws ParseException {
        this.controladorOperaciones = controladorOperacion;
        // JOptionPane.showMessageDialog(null, "Testing");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String dateStringCommon = "10/10/1991";
        Date commonDate = df.parse(dateStringCommon);
        this.crearSocioParticipe("20121231238",
                "Usuario de prueba",
                commonDate,
                "1",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                commonDate,
                true,
                "Usuario de ingreso");
    }

    /*
    public boolean aprobarSocio(int cuit){
        return true;
    }

    public void registrarAporte(float monto){

    }

    public void calcularComisionSocio(String tipoOperacion, int cuit){

    }*/

    public void calcularMoraSocio(int cuit) {

    }

    /*
    public void consultarRiesgo(int cuit) {

    }*/

    public String aprobarSocio(String cuit){
        boolean encontrado = false;
        SocioProtector auxProtector = null;
        SocioParticipe auxParticipe = null;
        for (SocioProtector s : listaDeSociosProtectores) {
            if (s.getCuit().equals(cuit)){
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
                if(s.getCuit().equals(cuit)){
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

    public boolean accionesSuscritasSuficientes(String cuit){
        boolean encontrado = false;
        SocioProtector auxProtector = null;
        SocioParticipe auxParticipe = null;
        for (SocioProtector s : listaDeSociosProtectores) {
            if (s.getCuit().equals(cuit)){
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
                if(s.getCuit().equals(cuit)){
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
            if (s.getCuit().equals(cuit)){
                encontrado = true;
                auxProtector = s;
            }
        }
        if (encontrado == true){
            auxProtector.setEstadoDocumentacion(estado);
        }
        else{
            for (SocioParticipe s : listaDeSociosParticipes) {
                if(s.getCuit().equals(cuit)){
                    encontrado = true;
                    auxParticipe = s;
                }
            }
            if (encontrado == true){
                auxParticipe.setEstadoDocumentacion(estado);
            }
        }
    }

    public String crearSocioParticipe(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        SocioParticipe nuevoSocioParticipe = new SocioParticipe(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosParticipes.add(nuevoSocioParticipe);
        return "El socio con CUIT " + cuit + " ha sido creado correctamente.";
    }

    public String updateSocioParticipe(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit().equals(cuit)){
                s.setRazonSocial(razonSocial);
                s.setFechaInicioActividades(fechaInicioActividades);
                s.setTipo(tipo);
                s.setActividadPrincipal(actividadPrincipal);
                s.setDireccion(direccion);
                s.setTelefono(telefono);
                s.setCorreoElectronico(correoElectronico);
                s.setEsPleno(esPleno);
                s.setDocumentacion(documentacion);
                s.setFechaDocumentacion(fechaDocumentacion);
                s.setEstadoDocumentacion(estadoDocumentacion);
                s.setUsuarioDocumentacion(usuarioDocumentacion);
                return "El socio con CUIT " + s.getCuit() + " fue actualizado correctamente !";
            }
        }
        return "El socio a actualizar NO existe";
    }

    public String crearSocioProtector(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for (SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        SocioProtector nuevoSocioProtector = new SocioProtector(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion);
        listaDeSociosProtectores.add(nuevoSocioProtector);
        return "El socio con CUIT " + cuit + " ha sido creado correctamente.";
    }

    public String updateSocioProtector(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion){
        for(SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit().equals(cuit)){
                s.setRazonSocial(razonSocial);
                s.setFechaInicioActividades(fechaInicioActividades);
                s.setTipo(tipo);
                s.setActividadPrincipal(actividadPrincipal);
                s.setDireccion(direccion);
                s.setTelefono(telefono);
                s.setCorreoElectronico(correoElectronico);
                s.setEsPleno(esPleno);
                s.setDocumentacion(documentacion);
                s.setFechaDocumentacion(fechaDocumentacion);
                s.setEstadoDocumentacion(estadoDocumentacion);
                s.setUsuarioDocumentacion(usuarioDocumentacion);
                return "El socio con CUIT " + s.getCuit() + " fue actualizado correctamente !";
            }
        }
        return "El socio a actualizar NO existe";
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
