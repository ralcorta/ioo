package Clases;

import javax.sound.sampled.Line;
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

    public String crearOperacion(int idLc, String tipoDeOperacion, String estado, String garantia, String importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, float importeUtilizado,String nombreBancoCheque, String numeroCheque, Date fechaVencCheque ,String cuitCheque, float tasaDeDescuento, String cuentaCorriente, Date fechaVencimientoCuentaCorriente, String nombreBancoPrestamo, float tasaDeInteres, Date fechaDeAcreditacionPrestamo, int cantidadDeCuotas, String sistemaBancario){
        int newIdOperacion = operaciones.size()+1;
        LineaDeCredito aEnviar = obtenerLineadeCredito(idLc);

        if (aEnviar == null) {
            return "No existe una linea de credito para este socio.";
        }

        if(Integer.parseInt(importe) <= Integer.parseInt(aEnviar.getImporteActual())) {
            Operacion nuevaOperacion = new Operacion(newIdOperacion, tipoDeOperacion, "Con certificado emitido", garantia, importe, fechaCreacionOperacion, fechaVencimiento, cuotasPagadas, importeUtilizado, nombreBancoCheque, fechaVencCheque, numeroCheque, cuitCheque, tasaDeDescuento, cuentaCorriente, fechaVencimientoCuentaCorriente, nombreBancoPrestamo, tasaDeInteres, fechaDeAcreditacionPrestamo, cantidadDeCuotas, sistemaBancario, aEnviar);
            operaciones.add(nuevaOperacion);
            aEnviar.restarImporteATotal(importe);
            return "La operacion con ID " + nuevaOperacion.getIdOperacion() + " ha sido creada con exito!";
        } else {
            Operacion nuevaOperacion = new Operacion(newIdOperacion, tipoDeOperacion, "Ingresado", garantia, importe, fechaCreacionOperacion, fechaVencimiento, cuotasPagadas, importeUtilizado, nombreBancoCheque, fechaVencCheque, numeroCheque, cuitCheque, tasaDeDescuento, cuentaCorriente, fechaVencimientoCuentaCorriente, nombreBancoPrestamo, tasaDeInteres, fechaDeAcreditacionPrestamo, cantidadDeCuotas,sistemaBancario, aEnviar);
            operaciones.add(nuevaOperacion);
            return "La operacion con ID " + nuevaOperacion.getIdOperacion() + " ha sido creada con exito!";
        }
    }

    public LineaDeCredito obtenerLineadeCredito(int idLC){
        boolean encontrado= false;
        for (LineaDeCredito auxLC: lineasDeCredito) {
            if (auxLC.getIdLineaCredito() ==  idLC){
                encontrado = true;
                return auxLC;
            }
        }
        return null;
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

    public ArrayList<Operacion> getOperaciones() { return this.operaciones; }

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
