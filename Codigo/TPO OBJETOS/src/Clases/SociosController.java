package Clases;

import java.text.ParseException;
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
    }

    /*
    public boolean aprobarSocio(int cuit){
        return true;
    }

    public void registrarAporte(float monto){

    }
*/
    public float calcularComisionSocio(String tipoOperacion, String cuit){
        float totalOperaciones = 0.0f;
        float totalComisiones = 0.0f;

        for(SocioParticipe sp : listaDeSociosParticipes){
            if(sp.getCuit().equals(cuit)){
                for(Operacion o : sp.getLinea().getOperaciones()){
                    if(o.getTipoDeOperacion().equals(tipoOperacion)){
                        totalOperaciones += Float.parseFloat(o.getImporte());
                        if(o.getComision() != null)
                            totalComisiones += o.getComision().getPorcentajeComision();
                    }
                }
            }
        }

        return totalOperaciones * totalComisiones / 100;
    }

    /*
    public void calcularMoraSocio(int cuit) {

    }

    /*
    public void consultarRiesgo(int cuit) {

    }*/

    public boolean estaParaAprobar(SocioProtector s){
        return s.getEstadoDocumentacion() == true && accionesSuscritasSuficientes(s.getCuit());
    }

    public boolean estaParaAprobar(SocioParticipe s){
        return s.getEstadoDocumentacion() == true && accionesSuscritasSuficientes(s.getCuit());
    }

    public int aprobarSocio(String cuit){
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
                return 1;
            }
            else{
                return 0;
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
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
        return 2;
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

    public String crearSocioParticipe(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion, String tipoDeEmpresa){
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        for(SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        SocioParticipe nuevoSocioParticipe = new SocioParticipe(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion, tipoDeEmpresa);
        listaDeSociosParticipes.add(nuevoSocioParticipe);
        return "El socio con CUIT " + cuit + " ha sido creado correctamente.";
    }

    public String updateSocioParticipe(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion, String tipoDeEmpresa){
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
                s.setTipoDeEmpresa(tipoDeEmpresa);
                return "El socio con CUIT " + s.getCuit() + " fue actualizado correctamente !";
            }
        }
        return "El socio a actualizar NO existe";
    }

    public String crearSocioProtector(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion, String tipoDeEmpresa){
        for (SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit().equals(cuit)){
                return "El socio con CUIT " + s.getCuit() + " ya existe, no puede ser creado nuevamente.";
            }
        }
        SocioProtector nuevoSocioProtector = new SocioProtector(cuit, razonSocial, fechaInicioActividades, tipo, actividadPrincipal, direccion, telefono, correoElectronico, esPleno, documentacion, fechaDocumentacion, estadoDocumentacion, usuarioDocumentacion, tipoDeEmpresa);
        listaDeSociosProtectores.add(nuevoSocioProtector);
        return "El socio con CUIT " + cuit + " ha sido creado correctamente.";
    }

    public String updateSocioProtector(String cuit, String razonSocial, Date fechaInicioActividades, String tipo, String actividadPrincipal, String direccion, String telefono, String correoElectronico, boolean esPleno, String documentacion, Date fechaDocumentacion, Boolean estadoDocumentacion, String usuarioDocumentacion, String tipoDeEmpresa){
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
                s.setTipoDeEmpresa(tipoDeEmpresa);
                return "El socio con CUIT " + s.getCuit() + " fue actualizado correctamente !";
            }
        }
        return "El socio a actualizar NO existe";
    }

    public String crearAccionista(String cuit, int porcentajeDeParticipacion, String razonSocial, String cuitSocio){
        for (Accionistas a : listaDeAccionistas) {
            if (a.getCuit().equals(cuit)){
                return "El accionista ya existe";
            }
        }
        Accionistas nuevoAccionista = new Accionistas(cuit, porcentajeDeParticipacion, razonSocial);
        listaDeAccionistas.add(nuevoAccionista);
        for(SocioProtector s : listaDeSociosProtectores){
            if(s.getCuit().equals(cuitSocio)){
                s.agregarAccionista(nuevoAccionista);
            }
        }
        for(SocioParticipe s : listaDeSociosParticipes){
            if(s.getCuit().equals(cuitSocio)){
                s.agregarAccionista(nuevoAccionista);
            }
        }
        return "Accionista creado con exito";
    }

    public String suscribirAccion(String cuitSocio, Accion accion){
        for (SocioParticipe sPa: listaDeSociosParticipes) {
            if(sPa.getCuit().equals(cuitSocio)){
                if(accion.getTipo().equals("A")){
                    for(Accion aSusc : sPa.getAccionesSuscritas()) {
                        if(aSusc.getIdAccion().equals(accion.getIdAccion())){
                            return "La acción seleccionada ya se encuentra suscripta";
                        }
                    }
                    sPa.accionesSuscritas.add(accion);
                    return "Accion suscripta con exito!";
                }
                else {
                    return "Los Socios Participes no pueden suscribir acciones de Tipo B";
                }
            }
        }

        for(SocioProtector sPr : listaDeSociosProtectores){
            if(sPr.getCuit().equals(cuitSocio)){
                if(accion.getTipo().equals("B")){
                    for(Accion aSusc : sPr.getAccionesSuscritas()) {
                        if(aSusc.getIdAccion().equals(accion.getIdAccion())){
                            return "La acción seleccionada ya se encuentra suscripta";
                        }
                    }
                    sPr.accionesSuscritas.add(accion);
                    return "Accion suscripta con exito!";
                }
                else{
                    return "Los Socios Participes no pueden suscribir acciones de Tipo A";
                }
            }
        }
        return "La accion seleccionada no ha podido ser creada.";
    }

    public ArrayList<SocioParticipe> getListaDeSociosParticipes(){
        return this.listaDeSociosParticipes;
    }

    public ArrayList<SocioProtector> getListaDeSociosProtectores(){
        return this.listaDeSociosProtectores;
    }

}
