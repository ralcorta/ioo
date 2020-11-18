package Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public class Operacion {
    private int idOperacion;
    private String tipoDeOperacion;
    private String estado;
    private String garantia;
    private String importe;
    private Date fechaCreacionOperacion;
    private Date fechaVencimiento;
    private int cuotasPagadas;
    private float importeUtilizado;
    //if tipo1
    private String nombreBancoCheque;
    private String numeroCheque;
    private String cuitCheque;
    private Date fechaVencCheque;
    private float tasaDeDescuento;
    //if tipo2
    private String cuentaCorriente;
    private Date fechaVencimientoCuentaCorriente;
    //if tipo3
    private String nombreBancoPrestamo;
    private float tasaDeInteres;
    private Date fechaDeAcreditacionPrestamo;
    private int cantidadDeCuotas;
    private String sistemaBancario;
    //fin de diferencias por tipo
    private LineaDeCredito linea;
    Comision comision;
    CertificadoDeGarantia certificadoGarantia;
    ArrayList <Cheque> cheques = new ArrayList<Cheque>();
    ArrayList <Prestamo> prestamos = new ArrayList<Prestamo>();
    ArrayList <CuentaCorriente> cuentasCorrientes = new ArrayList<CuentaCorriente>();

    public Operacion(int idOperacion, String tipoDeOperacion, String estado, String garantia, String importe, Date fechaCreacionOperacion, Date fechaVencimiento, int cuotasPagadas, float importeUtilizado, String nombreBancoCheque, Date fechaVencCheque, String numeroCheque, String cuitCheque, float tasaDeDescuento, String cuentaCorriente, Date fechaVencimientoCuentaCorriente, String nombreBancoPrestamo, float tasaDeInteres, Date fechaDeAcreditacionPrestamo, int cantidadDeCuotas, String sistemaBancario, LineaDeCredito linea) {
        this.idOperacion = idOperacion;
        this.tipoDeOperacion = tipoDeOperacion;
        this.estado = estado;
        this.garantia = garantia;
        this.importe = importe;
        this.fechaVencimiento = fechaVencCheque;
        this.fechaCreacionOperacion = fechaCreacionOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cuotasPagadas = cuotasPagadas;
        this.importeUtilizado = importeUtilizado;
        this.nombreBancoCheque = nombreBancoCheque;
        this.numeroCheque = numeroCheque;
        this.cuitCheque = cuitCheque;
        this.tasaDeDescuento = tasaDeDescuento;
        this.cuentaCorriente = cuentaCorriente;
        this.fechaVencimientoCuentaCorriente = fechaVencimientoCuentaCorriente;
        this.nombreBancoPrestamo = nombreBancoPrestamo;
        this.tasaDeInteres = tasaDeInteres;
        this.fechaDeAcreditacionPrestamo = fechaDeAcreditacionPrestamo;
        this.cantidadDeCuotas = cantidadDeCuotas;
        this.sistemaBancario = sistemaBancario;
        this.linea = linea;
    }

    public Date getFechaVencCheque(){ return this.fechaVencimiento; }

    public void setFechaVencCheque(Date fecha){ this.fechaVencimiento = fecha; }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Date getFechaCreacionOperacion() {
        return fechaCreacionOperacion;
    }

    public void setFechaCreacionOperacion(Date fechaCreacionOperacion) {
        this.fechaCreacionOperacion = fechaCreacionOperacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getImporte(){ return this.importe; }

    public void setImporte(String importe){ this.importe = importe; }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public float getImporteUtilizado() {
        return importeUtilizado;
    }

    public LineaDeCredito getLinea() {
        return linea;
    }

    public void setImporteUtilizado(float importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public String getNombreBancoCheque() {
        return nombreBancoCheque;
    }

    public void setNombreBancoCheque(String nombreBancoCheque) {
        this.nombreBancoCheque = nombreBancoCheque;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getCuitCheque() {
        return cuitCheque;
    }

    public void setCuitCheque(String cuitCheque) {
        this.cuitCheque = cuitCheque;
    }

    public float getTasaDeDescuento() {
        return tasaDeDescuento;
    }

    public void setTasaDeDescuento(float tasaDeDescuento) {
        this.tasaDeDescuento = tasaDeDescuento;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Date getFechaVencimientoCuentaCorriente() {
        return fechaVencimientoCuentaCorriente;
    }

    public void setFechaVencimientoCuentaCorriente(Date fechaVencimientoCuentaCorriente) {
        this.fechaVencimientoCuentaCorriente = fechaVencimientoCuentaCorriente;
    }

    public String getNombreBancoPrestamo() {
        return nombreBancoPrestamo;
    }

    public void setNombreBancoPrestamo(String nombreBancoPrestamo) {
        this.nombreBancoPrestamo = nombreBancoPrestamo;
    }

    public float getTasaDeInteres() {
        return tasaDeInteres;
    }

    public void setTasaDeInteres(float tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }

    public Date getFechaDeAcreditacionPrestamo() {
        return fechaDeAcreditacionPrestamo;
    }

    public void setFechaDeAcreditacionPrestamo(Date fechaDeAcreditacionPrestamo) {
        this.fechaDeAcreditacionPrestamo = fechaDeAcreditacionPrestamo;
    }

    public Comision getComision(){
        return this.comision;
    }

    public int getCantidadDeCuotas() {
        return cantidadDeCuotas;
    }

    public void setCantidadDeCuotas(int cantidadDeCuotas) {
        this.cantidadDeCuotas = cantidadDeCuotas;
    }

    public String getSistemaBancario() {
        return sistemaBancario;
    }

    public void setSistemaBancario(String sistemaBancario) {
        this.sistemaBancario = sistemaBancario;
    }

    public String generarComision(String estado, Date fechaCambioEstado, String estadoAnterior, float porcentaje){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
        String idComision = "COM"+simpleDateFormat.format(new Date());

        Comision comision = new Comision(idComision, estado, fechaCambioEstado, estadoAnterior, porcentaje);
        this.comision = comision;
        return idComision;
    }

    public float getPorcentajeComision(){
        return comision.getPorcentajeComision();
    }

    public String getIdComision(){ return comision.getIdComision(); }

    public String getEstadoComision(){ return comision.getEstado(); }

    public void emitirCertificadoGarantia(String idCertificadoGarantia, Date fechaEmision){
        CertificadoDeGarantia certificadoDeGarantia = new CertificadoDeGarantia(idCertificadoGarantia, fechaEmision);
        this.certificadoGarantia = certificadoDeGarantia;
    }

    public CertificadoDeGarantia getCertificadoGarantia(){
        return this.certificadoGarantia;
    }

    public void crearCheque(String banco, int numero, Date fechaDeVencimiento, String cuit, float tasaDeDescuento){
        Cheque cheque = new Cheque(banco, numero, fechaDeVencimiento, cuit, tasaDeDescuento);
        cheques.add(cheque);
    }

    public void crearPrestamo(String banco, float tasa, Date fechaDeAcreditacion, int cantidadDeCuotas, String sistema){
        Prestamo prestamo = new Prestamo(banco, tasa, fechaDeAcreditacion, cantidadDeCuotas, sistema);
        prestamos.add(prestamo);
    }

    public void crearCuentaCorriente(String nombreEmpresa, Date fechaDeVencimiento){
        CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreEmpresa, fechaDeVencimiento);
        cuentasCorrientes.add(cuentaCorriente);
    }

    public void generarFactura(){
        if(comision.getEstado().equals("Calculado")) {
            comision.setEstado("Facturada");
        }
    }

    public boolean vencida() {
        return this.fechaVencimiento.after(new Date());
    }
}
