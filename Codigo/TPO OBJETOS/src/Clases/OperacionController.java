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
        socio.setLinea(lineaNueva);
        lineasDeCredito.add(lineaNueva);
    }

    public void updateLineaDeCredito(String importeMaximo, SocioParticipe socio){
        for(LineaDeCredito ldc : lineasDeCredito) {
            if (ldc.getSocio().getCuit().equals(socio.getCuit())) {
                ldc.setImporteMaximo(importeMaximo);
                socio.setLinea(ldc);
            }
        }
    }

    public void crearOperacion(int idLc, String tipoDeOperacion, String estado, String garantia, Currency importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, int cantidadTotalCuotas, float importeUtilizado){
        int newIdOperacion = operaciones.size()+1;
        if(tipoDeOperacion.equals("Tipo 1")){
            //Crear de forma tipo 1
        }
        else if(tipoDeOperacion.equals("Tipo 2")){
            //Crear de forma tipo 2
        }
        else if(tipoDeOperacion.equals("Tipo 3")){
            //Crear de forma tipo 3
        }
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

    public int renovarLineaDeCredito(String cuit){
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
                return 0; // Se renovo 1 año correctamente
            }
            return 1; // La linea de credito no se encuentra vencida
        }
        return -1; // No existe la linea de credito
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
