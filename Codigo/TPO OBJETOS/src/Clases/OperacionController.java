package Clases;

import javax.sound.sampled.Line;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class OperacionController{
    SociosController controlador;
    ArrayList <LineaDeCredito> lineasDeCredito = new ArrayList<LineaDeCredito>();
    ArrayList <Operacion> operaciones = new ArrayList<Operacion>();

    public void setSocioController(SociosController cSocios){
        this.controlador = cSocios;
    }

    public void crearLineaDeCredito(int idLineaCredito, String importeMaximo, Date fechaDeVigencia, boolean estadoAprobacion, SocioParticipe socio){
        //TODO: LA LINEA DE CREDITO SOLO PUEDE SER CREADA SI EL SOCIO ES PLENO. EVALUAR ESTO YA QUE ACTUALMENTE ESTA MAL
        LineaDeCredito lineaNueva = new LineaDeCredito(idLineaCredito, importeMaximo, fechaDeVigencia, estadoAprobacion, socio);
        socio.setLinea(lineaNueva);
        lineasDeCredito.add(lineaNueva);
    }

    public void updateLineaDeCredito(String importeMaximo, SocioParticipe socio){
        for(LineaDeCredito ldc : lineasDeCredito) {
            if (ldc.getSocio().getCuit().equals(socio.getCuit())) {
                ldc.setImporteDisponible(Integer.toString((Integer.parseInt(importeMaximo) - (Integer.parseInt(ldc.getImporteMaximo()) - Integer.parseInt(ldc.getImporteActual())))));
                ldc.setImporteMaximo(importeMaximo);
                socio.setLinea(ldc);
            }
        }
    }

    public String crearOperacion(int idLc, String tipoDeOperacion, String estado, String garantia, String importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, float importeUtilizado,String nombreBancoCheque, String numeroCheque, Date fechaVencCheque ,String cuitCheque, float tasaDeDescuento, String cuentaCorriente, Date fechaVencimientoCuentaCorriente, String nombreBancoPrestamo, float tasaDeInteres, Date fechaDeAcreditacionPrestamo, int cantidadDeCuotas, String sistemaBancario){
        int newIdOperacion = operaciones.size()+1;
        LineaDeCredito aEnviar = obtenerLineadeCredito(idLc);

        if(Integer.parseInt(importe) <= Integer.parseInt(aEnviar.getImporteActual())) {
            Operacion nuevaOperacion = new Operacion(newIdOperacion, tipoDeOperacion, estado /*"Con certificado emitido"*/, garantia, importe, fechaCreacionOperacion, fechaVencimiento, cuotasPagadas, importeUtilizado, nombreBancoCheque, fechaVencCheque, numeroCheque, cuitCheque, tasaDeDescuento, cuentaCorriente, fechaVencimientoCuentaCorriente, nombreBancoPrestamo, tasaDeInteres, fechaDeAcreditacionPrestamo, cantidadDeCuotas, sistemaBancario, aEnviar);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
            String dateAsString = simpleDateFormat.format(new Date());
            nuevaOperacion.emitirCertificadoGarantia(dateAsString, new Date());

            operaciones.add(nuevaOperacion);

            for(LineaDeCredito ldc : lineasDeCredito){
                if(ldc.getIdLineaCredito() == idLc){
                    for(Operacion o : operaciones){
                        if(o.getIdOperacion() == idLc){
                            ldc.agregarOperacion(o);
                        }
                    }
                }
            }

            if(tipoDeOperacion == "1"){
                Cheque nuevoCheque = new Cheque(nombreBancoCheque, Integer.parseInt(numeroCheque), fechaVencCheque, cuitCheque, tasaDeDescuento,Float.parseFloat(importe));
                nuevaOperacion.cheques.add(nuevoCheque);
            }
            else if(tipoDeOperacion == "2"){
                CuentaCorriente nuevaCuenta = new CuentaCorriente(cuentaCorriente, fechaVencimientoCuentaCorriente, Float.parseFloat(importe));
                nuevaOperacion.cuentasCorrientes.add(nuevaCuenta);
            }
            else{
                Prestamo nuevoPrestamo = new Prestamo(nombreBancoPrestamo, tasaDeDescuento, fechaDeAcreditacionPrestamo,cantidadDeCuotas,sistemaBancario, Float.parseFloat(importe));
                nuevaOperacion.prestamos.add(nuevoPrestamo);
            }

            if (aEnviar == null) {
                return "No existe una linea de credito para este socio.";
            }

            aEnviar.restarImporteATotal(importe);

            return "La operacion con ID " + nuevaOperacion.getIdOperacion() + " ha sido creada con exito!";

        } else {
            Operacion nuevaOperacion = new Operacion(newIdOperacion, tipoDeOperacion, "Ingresado", garantia, importe, fechaCreacionOperacion, fechaVencimiento, cuotasPagadas, importeUtilizado, nombreBancoCheque, fechaVencCheque, numeroCheque, cuitCheque, tasaDeDescuento, cuentaCorriente, fechaVencimientoCuentaCorriente, nombreBancoPrestamo, tasaDeInteres, fechaDeAcreditacionPrestamo, cantidadDeCuotas,sistemaBancario, aEnviar);
            operaciones.add(nuevaOperacion);

            for(LineaDeCredito ldc : lineasDeCredito){
                if(ldc.getIdLineaCredito() == idLc){
                    for(Operacion o : operaciones){
                        if(o.getIdOperacion() == idLc){
                            ldc.agregarOperacion(o);
                        }
                    }
                }
            }

            if(tipoDeOperacion == "1"){
                Cheque nuevoCheque = new Cheque(nombreBancoCheque, Integer.parseInt(numeroCheque), fechaVencCheque, cuitCheque, tasaDeDescuento,Float.parseFloat(importe));
                nuevaOperacion.cheques.add(nuevoCheque);
            }
            else if(tipoDeOperacion == "2"){
                CuentaCorriente nuevaCuenta = new CuentaCorriente(cuentaCorriente, fechaVencimientoCuentaCorriente, Float.parseFloat(importe));
                nuevaOperacion.cuentasCorrientes.add(nuevaCuenta);
            }
            else{
                Prestamo nuevoPrestamo = new Prestamo(nombreBancoPrestamo, tasaDeDescuento, fechaDeAcreditacionPrestamo,cantidadDeCuotas,sistemaBancario, Float.parseFloat(importe));
                nuevaOperacion.prestamos.add(nuevoPrestamo);
            }

            return "La operacion con ID " + nuevaOperacion.getIdOperacion() + " ha sido creada con exito!";
        }

    }

    public String updateOperacion(int idOperacion, String estado, String importe){
        for (Operacion o : operaciones){
            if(o.getIdOperacion() == idOperacion){
                o.setEstado(estado);
                o.setImporte(importe);
                return "La operacion con ID " + idOperacion + " ha sido modificada correctamente.";
            }
        }
        return "La operacion a modificar NO existe";
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

    public float totalComisionConChequeDia(Date fecha){
        float totalComision = 0;
        for (Operacion o : operaciones){
             if(o.getTipoDeOperacion().equals("Tipo 1") &&
                    o.getEstado().equals("Monetizado")){ // Tipo 1 representa Cheques propios, de terceros y pagares bursatiles
                totalComision += Integer.parseInt(o.getImporte()) * o.getPorcentajeComision() / 100;
            }
        }
        return totalComision;
    }

    public ArrayList<Operacion> operacionesDeSocioEnUnPeriodo(String cuit, Date fechaDesde, Date fechaHasta){
        ArrayList<Operacion> operacionesMonetizadas = new ArrayList<>();
        for (SocioParticipe sPa : controlador.getListaDeSociosParticipes()) {
            if(sPa.getCuit().equals(cuit)){
                for (Operacion auxOpe: operaciones ) {
                    if (auxOpe.getEstado().equals("Monetizado") &&
                            (auxOpe.getFechaCreacionOperacion().after(fechaDesde) &&
                                    auxOpe.getFechaVencimiento().before(fechaHasta))){
                                operacionesMonetizadas.add(auxOpe);
                    }
                }
            }
        }
        return operacionesMonetizadas;
    }

    public String valorPromedioTasaDescuento(String tipoDeEmpresa, Date fechaDesde, Date fechaHasta){
        String mensaje = "";
        int cont=0;
        float promTasa =0.0f;
        float importeTotalChques= 0.0f;
        float importeTotalPrestamos= 0.0f;
        float importeTotalCtaCte= 0.0f;
        for(SocioParticipe s :controlador.listaDeSociosParticipes){
            if(s.getTipoDeEmpresa().equals(tipoDeEmpresa)){
                if(s.getFechaInicioActividades().after(fechaDesde) && s.getFechaInicioActividades().before(fechaHasta)){
                    ArrayList<Operacion> operacionesAux = s.linea.operaciones;
                    for(Operacion opAux: operacionesAux){
                        for(Cheque chAux:opAux.cheques){
                            promTasa= promTasa + chAux.getTasaDeDescuento();
                            importeTotalChques = importeTotalChques + chAux.getImporte();
                            cont++;
                        }
                        for(Prestamo prAux: opAux.prestamos){
                            promTasa = promTasa + prAux.getTasa();
                            importeTotalPrestamos = importeTotalPrestamos + prAux.getImporte();
                            cont++;
                        }
                        for(CuentaCorriente ctaAux : opAux.cuentasCorrientes){
                            importeTotalCtaCte = importeTotalCtaCte + ctaAux.getImporte();
                        }
                    }
                }
            }
        }
        float importePagares = importeTotalCtaCte+importeTotalPrestamos;
        if (cont == 0){
            return "No existen cheques o pagares para calcular lo que esta pidiendo.";
        }
        promTasa=promTasa/cont;
        mensaje="El promedio total de la tasa de descuento de cheques y pagares es" + promTasa + ". El importe total de cheques es" + importeTotalChques + "; el importe total de pagares es"+importePagares+".";
        return mensaje;
    }

/*
    /*public ArrayList<Operacion> operacionesDeSocioEnPeriodo(){
        return null;
    }*/

    /*public int riesgoVivo (SocioParticipe socio){

    }*/

}
