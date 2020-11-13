package Clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class OperacionController{
    SociosController controlador;
    ArrayList <LineaDeCredito> lineasDeCredito = new ArrayList<LineaDeCredito>();
    ArrayList <Operacion> operaciones = new ArrayList<Operacion>();

    public void crearLineaDeCredito(int idLineaCredito, Currency importeMaximo, Date fechaDeVigencia, boolean estadoAprobacion, Date fechaCambioEstado, String estadoAnterior, String usuarioModificador){
        LineaDeCredito lineaNueva = new LineaDeCredito(idLineaCredito, importeMaximo, fechaDeVigencia, estadoAprobacion, fechaCambioEstado, estadoAnterior, usuarioModificador);
        lineasDeCredito.add(lineaNueva);
    }

    public void crearOperacion(int idOperacion, String tipoDeOperacion, String subtipoOperacion, String estado, Date fechaCambioEstado, String estadoAnterior, String usuarioModificador, String garantia, Currency importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, int cantidadTotalCuotas, float importeUtilizado){
        Operacion operacion = new Operacion(idOperacion, tipoDeOperacion, subtipoOperacion, estado, fechaCambioEstado, estadoAnterior, usuarioModificador, garantia, importe, fechaCreacionOperacion, fechaVencimiento, cuotasPagadas, cantidadTotalCuotas, importeUtilizado);
        operaciones.add(operacion);
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
