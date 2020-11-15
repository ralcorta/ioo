package Clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class OperacionController{
    SociosController controlador;
    ArrayList <LineaDeCredito> lineasDeCredito = new ArrayList<LineaDeCredito>();
    ArrayList <Operacion> operaciones = new ArrayList<Operacion>();

    public void crearLineaDeCredito(int idLineaCredito, String importeMaximo, Date fechaDeVigencia, boolean estadoAprobacion, SocioParticipe socio){
        LineaDeCredito lineaNueva = new LineaDeCredito(idLineaCredito, importeMaximo, fechaDeVigencia, estadoAprobacion, socio);
        lineasDeCredito.add(lineaNueva);
    }

    public void cargarOperacion(LineaDeCredito lc,int idOperacion, String tipoDeOperacion, String subtipoOperacion, String estado, Date fechaCambioEstado, String estadoAnterior, String usuarioModificador, String garantia, Currency importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, int cantidadTotalCuotas, float importeUtilizado){

    }

    public void modificarEstadoLineaDeCredito(int idLinea){
        boolean encontrado=false;
        Date todayDate = Calendar.getInstance().getTime();
        LineaDeCredito auxLinea = null;
        for (LineaDeCredito lc : lineasDeCredito) {
            if (lc.getIdLineaCredito() == idLinea){
                encontrado = true;
                auxLinea = lc;
            }
        }

        if (encontrado == true) {
            if(auxLinea.getFechaDeVigencia().before(todayDate)) {
                auxLinea.setEstadoAprobacion(false);
            }
        }
    }

    public void renovarLineaDeCredito(String cuit){
        boolean encontrado=false;
        Date todayDate = Calendar.getInstance().getTime();
        LineaDeCredito auxLinea = null;
        for (LineaDeCredito lc : lineasDeCredito) {
            if (lc.getSocio().getCuit().equals(cuit)){
                encontrado = true;
                auxLinea = lc;
            }
        }

        if (encontrado == true) {
            if(auxLinea.getFechaDeVigencia().before(todayDate)){
                todayDate.setYear(todayDate.getYear()+1);
                auxLinea.setFechaDeVigencia(todayDate);
            }
        }
    }

    public ArrayList<LineaDeCredito> getLineasDeCredito(){
        return lineasDeCredito;
    }

   /* public int totalComisionConChequeDia(date fecha){
        return 0;
    }*/

    /*public ArrayList<Operacion> operacionesDeSocioEnPeriodo(){
        return null;
    }*/

    /*public int riesgoVivo (SocioParticipe socio){

    }*/

    /*public int valorPromedioTasaDescuento (String tipoDeEmpresa, Date fechaDesde, Date fechaHasta){

    }*/
}
